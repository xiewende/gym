<template>
  <div class="app-container">
    <div class="clearfix">
      <div style="float: left">
        <el-input v-model="searchKeyword" placeholder="请输入场地名称进行搜索" class="el-append-input">
          <el-button slot="append" icon="el-icon-search" @click="getDataByFieldName" />
        </el-input>
      </div>
      <div style="float: right">
        <el-button type="primary" icon="el-icon-plus" @click="addDialogVisible=true">添加场地</el-button>
      </div>
    </div>
    <el-table v-loading="listLoading" :data="list" border style="width: 100%;margin-top: 20px">
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column prop="fieldName" label="场地名称" />
      <el-table-column prop="fieldLocale" label="场地地点" />
      <el-table-column prop="fieldTime" label="场地开放时间" />
      <el-table-column prop="fieldManagername" label="管理员姓名" />
      <el-table-column prop="fieldManegertel" label="管理员电话" />
      <el-table-column label="场地收费">
        <template slot-scope="scope">{{ scope.row.fieldCharge }} / 小时</template>
      </el-table-column>
      <el-table-column label="场地操作" width="220" fixed="right">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="openSpecialUsageDialog(scope.$index)">设置特殊使用</el-button>
          <el-tooltip effect="dark" content="修改场地" placement="top">
            <el-button type="primary" size="mini" icon="el-icon-edit" circle @click="openAlertDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip effect="dark" content="删除场地" placement="top">
            <el-button type="danger" size="mini" icon="el-icon-delete" circle @click="openDelDialog(scope.$index)" />
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
      <el-dialog title="添加场地" :visible.sync="addDialogVisible" destroy-on-close width="40vw">
        <v-add-alter @cancel="addDialogVisible=false" @updateSucceed="addFieldSucceed" />
      </el-dialog>
      <el-dialog title="修改场地" :visible.sync="alertDialogVisible" width="40vw">
        <v-add-alter ref="alertField" @cancel="alertDialogVisible=false" @updateSucceed="alertFieldSucceed" />
      </el-dialog>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该场地吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="delField">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
      <el-dialog title="设置场地特殊使用" :visible.sync="specialUsageDialogVisible" destroy-on-close top="7vh" width="650px">
        <v-special-usage ref="specialUsage" @cancel="specialUsageDialogVisible=false" />
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { selectPlaceByFileName, deletePlace } from '@/api/field/main'

export default {
  name: 'Index',
  components: {
    'v-add-alter': () => import('@/views/field/admin/main/add-alter'),
    'v-special-usage': () => import('@/views/field/admin/main/special-usage')
  },
  data() {
    return {
      list: [],
      listLoading: true,
      addDialogVisible: false,
      alertDialogVisible: false,
      delDialogVisible: false,
      specialUsageDialogVisible: false,
      searchKeyword: '',
      operatingIndex: 0,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  created() {
    this.getData({ pageNum: 1 })
  },
  methods: {
    openAlertDialog(index) {
      this.operatingIndex = index
      this.alertDialogVisible = true
      setTimeout(() => {
        this.$refs.alertField.setFormData(this.list[index])
      }, 200)
    },
    openDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    openSpecialUsageDialog(index) {
      this.operatingIndex = index
      this.specialUsageDialogVisible = true
      setTimeout(() => {
        this.$refs.specialUsage.setFormData(this.list[index])
      }, 200)
    },
    // 删除场地
    delField() {
      this.delDialogVisible = false
      deletePlace({ id: this.list[this.operatingIndex].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('场地删除成功！')
          this.list.splice(this.operatingIndex, 1)
        } else {
          this.$message.error('场地删除失败：' + response.msg)
        }
      })
    },
    // 获取场地数据
    getData(param) {
      this.listLoading = true
      selectPlaceByFileName(param).then(response => {
        this.list = response.data.list
        this.pager.total = response.data.total
        this.pager.pageSize = response.data.pageSize
        this.listLoading = false
      })
    },
    // 搜索
    getDataByFieldName() {
      this.getData({ fieldName: this.searchKeyword, pageNum: 1 })
    },
    // 页码改变
    pageChange() {
      this.getData({ pageNum: this.pager.currentPage })
    },
    // 场地修改成功回调
    alertFieldSucceed(data) {
      this.list[this.operatingIndex] = data
    },
    // 场地添加成功回调
    addFieldSucceed() {
      this.getData({ pageNum: this.pager.currentPage })
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
</style>
