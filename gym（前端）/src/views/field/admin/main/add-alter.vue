<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="120px">
      <el-form-item label="场地名称" prop="fieldName" required>
        <el-input v-model="ruleForm.fieldName" type="text" autocomplete="off" placeholder="请输入场地名称" />
      </el-form-item>
      <el-form-item label="场地地点" prop="fieldLocale" required>
        <el-input v-model="ruleForm.fieldLocale" type="text" autocomplete="off" placeholder="请输入场地地点" />
      </el-form-item>
      <el-form-item label="场地开放时间" prop="fieldTime" required>
        <el-input v-model="ruleForm.fieldTime" type="text" autocomplete="off" placeholder="请输入场地开放时间" />
      </el-form-item>
      <el-form-item label="场地收费说明" prop="fieldCharge" required>
        <el-input v-model="ruleForm.fieldCharge" type="text" autocomplete="off" placeholder="请输入场地收费说明" />
      </el-form-item>
      <el-form-item label="场地管理员" prop="fieldManagername" required>
        <el-input v-model="ruleForm.fieldManagername" type="text" autocomplete="off" placeholder="请输入场地管理员" />
      </el-form-item>
      <el-form-item label="场地管理员电话" prop="fieldManegertel" required>
        <el-input v-model="ruleForm.fieldManegertel" type="text" autocomplete="off" placeholder="请输入场地管理员电话" />
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
import { insertPlace, updatePlace } from '@/api/field/main'
export default {
  name: 'AddAlter',
  data() {
    return {
      ruleForm: {
        fieldName: '',
        fieldLocale: '',
        fieldTime: '',
        fieldCharge: '',
        fieldManagername: '',
        fieldManegertel: ''
      },
      isAdd: true
    }
  },
  methods: {
    cancel() {
      this.$emit('cancel')
    },
    updateSucceedEmit() {
      this.$emit('updateSucceed', this.ruleForm)
    },
    setFormData(data) {
      this.isAdd = false
      this.ruleForm = data
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.insertAlertField()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    insertAlertField() {
      // 添加场地
      if (this.isAdd) {
        insertPlace(this.ruleForm).then(response => {
          if (response.status === 200) {
            this.$message.success('场地添加成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('场地添加失败：' + response.msg)
          }
        })
      } else {
        updatePlace(this.ruleForm).then(response => {
          if (response.status === 200) {
            this.$message.success('场地修改成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('场地修改失败：' + response.msg)
          }
        })
      }
    }
  }
}
</script>

<style scoped>

</style>
