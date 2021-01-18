<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="80px">
      <el-form-item label="器材名" prop="name">
        <el-input v-model="ruleForm.name" />
      </el-form-item>
      <el-form-item label="器材组" prop="equipmentGroup">
        <el-select v-model="ruleForm.equipmentGroup" filterable placeholder="请选择" style="width: 100%;">
          <el-option
            v-for="(item,index) in equipmentGroupOptions"
            :key="index"
            :label="item.group.name"
            :value="item.group.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="买进价格" prop="salePrice">
        <el-input v-model="ruleForm.salePrice" />
      </el-form-item>
      <el-form-item label="租用价格" prop="rentPrice">
        <el-input v-model="ruleForm.rentPrice" />
      </el-form-item>
      <el-form-item v-if="isAdd" label="数量" prop="num">
        <el-input v-model="num" />
      </el-form-item>
      <el-form-item label="损坏程度" prop="damageStatus">
        <el-select v-model="ruleForm.damageStatus" style="width: 100%">
          <el-option label="完好" value="1" />
          <el-option label="损坏" value="2" />
          <el-option label="报废" value="3" />
        </el-select>
      </el-form-item>
      <el-form-item label="是否借出" prop="rentStatus">
        <el-select v-model="ruleForm.rentStatus" style="width: 100%">
          <el-option label="未租借" value="1" />
          <el-option label="已租借" value="2" />
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
import { addEquipment, updateEquipment } from '@/api/equipment/equipment'
import { getAllEquipmentGroup } from '@/api/equipment/equipment-group'

export default {
  name: 'AddAlter',
  data() {
    return {
      equipmentGroupOptions: [],
      num: '',
      ruleForm: {
        name: '',
        salePrice: '',
        rentPrice: '',
        damageStatus: '',
        rentStatus: '',
        equipmentGroup: ''
      },
      isAdd: true
    }
  },
  created() {
    this.getEquipmentGroupOptions(1)
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
      this.ruleForm.equipmentGroup = data.equipmentGroup.id
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.addUpdateEquipment()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    addUpdateEquipment() {
      // 添加器材
      if (this.isAdd) {
        for (let i = 0; i < this.num; i++) {
          addEquipment(this.ruleForm).then(response => {
            if (response.status === 200) {
              this.$message.success('器材添加成功！')
              this.updateSucceedEmit()
              this.cancel()
            } else {
              this.$message.error('器材添加失败：' + response.msg)
            }
          })
        }
      } else {
        updateEquipment(this.ruleForm).then(response => {
          if (response.status === 200) {
            this.$message.success('器材修改成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('器材修改失败：' + response.msg)
          }
        })
      }
    },
    getEquipmentGroupOptions(page) {
      getAllEquipmentGroup({
        page: page
      }).then(response => {
        if (response.status === 200) {
          const group = response.data.currentList
          this.equipmentGroupOptions.push(...group)
        }
        const totalPages = response.data.totalPages
        if (page < totalPages) {
          this.getEquipmentGroupOptions({
            page: page + 1
          })
        }
      })
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
