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
    <!-- 报废列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" />
      <el-table-column label="报废记录" prop="id" width="80px" />
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
      <el-table-column label="报废原因" prop="reason" />
      <el-table-column label="报废人" prop="user.name">
        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="点击查看详情" placement="right">
            <el-link type="primary" :underline="false" @click="showPersonDetailDialog(scope.$index)">
              {{ scope.row.user.name }}
            </el-link>
          </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="50px" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="删除记录" placement="top" :enterable="false">
            <el-button circle type="danger" icon="el-icon-delete" size="mini" @click="showDelDialog(scope.$index)" />
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
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该记录吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="deleteScrapEquipment">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
      <el-dialog title="器材详细信息" :visible.sync="equipDetailDialog" width="350px">
        <v-equip-detail ref="equipDetail" />
      </el-dialog>
      <el-dialog title="报废人详细信息" :visible.sync="personDetailDialog" width="350px">
        <v-person-detail ref="personDetail" />
      </el-dialog>
    </div>
  </div>

</template>

<script>
import { deleteScrapEquipment, getAllScrapEquipment, queryScrapEquipment } from '@/api/equipment/equipment'
import { dateFormat } from '@/utils'

export default {
  name: 'Orderlist',
  components: {
    'v-equip-detail': () => import('@/views/equipment/repair/equipment-repair-detail'),
    'v-person-detail': () => import('@/views/equipment/repair/repair-person-detail')
  },
  data() {
    return {
      searchKeyword: '',
      list: [],
      listLoading: true,
      delDialogVisible: false,
      equipDetailDialog: false,
      personDetailDialog: false,
      operatingIndex: 0,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
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
    showDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    showEquipDetailDialog(index) {
      this.operatingIndex = index
      this.equipDetailDialog = true
      setTimeout(() => {
        this.$refs.equipDetail.setFormData(this.list[index].equipment)
      }, 200)
    },
    showPersonDetailDialog(index) {
      this.operatingIndex = index
      this.personDetailDialog = true
      setTimeout(() => {
        this.$refs.personDetail.setFormData(this.list[index].user)
      }, 200)
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        queryScrapEquipment(params).then(response => {
          if (response.status === 200) {
            this.list = [response.data]
          } else {
            this.$message.error('获取数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        getAllScrapEquipment(params).then(response => {
          if (response.status === 200) {
            this.list = response.data.currentList
            this.pager.total = response.data.count
            this.pager.pageSize = response.data.pageSize
          } else {
            this.$message.error('获取数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      }
    },
    // 搜索报废器材
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
    deleteScrapEquipment() {
      this.delDialogVisible = false
      deleteScrapEquipment(this.list[this.operatingIndex].id).then(response => {
        if (response.status === 200) {
          this.$message.success('删除记录成功！')
          this.getData({
            page: this.pager.currentPage
          })
        } else {
          this.$message.error('删除记录失败：' + response.msg)
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
