<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="80px">
      <el-form-item label="id" prop="id">
        <el-input v-model="ruleForm.id" disabled />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input v-model="ruleForm.name" />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-radio v-model="ruleForm.gender" :label="1">男</el-radio>
        <el-radio v-model="ruleForm.gender" :label="2">女</el-radio>
      </el-form-item>
      <el-form-item label="学号" prop="cardNo">
        <el-input v-model="ruleForm.cardNo" />
      </el-form-item>
      <el-form-item label="出生日期" prop="birthday">
        <el-date-picker
          v-model="ruleForm.birthday"
          type="date"
          placeholder="选择日期"
          value-format="yyyy-MM-dd"
          style="width: 100%"
        />
      </el-form-item>
      <el-form-item label="联系方式" prop="phone">
        <el-input v-model="ruleForm.phone" />
      </el-form-item>
      <el-form-item label="通信地址" prop="address">
        <el-input v-model="ruleForm.address" />
      </el-form-item>
      <el-form-item label="用户角色" prop="role">
        <el-select v-model="ruleForm.role">
          <el-option label="超级管理员" :value="1" />
          <el-option label="器材管理员" :value="21" />
          <el-option label="赛事管理员" :value="22" />
          <el-option label="场地管理员" :value="23" />
          <el-option label="学生" :value="3" />
        </el-select>
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
import {
  addUser,
  updateUser
} from '@/api/user/user'
export default {
  name: 'AddAlter',
  data() {
    return {
      ruleForm: {
        name: '',
        password: '',
        gender: '',
        cardNo: '',
        birthday: '',
        phone: '',
        address: ''
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
          this.addUpdateUser()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    addUpdateUser() {
      // 添加用户
      if (this.isAdd) {
        addUser(this.ruleForm).then(response => {
          if (response.status === 200) {
            this.$message.success('用户添加成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('用户添加失败：' + response.msg)
          }
        })
      } else {
        updateUser(this.ruleForm).then(response => {
          if (response.status === 200) {
            this.$message.success('用户修改成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('用户修改失败：' + response.msg)
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
