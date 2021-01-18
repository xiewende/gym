<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-width="100px" label-position="left">
      <el-form-item label="场地名称：" prop="fieldName">
        <el-input v-model="fieldName" type="text" disabled />
      </el-form-item>
      <el-form-item label="场地地点：" prop="fieldLocal">
        <el-input v-model="fieldLocal" type="text" disabled />
      </el-form-item>
      <el-form-item label="学生编号：" prop="userId">
        <el-input v-model="ruleForm.userId" type="text" disabled />
      </el-form-item>
      <el-form-item label="租用时间：" prop="orderTime">
        <el-input v-model="ruleForm.orderTime" type="text" placeholder="请输入租用时间段" disabled />
      </el-form-item>
      <el-form-item label="租用日期：" prop="orderDate">
        <el-date-picker v-model="ruleForm.orderBegin" type="date" placeholder="请选择选择租用开始日期" value-format="yyyy-MM-dd" />
        <span style="padding: 0 10px">至</span>
        <el-date-picker v-model="ruleForm.orderEnd" type="date" placeholder="请选择选择租用结束日期" value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { orderField } from '@/api/field/order'
import { mapGetters } from 'vuex'

export default {
  name: 'Order',
  data() {
    return {
      fieldName: '',
      fieldLocal: '',
      ruleForm: {
        fieldId: '',
        orderBegin: '',
        orderEnd: '',
        orderTime: '',
        userId: ''
      }
    }
  },
  computed: {
    ...mapGetters([
      'userId'
    ])
  },
  created() {
    this.ruleForm.userId = this.userId
  },
  methods: {
    cancel() {
      this.$emit('cancel')
    },
    setFormData(data) {
      this.fieldLocal = data.fieldLocale
      this.fieldName = data.fieldName
      this.ruleForm.fieldId = data.id
      this.ruleForm.orderTime = data.fieldTime
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.orderField()
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
    orderField() {
      orderField(this.ruleForm).then(response => {
        if (response.status === 200) {
          this.cancel()
          this.$message.success('场地预约提交成功，请等待管理员审核！')
        } else {
          this.$message.error('场地预约提交失败：' + response.msg)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
