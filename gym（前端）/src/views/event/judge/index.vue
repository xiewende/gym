<template>
  <div class="app-container">
    <div class="clearfix">
      <div style="float: right">
        <el-button v-if="!isEditingMode" type="success" icon="el-icon-edit" @click="isEditingMode=true">进入编辑模式
        </el-button>
        <el-button v-else type="warning" icon="el-icon-switch-button" @click="isEditingMode=false">退出编辑模式</el-button>
        <el-button type="primary" icon="el-icon-plus" @click="addDialogVisible=true">添加裁判</el-button>
      </div>
    </div>
    <div class="judge-content">
      <el-row v-loading="listLoading" :gutter="20">
        <el-col v-for="(item,index) in list" :key="item.$index" :xs="12" :sm="8" :lg="6" style="margin-bottom: 30px">
          <div class="clearfix edit-bar" :style="isEditingMode?'display:block':'display:none'">
            <el-tooltip class="item" effect="dark" content="修改裁判" placement="top">
              <i class="el-icon-edit" @click="openAlertDialog(index)" />
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="删除裁判" placement="top">
              <i class="el-icon-delete" @click="openDelDialog(index)" />
            </el-tooltip>
          </div>
          <div class="judge-item">
            <el-row :gutter="10">
              <el-col :span="9">
                <div class="avatar">
                  <el-image :src="item.photoUrl" class="img" fit="cover" />
                </div>
                <div class="name"><span>姓名：</span>{{ item.name }}</div>
                <div class="specialities"><span>专长：</span>{{ item.specialities }}</div>
              </el-col>
              <el-col :span="15">
                <div class="profile">
                  <div class="content">{{ item.profile }}</div>
                </div>
              </el-col>
            </el-row>
          </div>
        </el-col>
      </el-row>
    </div>
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
      <el-dialog title="添加裁判" :visible.sync="addDialogVisible" destroy-on-close width="500px">
        <v-add-alter @updateSucceed="updateSucceed" @cancel="addDialogVisible=false" />
      </el-dialog>
      <el-dialog title="修改裁判" :visible.sync="alertDialogVisible" width="500px">
        <v-add-alter ref="alterJudge" @cancel="alertDialogVisible=false" @updateSucceed="updateSucceed" />
      </el-dialog>
      <el-dialog title="提示" :visible.sync="delDialogVisible" width="350px">
        <div style="text-align: center">
          <span style="font-size: 28px">
            <i class="el-icon-warning" style="color: red;margin-right: 7px" />
            您要删除该裁判吗?
          </span>
          <el-button-group style="margin-top: 40px">
            <el-button type="primary" style="width: 120px" @click="delJudge">确定</el-button>
            <el-button type="info" style="width: 120px" @click="delDialogVisible=false">取消</el-button>
          </el-button-group>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { selectAllJudge, deleteJudge } from '@/api/event/judge'

export default {
  name: 'Index',
  components: {
    'v-add-alter': () => import('@/views/event/judge/add-alter')
  },
  data() {
    return {
      list: [],
      listLoading: true,
      addDialogVisible: false,
      alertDialogVisible: false,
      delDialogVisible: false,
      isEditingMode: false,
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
        this.$refs.alterJudge.setFormData(this.list[index])
      }, 200)
    },
    openDelDialog(index) {
      this.operatingIndex = index
      this.delDialogVisible = true
    },
    // 获取裁判数据
    getData(param) {
      this.listLoading = true
      selectAllJudge(param).then(response => {
        if (response.status === 200) {
          this.list = response.data.list
          this.pager.total = response.data.total
          this.pager.pageSize = response.data.pageSize
        } else {
          this.$message.error('获取裁判数据出错：' + response.msg)
        }
        this.listLoading = false
      })
    },
    // 页码改变
    pageChange() {
      this.getData({ pageNum: this.pager.currentPage })
    },
    // 裁判更新成功回调
    updateSucceed() {
      this.getData({ pageNum: this.pager.currentPage })
    },
    // 删除裁判
    delJudge() {
      this.delDialogVisible = false
      deleteJudge({ id: this.list[this.operatingIndex].id }).then(response => {
        if (response.status === 200) {
          this.$message.success('裁判删除成功！')
          this.list.splice(this.operatingIndex, 1)
        } else {
          this.$message.error('裁判删除失败：' + response.msg)
        }
      })
    }
  }
}
</script>

<style scoped lang="scss">
  .judge-content {
    width: 100%;
    margin-top: 20px;

    .edit-bar {
      font-size: 16px;

      * {
        cursor: pointer;
        padding: 5px 12px;
      }

      .el-icon-edit {
        color: #409EFF;
        float: left;
      }

      .el-icon-delete {
        color: #F56C6C;
        float: right;
      }
    }

    .judge-item {
      padding: 10px;
      border: 2px solid #C0C4CC;

      .avatar {
        width: 100%;
        padding-bottom: 133%;
        position: relative;
        border: 1px solid #C0C4CC;

        .img {
          width: 100%;
          height: 100%;
          bottom: 0;
          position: absolute;
        }
      }

      .name, .specialities {
        margin-top: 15px;
        line-height: 150%;

        span {
          padding-bottom: 1px;
          border-bottom: 1px solid #C0C4CC;
        }
      }

      .profile {
        width: 100%;
        padding-bottom: 180%;
        position: relative;
        border: 1px solid #C0C4CC;

        .content {
          line-height: 150%;
          overflow: scroll;
          padding: 5px;
          width: 100%;
          height: 100%;
          bottom: 0;
          position: absolute;

          &::-webkit-scrollbar {
            display: none;
          }
        }
      }
    }
  }
</style>
