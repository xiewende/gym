<template>
  <div class="app-container">
    <!-- 搜索与添加区域 -->
    <div class="clearfix">
      <div style="float: left;">
        <el-input v-model="searchKeyword" placeholder="请输入器材组名" clearable class="el-append-input">
          <el-button slot="append" icon="el-icon-search" @click="search" />
        </el-input>
      </div>
      <div style="float: right;">
        <el-button type="primary" @click="addDialogVisible=true">添加分组</el-button>
      </div>
    </div>
    <!-- 器材组列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" align="center" />
      <!--<el-table-column label="id" prop="group.id" />-->
      <el-table-column label="器材组名" prop="group.name" />
      <el-table-column label="数量" prop="total" />
      <el-table-column label="可租借数量" prop="available" />
      <el-table-column label="操作" width="120px" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="修改信息" placement="top" :enterable="false">
            <el-button circle type="primary" icon="el-icon-edit" size="mini" @click="showAlertDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip effect="dark" content="删除器材组" placement="top" :enterable="false">
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
      <el-dialog title="添加分组" :visible.sync="addDialogVisible" destroy-on-close>
        <v-add-alter @updateSucceed="updateSucceed" @cancel="addDialogVisible=false" />
      </el-dialog>
      <el-dialog title="修改信息" :visible.sync="alertDialogVisible">
        <v-add-alter ref="alertEquipmentGroup" @cancel="alertDialogVisible=false" @updateSucceed="updateSucceed" />
      </el-dialog>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该分组吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="delEquipmentGroup">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
    </div>

  </div>

</template>

<script>
import { deleteEquipmentGroup, getAllEquipmentGroup, queryEquipmentGroup } from '@/api/equipment/equipment-group'

export default {
  name: 'EquipmentGrouplist',
  components: {
    'v-add-alter': () => import('@/views/equipment/equipment-group/add-alter')
  },
  data() {
    return {
      searchKeyword: '',
      list: [],
      listLoading: true,
      addDialogVisible: false,
      alertDialogVisible: false,
      delDialogVisible: false,
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
    showAlertDialog(index) {
      this.operatingIndex = index
      this.alertDialogVisible = true
      setTimeout(() => {
        this.$refs.alertEquipmentGroup.setFormData(this.list[index])
      }, 200)
    },
    showDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        queryEquipmentGroup(params).then(response => {
          if (response.status === 200) {
            this.list = response.data
          } else {
            this.$message.error('获取数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        getAllEquipmentGroup(params).then(response => {
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
    // 搜索分组
    search() {
      this.getData({ name: this.searchKeyword })
    },
    pageChange() {
      this.getData({ page: this.pager.currentPage })
    },
    delEquipmentGroup() {
      this.delDialogVisible = false
      deleteEquipmentGroup(this.list[this.operatingIndex].group.id).then(response => {
        if (response.status === 200) {
          this.$message.success('删除分组成功！')
          this.getData({ page: this.pager.currentPage })
        } else {
          this.$message.error('删除分组失败：' + response.msg)
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
