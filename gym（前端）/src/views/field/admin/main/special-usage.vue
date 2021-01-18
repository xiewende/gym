<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-width="120px" label-position="left">
      <el-form-item label="场地名称：" prop="fieldName">
        <el-input v-model="ruleForm.fieldName" type="text" placeholder="请输入场地名称" disabled />
      </el-form-item>
      <el-form-item label="场地地点：" prop="fieldLocal">
        <el-input v-model="ruleForm.fieldLocal" type="text" placeholder="请输入场地地点" disabled />
      </el-form-item>
      <el-form-item label="租用时间：" prop="rentTime">
        <el-input v-model="ruleForm.rentTime" type="text" placeholder="请输入租用时间段" disabled />
      </el-form-item>
      <el-form-item label="租用日期：">
        <el-date-picker v-model="ruleForm.rentBegin" type="date" placeholder="请选择选择租用开始日期" value-format="yyyy-MM-dd" />
        <span style="padding: 0 10px">至</span>
        <el-date-picker v-model="ruleForm.rentEnd" type="date" placeholder="请选择选择租用结束日期" value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item label="租用类型：" prop="rentType" required>
        <el-select v-model="ruleForm.rentType" placeholder="请选择租用类型" style="width: 100%">
          <el-option label="普通申请" value="普通申请" />
          <el-option label="上课用地" value="上课用地" />
          <el-option label="校队用地" value="校队用地" />
        </el-select>
      </el-form-item>
      <el-form-item label="负责人姓名：" prop="userName" required>
        <el-input v-model="ruleForm.userName" type="text" placeholder="请输入负责人姓名" />
      </el-form-item>
      <el-form-item label="负责人电话：" prop="userTel" required>
        <el-input v-model="ruleForm.userTel" type="text" placeholder="请输入负责人电话" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { setPlaceEspecialUser } from '@/api/field/main'

export default {
  name: 'SpecialUsage',
  data() {
    return {
      ruleForm: {
        fieldLocal: '',
        fieldName: '',
        rentBegin: '',
        rentEnd: '',
        rentTime: '',
        rentType: '',
        userName: '',
        userTel: ''
      }
    }
  },
  methods: {
    cancel() {
      this.$emit('cancel')
    },
    setFormData(data) {
      this.ruleForm.fieldLocal = data.fieldLocale
      this.ruleForm.fieldName = data.fieldName
      this.ruleForm.rentTime = data.fieldTime
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.setPlaceEspecialUser()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    // 设置场地的特殊使用
    setPlaceEspecialUser() {
      setPlaceEspecialUser(this.ruleForm).then(response => {
        if (response.status === 200) {
          this.$message.success('场地特殊使用设置成功！')
          this.cancel()
        } else {
          this.$message.error('场地特殊使用设置失败：' + response.msg)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
