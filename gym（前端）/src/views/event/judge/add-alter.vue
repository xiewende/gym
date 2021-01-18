<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="80px">
      <div>
        <el-tooltip class="item" effect="dark" :content="avatarUploadTip" placement="right-start">
          <el-upload
            class="avatar-uploader"
            :show-file-list="false"
            :auto-upload="false"
            :on-change="handleAvatarChange"
            action=""
          >
            <el-image v-if="ruleForm.photoUrl" :src="ruleForm.photoUrl" fit="cover" class="avatar" />
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-tooltip>
        <div class="name-spec">
          <el-form-item label="裁判姓名" prop="name" required>
            <el-input v-model="ruleForm.name" class="inp" type="text" autocomplete="off" placeholder="请输入裁判姓名" />
          </el-form-item>
          <el-form-item label="裁判专长" prop="specialities" required>
            <el-input
              v-model="ruleForm.specialities"
              class="inp"
              type="text"
              autocomplete="off"
              placeholder="请输入裁判专长"
            />
          </el-form-item>
        </div>
      </div>
      <el-form-item label="裁判简介" prop="profile" required style="margin-top: 20px">
        <el-input
          v-model="ruleForm.profile"
          type="textarea"
          :autosize="{ minRows: 5, maxRows: 10}"
          placeholder="请输入裁判简介"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button v-if="isAdd" @click="resetForm('ruleForm')">重置</el-button>
        <el-button v-else @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { insertJudge, updateJudge } from '@/api/event/judge'

export default {
  name: 'AddAlter',
  data() {
    return {
      file: null,
      ruleForm: {
        name: '',
        photoUrl: '',
        specialities: '',
        profile: ''
      },
      isAdd: true
    }
  },
  computed: {
    avatarUploadTip() {
      if (this.ruleForm.judgePhoto) return '点击修改裁判照片'
      return '点击选择裁判照片'
    }
  },
  watch: {
    hasPhotoUrl(val) {
      if (val) this.file = val
    }
  },
  methods: {
    setFormData(data) {
      this.isAdd = false
      this.ruleForm = data
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.isAdd && this.file == null) {
            this.$message.error('请选择裁判照片')
            return
          }
          this.addAlterJudge()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
      this.ruleForm.photoUrl = ''
    },
    cancel() {
      this.$emit('cancel')
    },
    updateSucceedEmit() {
      this.$emit('updateSucceed')
    },
    // 选择照片行为
    handleAvatarChange(file, fileList) {
      this.ruleForm.photoUrl = URL.createObjectURL(file.raw)
      this.file = file.raw
    },
    // 添加/修改裁判
    addAlterJudge() {
      const fileFormData = new FormData()
      fileFormData.append('file', this.file)
      // 添加裁判
      if (this.isAdd) {
        insertJudge(this.ruleForm, fileFormData).then(response => {
          if (response.status === 200) {
            this.$message.success('裁判添加成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('裁判添加失败：' + response.msg)
          }
        })
      } else {
        if (this.file == null) {
          updateJudge(this.ruleForm).then(response => {
            if (response.status === 200) {
              this.$message.success('裁判修改成功！')
              this.updateSucceedEmit()
              this.cancel()
            } else {
              this.$message.error('裁判修改失败：' + response.msg)
            }
          })
        } else {
          updateJudge(this.ruleForm, fileFormData).then(response => {
            if (response.status === 200) {
              this.$message.success('裁判修改成功！')
              this.updateSucceedEmit()
              this.cancel()
            } else {
              this.$message.error('裁判修改失败：' + response.msg)
            }
          })
        }
      }
    }
  }
}
</script>

<style lang="scss">

  .avatar-uploader {
    display: inline-block;
    border: 1px dashed #d9d9d9;
    border-radius: 5px;
    width: 100px;
    height: 135px;

    &:hover {
      border-color: #409EFF;
    }

    .avatar {
      width: 100%;
      height: 133px;
      border-radius: 5px;
    }

    .avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 100px;
      height: 135px;
      line-height: 135px;
      text-align: center;
    }
  }

  .name-spec {
    display: inline-block;
    margin-left: 20px;
    vertical-align: top;

    .inp {
      width: 255px;
    }
  }
</style>
