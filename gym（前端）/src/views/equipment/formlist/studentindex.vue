<template>
  <div class="app-container">
    <!-- 搜索与添加区域 -->
    <div class="clearfix">
      <div style="float: left;">
        <el-input v-model="searchKeyword" placeholder="请输入id" clearable class="el-append-input">
          <el-button slot="append" icon="el-icon-search" @click="search" />
        </el-input>
      </div>
    </div>
    <!-- 订单列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" />
      <el-table-column label="订单编号" prop="id" />
      <!--<el-table-column label="学号" prop="student.cardNo" />-->
      <!--<el-table-column label="姓名" prop="student.name" />-->
      <el-table-column label="器材ID" prop="equipment.id" width="80px" align="center" />
      <el-table-column label="器材名称" prop="equipment.name">
        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="点击查看详情" placement="right">
            <el-link type="primary" :underline="false" @click="showEquipDetailDialog(scope.$index)">
              {{ scope.row.equipment.name }}
            </el-link>
          </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column label="租用时间">
        <template slot-scope="scope">
          {{ getDateTime(scope.row.rentTime) }}
        </template>
      </el-table-column>
      <el-table-column label="归还时间">
        <template slot-scope="scope">
          <span v-if="scope.row.returnTime">{{ getDateTime(scope.row.returnTime) }}</span>
          <span v-else>未归还</span>
        </template>
      </el-table-column>
      <el-table-column label="总金额">
        <template slot-scope="scope">
          <span v-if="scope.row.totalPrice">{{ scope.row.totalPrice }}</span>
          <span v-else>未归还</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="120px" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="报修" placement="top" :enterable="false">
            <el-button type="warning" icon="el-icon-edit-outline" circle size="mini" @click="showReportDialog(scope.$index)" />
          </el-tooltip>

        </template>
      </el-table-column>
    </el-table>
    <div style="text-align: center;margin: 20px 0">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size.sync="pager.pageSize"
        :current-page.sync="pager.currentPage"
        :total="pager.total"
        @current-change="pageChange"
      />
    </div>
    <div>
      <el-dialog title="维修申请" :visible.sync="reportDialogVisible" width="350px">
        <div style="text-align: center">
          <el-input v-model="reportEquipmentReason" type="textarea" :autosize="{ minRows: 3, maxRows: 10}" placeholder="请输入维修器材的原因" />
          <el-button-group style="margin-top: 20px">
            <el-button type="primary" style="width: 150px" @click="reportEquipment">确定</el-button>
            <el-button type="info" style="width: 150px" @click="reportDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
      <el-dialog title="器材详细信息" :visible.sync="equipDetailDialog" width="350px">
        <v-equip-detail ref="equipDetail" />
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { getrentOrderById, queryRentOrder } from '@/api/rent/rentequipment'
import { dateFormat } from '@/utils'
import { reportEquipment } from '@/api/equipment/equipment'

export default {
  name: 'Orderlist',
  components: {
    'v-equip-detail': () => import('@/views/equipment/repair/equipment-repair-detail')
  },
  data() {
    return {
      searchKeyword: '',
      reportEquipmentReason: '',
      list: [],
      listLoading: true,
      reportDialogVisible: false,
      equipDetailDialog: false,
      operatingIndex: 0,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  computed: {
    ...mapGetters([
      'userId'
    ])
  },
  created() {
    this.getData({
      page: 1
    })
  },
  methods: {
    getDateTime(time) {
      return dateFormat('YYYY-mm-dd HH:MM', new Date(time))
    },
    showReportDialog(index) {
      this.operatingIndex = index
      this.reportDialogVisible = true
    },
    showEquipDetailDialog(index) {
      this.operatingIndex = index
      this.equipDetailDialog = true
      setTimeout(() => {
        this.$refs.equipDetail.setFormData(this.list[index].equipment)
      }, 200)
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        queryRentOrder(params).then(response => {
          if (response.status === 200) {
            this.list = [response.data]
          } else {
            this.$message.error('获取数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        const params = {
          userId: this.userId || '1'
        }
        getrentOrderById(params).then(response => {
          if (response.status === 200) {
            this.list = response.data
            this.pager.total = response.data.count
            this.pager.pageSize = response.data.pageSize
          } else {
            this.$message.error('获取数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      }
    },
    // 搜索订单
    search() {
      this.getData({
        id: this.searchKeyword
      })
    },
    pageChange() {
      this.getData({
        page: this.pager.currentPage
      })
    },
    reportEquipment() {
      const params = {
        equipmentId: this.list[this.operatingIndex].equipment.id,
        reason: this.reportEquipmentReason,
        user_id: this.userId || '1'
      }
      reportEquipment(params).then(response => {
        if (response.status === 200) {
          this.reportDialogVisible = false
          this.$message.success('器材申请维修成功！')
          this.getData({
            page: this.pager.currentPage
          })
        } else {
          this.$message.error('器材申请维修失败：' + response.msg)
        }
      })
    }
  }
}
</script>

<style lang="scss">
  .el-append-input {
    width: 300px;

    .el-input-group__append {
      background-color: #409EFF;
      border-color: #409EFF;
      color: white;
      font-size: 18px;
    }
  }

  .dashboard {
    &-container {
      margin: 30px;
    }

    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }
</style>
