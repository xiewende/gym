<template>
  <div class="app-container">
    <!-- 搜索与添加区域 -->
    <div class="clearfix">
      <div style="float: left;">
        <el-input v-model="searchKeyword" placeholder="请输入id" clearable class="el-append-input">
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
      <el-table-column label="申请记录" prop="id" />
      <el-table-column label="申请器材名" prop="name" />
      <el-table-column label="申请数量" prop="count" />
      <el-table-column label="申请理由" prop="reason" />
      <!--<el-table-column label="申请人" prop="applicant.name" />-->
      <el-table-column label="是否通过">
        <template slot-scope="scope">
          <span v-if="scope.row.isApprove == false" style="color:#409EFF">未通过</span>
          <span v-else style="color:#E6A23C">已通过</span>
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-dialog title="新增申请" :visible.sync="addDialogVisible" destroy-on-close top="3vh">
        <v-add-alter @cancel="addDialogVisible=false" />
      </el-dialog>
    </div>
  </div>

</template>

<script>
import { mapGetters } from 'vuex'
import { getApplyById, queryApply } from '@/api/addapply/addapply'

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
      operatingIndex: 0
    }
  },
  computed: {
    ...mapGetters([
      'userId'
    ])
  },
  created() {
    this.getData({
    })
  },
  methods: {
    showApplyDialog(index) {
      this.operatingIndex = index
      this.applyDialogVisible = true
    },
    getData(params) {
      this.listLoading = true
      if (this.searchKeyword) {
        queryApply(params).then(response => {
          if (response.status === 200) {
            this.list = response.data
          } else {
            this.$message.error('获取用户数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      } else {
        const params = {
          userId: this.userId
        }
        getApplyById(params).then(response => {
          if (response.status === 200) {
            this.list = response.data
          } else {
            this.$message.error('获取数据出错：' + response.msg)
          }
          this.listLoading = false
        })
      }
    },
    // 申请新增成功回调
    addSucceed() {
      this.getData()
    },
    search() {
      this.getData({
        id: this.searchKeyword
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
