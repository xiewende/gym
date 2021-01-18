<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="80px">
      <el-form-item v-if="!isAdd" label="id" prop="id">
        <el-input v-model="ruleForm.group.id" :disabled="true" />
      </el-form-item>
      <el-form-item label="器材组名" prop="name">
        <el-input v-model="ruleForm.group.name" />
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
import { addEquipmentGroup, updateEquipmentGroup } from '@/api/equipment/equipment-group'

export default {
  name: 'AddAlter',
  data() {
    return {
      ruleForm: {
        group: {
          id: '',
          name: ''
        }
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
          this.addUpdateEquipmentGroup()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    addUpdateEquipmentGroup() {
      // 添加器材分组
      if (this.isAdd) {
        addEquipmentGroup(this.ruleForm.group).then(response => {
          if (response.status === 200) {
            this.$message.success('分组添加成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('分组添加失败：' + response.msg)
          }
        })
      } else {
        updateEquipmentGroup(this.ruleForm.group).then(response => {
          if (response.status === 200) {
            this.$message.success('分组修改成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('分组修改失败：' + response.msg)
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
