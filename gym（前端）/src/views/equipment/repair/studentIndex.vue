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
    <!-- 报修列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" />
      <el-table-column label="报修记录" prop="id" width="80px" />
      <el-table-column label="报修时间">
        <template slot-scope="scope">
          {{ getDateTime(scope.row.reportDateTime) }}
        </template>
      </el-table-column>
      <el-table-column label="器材ID" prop="equipment.id" width="80px" align="center" />
      <el-table-column label="器材名称" prop="equipment.name" >
        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="点击查看详情" placement="right">
            <el-link type="primary" :underline="false" @click="showEquipDetailDialog(scope.$index)">
              {{ scope.row.equipment.name }}
            </el-link>
          </el-tooltip>
        </template>
      </el-table-column>
      <!--<el-table-column label="报修人" prop="user.name" />-->
      <el-table-column label="处理结果" prop="proceedResult">
        <template slot-scope="scope">
          <span v-if="scope.row.proceedResult === 0" style="color:#67C23A">未处理</span>
          <span v-else-if="scope.row.proceedResult === 1" style="color:#409EFF">已修复</span>
          <span v-else-if="scope.row.proceedResult === 2" style="color:#E6A23C">已损坏</span>
          <span v-else style="color:#909399">已报废</span>
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
    <el-dialog title="器材详细信息" :visible.sync="equipDetailDialog" width="350px">
      <v-equip-detail ref="equipDetail" />
    </el-dialog>

  </div>

</template>

<script>
import { mapGetters } from 'vuex'
import { getReportEquipmentById, queryReportEquipment } from '@/api/equipment/equipment'
import { dateFormat } from '@/utils/index'

export default {
  name: 'Orderlist',
  components: {
    'v-equip-detail': () => import('@/views/equipment/repair/equipment-repair-detail')
  },
  data() {
    return {
      searchKeyword: '',
      list: [],
      listLoading: true,
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
        queryReportEquipment(params).then(response => {
          if (response.status === 200) {
            this.list = [response.data]
          } else {
            this.$message.error('获取数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        const params = {
          userId: this.userId
        }
        getReportEquipmentById(params).then(response => {
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
    // 搜索维修申请
    search() {
      this.getData({
        id: this.searchKeyword
      })
    },

    pageChange() {
      this.getData({
        page: this.pager.currentPage
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
