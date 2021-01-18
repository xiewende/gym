<template>
  <div class="app-container">
    <!-- 搜索与添加区域 -->
    <div class="clearfix">
      <div style="float: left;">
        <el-input v-model="searchKeyword" placeholder="请输入器材名" clearable class="el-append-input">
          <el-button slot="append" icon="el-icon-search" @click="search" />
        </el-input>
      </div>
      <div style="float: right;">
        <el-button type="primary" @click="addDialogVisible=true">添加器材</el-button>
      </div>
    </div>
    <!-- 器材列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" />
      <el-table-column label="id" prop="id" />
      <el-table-column label="器材名" prop="name" />
      <el-table-column label="租借价格(元/小时)" prop="rentPrice" />
      <el-table-column label="损坏程度" prop="damageStatus">
        <template slot-scope="scope">
          <span v-if="scope.row.damageStatus === 1">完好</span>
          <span v-else-if="scope.row.damageStatus === 2">损坏</span>
          <span v-else>报废</span>
        </template>
      </el-table-column>
      <el-table-column label="是否借出" prop="rentStatus">
        <template slot-scope="scope">
          <span v-if="scope.row.rentStatus === 1">未租借</span>
          <span v-else>已租借</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="150px" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="修改信息" placement="top" :enterable="false">
            <el-button circle type="primary" icon="el-icon-edit" size="mini" @click="showAlertDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip effect="dark" content="器材报废" placement="top" :enterable="false">
            <el-button circle type="warning" icon="el-icon-close" size="mini" @click="showScrapDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip effect="dark" content="删除器材" placement="top" :enterable="false">
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
      <el-dialog title="添加器材" :visible.sync="addDialogVisible" destroy-on-close top="5vh" width="650px">
        <v-add-alter @updateSucceed="updateSucceed" @cancel="addDialogVisible=false" />
      </el-dialog>
      <el-dialog title="修改器材" :visible.sync="alertDialogVisible" top="5vh" width="650px">
        <v-add-alter ref="alertEquipment" @cancel="alertDialogVisible=false" @updateSucceed="updateSucceed" />
      </el-dialog>
      <el-dialog title="报废器材" :visible.sync="scrapDialogVisible" width="350px">
        <div style="text-align: center">
          <el-input v-model="scrapEquipmentReason" type="textarea" :autosize="{ minRows: 3, maxRows: 10}" placeholder="请输入报废器材的原因" />
          <el-button-group style="margin-top: 20px">
            <el-button type="primary" style="width: 150px" @click="scrapEquipment">确定</el-button>
            <el-button type="info" style="width: 150px" @click="scrapDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该器材吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="delEquipment">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
    </div>

  </div>

</template>

<script>
import { mapGetters } from 'vuex'
import { deleteEquipment, getAllEquipment, queryEquipment, scrapEquipment } from '@/api/equipment/equipment'

export default {
  name: 'Equipmentlist',
  components: {
    'v-add-alter': () => import('@/views/equipment/equipment/add-alter')
  },
  data() {
    return {
      searchKeyword: '',
      scrapEquipmentReason: '',
      list: [],
      listLoading: true,
      addDialogVisible: false,
      alertDialogVisible: false,
      scrapDialogVisible: false,
      delDialogVisible: false,
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
    showAlertDialog(index) {
      this.operatingIndex = index
      this.alertDialogVisible = true
      setTimeout(() => {
        this.$refs.alertEquipment.setFormData(this.list[index])
      }, 200)
    },
    showScrapDialog(index) {
      this.operatingIndex = index
      this.scrapDialogVisible = true
    },
    showDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        queryEquipment(params).then(response => {
          if (response.status === 200) {
            this.list = response.data
          } else {
            this.$message.error('获取用户数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        getAllEquipment(params).then(response => {
          if (response.status === 200) {
            this.list = response.data.currentList
            this.pager.total = response.data.count
            this.pager.pageSize = response.data.pageSize
          } else {
            this.$message.error('获取用户数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      }
    },
    // 搜索器材
    search() {
      this.getData({
        name: this.searchKeyword
      })
    },
    pageChange() {
      this.getData({
        page: this.pager.currentPage
      })
    },
    scrapEquipment() {
      const params = {
        equipmentId: this.list[this.operatingIndex].id,
        reason: this.scrapEquipmentReason,
        user_id: this.userId
      }
      scrapEquipment(params).then(response => {
        if (response.status === 200) {
          this.scrapDialogVisible = false
          this.$message.success('器材报废成功！')
          this.getData({
            page: this.pager.currentPage
          })
        } else {
          this.$message.error('器材报废失败：' + response.msg)
        }
      })
    },
    delEquipment() {
      this.delDialogVisible = false
      deleteEquipment(this.list[this.operatingIndex].id).then(response => {
        if (response.status === 200) {
          this.$message.success('删除器材成功！')
          this.getData({
            page: this.pager.currentPage
          })
        } else {
          this.$message.error('删除器材失败：' + response.msg)
        }
      })
    },
    // 用户添加成功回调
    addSucceed() {
      this.getData({
        page: this.pager.currentPage
      })
    },
    // 用户修改成功回调
    updateSucceed() {
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
