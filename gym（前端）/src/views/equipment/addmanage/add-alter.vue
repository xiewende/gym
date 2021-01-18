<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="80px">
      <el-form-item label="id" prop="id">
        <el-input v-model="ruleForm.id" disabled />
      </el-form-item>
      <el-form-item label="器材名" prop="name">
        <el-input v-model="ruleForm.name" />
      </el-form-item>
      <el-form-item label="申请数量" prop="count">
        <el-input v-model="ruleForm.count" />
      </el-form-item>
      <el-form-item label="申请理由" prop="reason">
        <el-input v-model="ruleForm.reason" />
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
import { mapGetters } from 'vuex'
import { addApply } from '@/api/addapply/addapply'

export default {
  name: 'AddAlter',
  data() {
    return {
      ruleForm: {
        id: '',
        name: '',
        count: '',
        reason: ''
      },
      isAdd: true
    }
  },
  computed: {
    ...mapGetters([
      'userId'
    ])
  },
  methods: {
    cancel() {
      this.$emit('cancel')
    },
    updateSucceedEmit() {
      this.$emit('updateSucceed')
    },
    setFormData(data) {
      this.isAdd = false
      this.ruleForm = data
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.addUpdateApply()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    addUpdateApply() {
      // 添加申请
      if (this.isAdd) {
        const params = {
          user: this.userId,
          id: this.ruleForm.id,
          name: this.ruleForm.name,
          count: this.ruleForm.count,
          reason: this.ruleForm.reason
        }
        addApply(params).then(response => {
          if (response.status === 200) {
            this.$message.success('申请添加成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('申请添加失败：' + response.msg)
          }
        })
      }
    }

  }
}
</script>

<style lang="scss">
  .event-equipment {
    .el-input-group__append {
      padding: 0;
      border: none;
    }
  }
</style>
