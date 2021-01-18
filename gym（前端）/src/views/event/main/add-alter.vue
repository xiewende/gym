<template>
  <div>
    <el-form ref="ruleForm" :model="ruleForm" status-icon label-position="left" label-width="80px">
      <el-form-item label="赛事项目" prop="eventItemName" required>
        <el-select v-model="ruleForm.eventItemName" filterable placeholder="请选择赛事项目" style="width: 100%">
          <el-option v-for="item in eventItemOptions" :key="item.$index" :label="item" :value="item" />
        </el-select>
      </el-form-item>
      <el-form-item label="赛事名称" prop="name" required>
        <el-input v-model="ruleForm.name" type="text" autocomplete="off" placeholder="请输入赛事名称" />
      </el-form-item>
      <el-form-item label="赛事时间">
        <el-date-picker
          v-model="ruleForm.startTime"
          type="datetime"
          placeholder="请选择赛事开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
        />
        <span style="padding: 0 15px">至</span>
        <el-date-picker
          v-model="ruleForm.endTime"
          type="datetime"
          placeholder="请选择赛事结束时间"
          value-format="yyyy-MM-dd HH:mm:ss"
        />
      </el-form-item>
      <el-form-item label="赛事场地">
        <el-select v-model="fieldOptionValue" filterable placeholder="请选择赛事场地" style="width: 100%">
          <el-option v-for="item in fieldOptions" :key="item.$index" :label="item" :value="item" />
        </el-select>
      </el-form-item>
      <el-form-item label="器材使用" prop="equipment" required>
        <el-select v-model="equipmentName" filterable placeholder="请选择器材名称" style="width: 305px">
          <el-option
            v-for="item in Object.entries(equipmentOptions)"
            :key="item.$index"
            :label="item[0]"
            :value="item[0]"
          />
        </el-select>
        <el-input-number v-model="equipmentNum" :min="1" :max="equipmentMax" />
      </el-form-item>
      <el-form-item label="赛事裁判" prop="judgeName" required>
        <el-select v-model="ruleForm.judgeName" filterable placeholder="请选择赛事裁判" style="width: 100%">
          <el-option v-for="item in judgeOptions" :key="item.$index" :label="item" :value="item" />
        </el-select>
      </el-form-item>
      <el-form-item label="参赛队伍" prop="teams" required>
        <el-input v-model="ruleForm.teams" type="text" autocomplete="off" placeholder="请输入参赛队伍" />
      </el-form-item>
      <el-form-item label="赛事备注" prop="note" required>
        <el-input
          v-model="ruleForm.note"
          type="textarea"
          :autosize="{ minRows: 4, maxRows: 10}"
          placeholder="请输入赛事备注"
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
import {
  seleEventItemsAll,
  creatCompetition,
  upsateCompetition,
  getAllEquipment,
  rentEquipment
} from '@/api/event/main'
import { selectPlaceByFileName } from '@/api/field/main'
import { selectAllJudge } from '@/api/event/judge'
import { mapGetters } from 'vuex'

export default {
  name: 'AddAlter',
  data() {
    return {
      eventItemOptions: [],
      fieldOptions: [],
      fieldOptionValue: '',
      judgeOptions: [],
      // {name:[ids]}
      equipmentOptions: {},
      equipmentMax: 1,
      equipmentName: '',
      equipmentNum: 1,
      ruleForm: {
        eventItemName: '',
        name: '',
        startTime: '',
        endTime: '',
        placeLocal: '',
        placeName: '',
        equipment: '',
        judgeName: '',
        teams: '',
        note: ''
      },
      isAdd: true
    }
  },
  computed: {
    equipment() {
      return this.equipmentName + ':' + this.equipmentNum
    },
    ...mapGetters([
      'userId'
    ])
  },
  watch: {
    fieldOptionValue(val) {
      const p = val.split('-')
      this.ruleForm.placeLocal = p[0].trim()
      this.ruleForm.placeName = p[1].trim()
    },
    equipment(val) {
      this.ruleForm.equipment = val
    },
    equipmentName(val) {
      try {
        this.equipmentMax = this.equipmentOptions[val].length || 1
      } catch (e) { console.log() }
    }
  },
  created() {
    this.getEventItemOptions(1)
    this.getFieldOptions(1)
    this.getJudgeOptions(1)
    this.getAvailableEquipment(1)
  },
  methods: {
    setFormData(data) {
      this.isAdd = false
      this.ruleForm = data
      this.fieldOptionValue = data.placeLocal + ' - ' + data.placeName
      const equip = data.equipment.split(':')
      this.equipmentName = equip[0].trim()
      this.equipmentNum = equip[1].trim()
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.createAlterEvent()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    cancel() {
      this.$emit('cancel')
    },
    updateSucceedEmit() {
      this.$emit('updateSucceed', this.ruleForm)
    },
    // 获取比赛项目下拉框数据
    getEventItemOptions(page) {
      seleEventItemsAll({ pageNum: page }).then(response => {
        if (response.status === 200) {
          for (const item of response.data.list) {
            this.eventItemOptions.push(item.name)
          }
          const nextPage = response.data.nextPage
          if (nextPage > page) this.getEventItemOptions(nextPage)
        }
      })
    },
    // 获取场地下拉框数据
    getFieldOptions(page) {
      selectPlaceByFileName({ pageNum: page }).then(response => {
        if (response.status === 200) {
          for (const item of response.data.list) {
            this.fieldOptions.push(item.fieldLocale + ' - ' + item.fieldName)
          }
          const nextPage = response.data.nextPage
          if (nextPage > page) this.getFieldOptions(nextPage)
        }
      })
    },
    // 获取场地下拉框数据
    getJudgeOptions(page) {
      selectAllJudge({ pageNum: page }).then(response => {
        if (response.status === 200) {
          for (const item of response.data.list) {
            this.judgeOptions.push(item.name)
          }
          const nextPage = response.data.nextPage
          if (nextPage > page) this.getJudgeOptions(nextPage)
        }
      })
    },
    // 获取可租用的器材
    getAvailableEquipment(page) {
      getAllEquipment({ page: page }).then(response => {
        if (response.status === 200) {
          for (const item of response.data.currentList) {
            if (item.damageStatus === 1 && item.rentStatus === 1) {
              if (this.equipmentOptions[item.name]) {
                this.equipmentOptions[item.name].push(item.id)
              } else {
                this.equipmentOptions[item.name] = [item.id]
              }
            }
          }
          const totalPages = response.data.totalPages
          if (page < totalPages) this.getAvailableEquipment(page + 1)
        }
      })
    },
    // 租用器材
    rentEquipment() {
      for (let i = 0; i < this.equipmentNum; i++) {
        const equipmentId = this.equipmentOptions[this.equipmentName][i]
        rentEquipment({ equipmentId: equipmentId, studentId: this.userId || 1 }).then(response => {
        })
      }
    },
    // 创建/修改赛事
    createAlterEvent() {
      // 创建赛事
      if (this.isAdd) {
        this.rentEquipment()
        creatCompetition(this.ruleForm).then(response => {
          if (response.status === 200) {
            this.$message.success('赛事创建成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('赛事创建失败：' + response.msg)
          }
        })
      } else {
        upsateCompetition(this.ruleForm).then(response => {
          if (response.status === 200) {
            this.$message.success('赛事修改成功！')
            this.updateSucceedEmit()
            this.cancel()
          } else {
            this.$message.error('赛事修改失败：' + response.msg)
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
