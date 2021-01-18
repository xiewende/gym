<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="80px">
      <el-form-item label="公告标题" prop="announcementTitle" required>
        <el-input v-model="ruleForm.announcementTitle" type="text" autocomplete="off" />
      </el-form-item>
      <el-form-item label="公告内容" prop="announcementConten" required>
        <el-input
          v-model="ruleForm.announcementConten"
          type="textarea"
          :autosize="{ minRows: 5, maxRows: 10}"
          placeholder="请输入公告内容"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { insertAnnouncement } from '@/api/field/notice'

export default {
  name: 'AddAlter',
  data() {
    return {
      ruleForm: {
        announcementAuthor: this.name || '场地管理员',
        announcementTitle: '',
        announcementConten: ''
      }
    }
  },
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.insertNotice()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    cancel() {
      this.$emit('cancel')
    },
    addSucceedEmit() {
      this.$emit('addSucceed')
    },
    insertNotice() {
      // 添加公告
      insertAnnouncement(this.ruleForm).then(response => {
        if (response.status === 200) {
          this.$message.success('公告添加成功！')
          this.cancel()
          this.addSucceedEmit()
        } else {
          this.$message.error('公告添加失败：' + response.msg)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
