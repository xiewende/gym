<template>
  <div class="app-container">
    <!-- 搜索与添加区域 -->
    <div class="clearfix">
      <div style="float: left;">
        <el-input v-model="searchKeyword" placeholder="请输入学号" clearable class="el-append-input">
          <el-button slot="append" icon="el-icon-search" @click="search" />
        </el-input>
      </div>
      <div style="float: right;">
        <el-button type="primary" @click="addDialogVisible=true">添加用户</el-button>
      </div>
    </div>
    <!-- 用户列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" align="center" />
      <el-table-column label="学号" prop="cardNo" />
      <el-table-column label="姓名" prop="name" />
      <el-table-column label="性别" prop="gender">
        <template slot-scope="scope">
          <span v-if="scope.row.gender ===2">女</span>
          <span v-else>男</span>
        </template>
      </el-table-column>
      <el-table-column label="出生日期" prop="birthday" value-format="yyyy-MM-dd" />
      <el-table-column label="联系方式" prop="phone" />
      <el-table-column label="通信地址" prop="address" />
      <el-table-column label="角色" prop="role">
        <template slot-scope="scope">
          <span v-if="scope.row.role === 1">超级管理员</span>
          <span v-else-if="scope.row.role === 21">器材管理员</span>
          <span v-else-if="scope.row.role === 22">赛事管理员</span>
          <span v-else-if="scope.row.role === 23">场地管理员</span>
          <span v-else>学生</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="120px" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="修改信息" placement="top" :enterable="false">
            <el-button circle type="primary" icon="el-icon-edit" size="mini" @click="showAlertDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip effect="dark" content="删除用户" placement="top" :enterable="false">
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
      <el-dialog title="添加用户" :visible.sync="addDialogVisible" destroy-on-close top="3vh">
        <v-add-alter @updateSucceed="updateSucceed" @cancel="addDialogVisible=false" />
      </el-dialog>
      <el-dialog title="修改用户" :visible.sync="alertDialogVisible" top="3vh">
        <v-add-alter ref="alertUser" @cancel="alertDialogVisible=false" @updateSucceed="updateSucceed" />
      </el-dialog>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该用户吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="delUser">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
    </div>

  </div>

</template>

<script>
import {
  getAllUser,
  deleteUser,
  queryUser
} from '@/api/user/user'

export default {
  name: 'Userlist',
  components: {
    'v-add-alter': () => import('@/views/user/userlist/add-alter')
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
        this.$refs.alertUser.setFormData(this.list[index])
      }, 200)
    },
    showDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        queryUser(params).then(response => {
          if (response.status === 200) {
            this.list = [response.data]
          } else {
            this.$message.error('获取用户数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        getAllUser(params).then(response => {
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
    // 搜索用户
    search() {
      this.getData({
        card_no: this.searchKeyword
      })
      // console.log( this.getData({ pageNum: 1, cardNo: this.searchKeyword }))
    },
    pageChange() {
      this.getData({
        page: this.pager.currentPage
      })
    },
    delUser() {
      this.delDialogVisible = false
      deleteUser(this.list[this.operatingIndex].id).then(response => {
        if (response.status === 200) {
          this.$message.success('删除用户成功！')
          this.getData({
            page: this.pager.currentPage
          })
        } else {
          this.$message.error('删除用户失败：' + response.msg)
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
