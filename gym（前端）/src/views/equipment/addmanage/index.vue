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
        <el-button type="primary" @click="addDialogVisible=true">新增申请</el-button>
      </div>
    </div>
    <!-- 新增申请列表 -->
    <el-table v-loading="listLoading" :data="list" border stripe style="margin-top: 20px">
      <el-table-column type="index" />
      <el-table-column label="新增记录" prop="id" />
      <el-table-column label="申请器材名" prop="name" />
      <el-table-column label="申请数量" prop="count" />
      <el-table-column label="申请理由" prop="reason" />
      <el-table-column label="申请人" prop="applicant.name" />
      <el-table-column label="是否通过">
        <template slot-scope="scope">
          <!-- <span v-if="scope.row.isApprove === 0" style="color:#67C23A">未处理</span> -->
          <span v-if="scope.row.isApprove == false" style="color:#409EFF">未通过</span>
          <span v-else style="color:#E6A23C">已通过</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="150px" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="回复结果" placement="top" :enterable="false">
            <el-button circle type="primary" icon="el-icon-reading" size="mini" @click="showApplyDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip effect="dark" content="删除申请" placement="top" :enterable="false">
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
      <el-dialog title="新增申请" :visible.sync="addDialogVisible" destroy-on-close top="3vh">
        <v-add-alter @updateSucceed="addSucceed" @cancel="addDialogVisible=false" />
      </el-dialog>
      <el-dialog title="提示" :visible.sync="applyDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 25px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            确认是否阅读该申请?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="updateApply">确定</el-button>
            <el-button type="info" style="width: 120px" @click="applyDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>

      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该申请吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="delApply">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
    </div>

  </div>

</template>

<script>
import { mapGetters } from 'vuex'
import { deleteApply, getAllApply, getApplyByName, updateApply } from '@/api/addapply/addapply'

export default {
  name: 'Applylist',
  components: {
    'v-add-alter': () => import('@/views/equipment/addmanage/add-alter')
  },
  data() {
    return {
      searchKeyword: '',
      list: [],
      listLoading: true,
      addDialogVisible: false,
      delDialogVisible: false,
      applyDialogVisible: false,
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
    showDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    showApplyDialog(index) {
      this.operatingIndex = index
      this.applyDialogVisible = true
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        getApplyByName(params).then(response => {
          if (response.status === 200) {
            this.list = response.data
          } else {
            this.$message.error('获取用户数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        getAllApply(params).then(response => {
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
    // 搜索申请
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

    delApply() {
      this.delDialogVisible = false
      deleteApply(this.list[this.operatingIndex].id).then(response => {
        if (response.status === 200) {
          this.$message.success('删除记录成功！')
          this.getData({
            page: this.pager.currentPage
          })
        } else {
          this.$message.error('删除记录失败：' + response.msg)
        }
      })
    },
    updateApply() {
      this.applyDialogVisible = false
      const params = {
        id: this.list[this.operatingIndex].id,
        reason: this.list[this.operatingIndex].reason,
        user: this.userId,
        count: this.list[this.operatingIndex].count,
        isApprove: true,
        name: this.list[this.operatingIndex].name
      }
      updateApply(params).then(response => {
        if (response.status === 200) {
          this.$message.success('回复成功！')
          this.getData({
            page: this.pager.currentPage
          })
        } else {
          this.$message.error('回复失败！' + response.msg)
        }
      })
    },
    // 申请新增成功回调
    addSucceed() {
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
