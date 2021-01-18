<template>
  <div class="app-container">
    <div class="clearfix">
      <div style="float: left" class="event-action-left">
        <el-select v-model="statusOptionValue" placeholder="请选择赛事状态" style="width: 150px">
          <el-option label="全部" value="" />
          <el-option label="已取消" value="已取消" />
          <el-option label="创建成功" value="创建成功" />
        </el-select>
        <el-input v-model="searchKeyword" placeholder="请输入赛事名称进行搜索" class="el-append-input">
          <el-button slot="append" icon="el-icon-search" @click="search" />
        </el-input>
      </div>
      <div style="float: right">
        <el-button type="primary" icon="el-icon-plus" @click="addDialogVisible=true">创建赛事</el-button>
      </div>
    </div>
    <el-table v-loading="listLoading" :data="list" border style="width: 100%;margin-top: 20px">
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">{{ scope.$index + 1 }}</template>
      </el-table-column>
      <el-table-column prop="statusString" label="状态" align="center" width="120" />
      <el-table-column prop="eventItemName" label="赛事项目" />
      <el-table-column prop="name" label="赛事名称" />
      <el-table-column prop="startTime" label="开始时间" />
      <el-table-column prop="endTime" label="结束时间" />
      <el-table-column label="赛事场地">
        <template slot-scope="scope">{{ scope.row.placeLocal }} - {{ scope.row.placeName }}</template>
      </el-table-column>
      <el-table-column label="操作" width="150" fixed="right" align="center">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="修改赛事" placement="top">
            <el-button type="primary" size="mini" icon="el-icon-edit" circle @click="openAlertDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip v-if="scope.row.statusString!=='已取消'" effect="dark" content="取消赛事" placement="top">
            <el-button type="warning" size="mini" icon="el-icon-close" circle @click="openCancelDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip v-else effect="dark" content="删除赛事" placement="top">
            <el-button type="danger" size="mini" icon="el-icon-delete" circle @click="openDeleteDialog(scope.$index)" />
          </el-tooltip>
          <el-tooltip v-if="scope.row.note" effect="dark" content="查看备注" placement="top">
            <el-button
              type="info"
              size="mini"
              icon="el-icon-chat-line-square"
              circle
              @click="openNoteDialog(scope.$index)"
            />
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
      <el-dialog title="添加赛事" :visible.sync="addDialogVisible" destroy-on-close top="5vh" width="750px">
        <v-add-alter @updateSucceed="addEventSucceed" />
      </el-dialog>
      <el-dialog title="修改赛事" :visible.sync="alertDialogVisible" top="5vh" width="750px">
        <v-add-alter ref="alertEvent" @cancel="alertDialogVisible=false" @updateSucceed="alertEventSucceed" />
      </el-dialog>
      <el-dialog title="提示" :visible.sync="cancelDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: #ff0000;margin-right: 7px" />
            您要取消该赛事吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="cancelEvent">确定</el-button>
            <el-button type="info" style="width: 120px" @click="cancelDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该赛事吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="deleteEvent">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
      <el-dialog title="赛事备注" :visible.sync="noteDialogVisible" width="40vw">
        <span style="font-size: 16px;line-height: 150%">{{ currentNote }}</span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { selectAllByCompetitionName, quxiaoConpetition, deleteConpetition } from '@/api/event/main'

export default {
  name: 'Index',
  components: {
    'v-add-alter': () => import('@/views/event/main/add-alter')
  },
  data() {
    return {
      statusOptionValue: '',
      searchKeyword: '',
      list: [],
      listLoading: true,
      addDialogVisible: false,
      alertDialogVisible: false,
      cancelDialogVisible: false,
      delDialogVisible: false,
      noteDialogVisible: false,
      operatingIndex: 0,
      pager: {
        total: 0,
        currentPage: 1,
        pageSize: 0
      }
    }
  },
  computed: {
    currentNote() {
      try {
        return this.list[this.operatingIndex].note
      } catch (e) {
        return ''
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
        this.$refs.alertEvent.setFormData(this.list[index])
      }, 200)
    },
    openNoteDialog(index) {
      this.operatingIndex = index
      this.noteDialogVisible = true
    },
    openCancelDialog(index) {
      this.operatingIndex = index
      this.cancelDialogVisible = true
    },
    openDeleteDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    // 获取场地数据
    getData(param) {
      this.listLoading = true
      selectAllByCompetitionName(param).then(response => {
        if (response.status === 200) {
          this.list = response.data.list
          this.pager.total = response.data.total
          this.pager.pageSize = response.data.pageSize
        } else {
          this.$message.error('获取场地数据出错：' + response.msg)
        }
        this.listLoading = false
      })
    },
    // 搜索赛事
    search() {
      this.getData({ pageNum: 1, status: this.statusOptionValue, competionname: this.searchKeyword })
    },
    // 页码改变
    pageChange() {
      this.getData({ pageNum: this.pager.currentPage })
    },
    // 取消赛事
    cancelEvent() {
      this.cancelDialogVisible = false
      quxiaoConpetition({ id: this.list[this.operatingIndex].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('取消赛事成功！')
          this.getData({ pageNum: this.pager.currentPage })
        } else {
          this.$message.error('取消赛事失败：' + response.msg)
        }
      })
    },
    // 删除赛事
    deleteEvent() {
      this.delDialogVisible = false
      deleteConpetition({ id: this.list[this.operatingIndex].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('赛事删除成功！')
          this.list.splice(this.operatingIndex, 1)
        } else {
          this.$message.error('赛事删除失败：' + response.msg)
        }
      })
    },
    // 赛事修改成功回调
    alertEventSucceed(data) {
      this.list[this.operatingIndex] = data
    },
    // 赛事添加成功回调
    addEventSucceed() {
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

<style scoped lang="scss">
  .event-action-left {
    el-select:nth-child(1) {
      width: 100px;
    }
  }
</style>
