<template>
  <div class="app-container">
    <div class="clearfix">
      <div style="float: right">
        <el-button type="primary" icon="el-icon-plus" @click="addDialogVisible=true">添加公告</el-button>
      </div>
    </div>
    <el-table v-loading="listLoading" :data="list" border style="width: 100%;margin-top: 20px">
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column prop="announcementTitle" label="公告标题" width="280px" show-overflow-tooltip />
      <el-table-column prop="announcementAuthor" label="发布者" width="180px" align="center" />
      <el-table-column prop="announcementTime" label="发布时间" width="200px" align="center" />
      <el-table-column prop="announcementConten" label="公告内容" show-overflow-tooltip />
      <el-table-column label="操作" width="80" fixed="right" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="删除公告" placement="top">
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
      <el-dialog title="添加公告" :visible.sync="addDialogVisible" destroy-on-close>
        <v-add-alter @cancel="addDialogVisible=false" @addSucceed="addNoticeSucceed" />
      </el-dialog>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该公告吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="delNotice">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { listAllAnnouncement, deleteAnnouncement } from '@/api/field/notice'
export default {
  name: 'Index',
  components: {
    'v-add-alter': () => import('@/views/field/admin/notice/add-alter')
  },
  data() {
    return {
      list: [],
      listLoading: true,
      addDialogVisible: false,
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
    this.getData({ pageNum: 1 })
  },
  methods: {
    openDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    getData(params) {
      this.listLoading = true
      listAllAnnouncement(params).then(response => {
        this.list = response.data.list
        this.pager.total = response.data.total
        this.pager.pageSize = response.data.pageSize
        this.listLoading = false
      })
    },
    pageChange() {
      this.getData({ pageNum: this.pager.currentPage })
    },
    // 删除公告
    delNotice() {
      this.delDialogVisible = false
      deleteAnnouncement({ id: this.list[this.operatingIndex].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('公告删除成功！')
          this.list.splice(this.operatingIndex, 1)
          this.getData({ pageNum: this.pager.currentPage })
        } else {
          this.$message.error('公告删除失败：' + response.msg)
        }
      })
    },
    addNoticeSucceed() {
      this.getData({ pageNum: this.pager.currentPage })
    }
  }
}
</script>

<style lang="scss">
   .el-tooltip__popper {
     max-width: 30%;
     line-height: 150%;
   }
</style>

<style scoped lang="scss">

</style>
