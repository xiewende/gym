<template>
  <div>
    <el-form status-icon label-position="left" label-width="100px">
      <el-form-item label="器材名">
        <el-select v-model="equipmentName" filterable placeholder="请选择器材名称" style="width: 100%">
          <el-option v-for="item in Object.entries(equipmentOptions)" :key="item[0]" :label="item[0]" :value="item[0]" />
        </el-select>
      </el-form-item>
      <el-form-item label="租借数量">
        <el-input-number v-model="equipmentNum" :min="1" :max="equipmentMax" />
      </el-form-item>
      <el-form-item label="单价(元/h)">
        <el-input v-model="rentPrice" disabled />
      </el-form-item>
      <el-form-item label="租借时间">
        <div class="block">
          <el-date-picker
            v-model="rentTime"
            type="datetime"
            placeholder="选择日期时间"
            value-format="timestamp"
            style="width: 100%"
          />
        </div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="rentEquipment">租借</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>

import { getEquipments } from '@/api/equipment/equipment-group'
import { rentEquipment } from '@/api/rent/rentequipment'
import { mapGetters } from 'vuex'

export default {
  name: 'EquipmentDetail',
  data() {
    return {
      id: 0,
      // {name:{price:xx,ids:[ids]}}
      equipmentOptions: {},
      equipmentMax: 1,
      equipmentName: '',
      equipmentNum: 1,
      rentPrice: '',
      rentTime: '',
      temp: {}
    }
  },
  computed: {
    ...mapGetters([
      'userId'
    ])
  },
  watch: {
    equipmentName(val) {
      this.equipmentMax = this.equipmentOptions[val].ids.length
      this.rentPrice = this.equipmentOptions[val].price
    }
  },
  methods: {
    setId(id) {
      this.id = id
      this.getAvailableEquipment({
        page: 1,
        id: id
      })
    },
    // 获取可租用的器材
    getAvailableEquipment(params) {
      getEquipments(params).then(response => {
        if (response.status === 200) {
          // this.list = response.data.currentList
          for (const item of response.data.currentList) {
            if (item.damageStatus === 1 && item.rentStatus === 1) {
              if (this.temp[item.name]) {
                this.temp[item.name].ids.push(item.id)
              } else {
                this.temp[item.name] = {
                  price: item.rentPrice,
                  ids: [item.id]
                }
              }
            }
          }
          this.$set(this, 'equipmentOptions', this.temp)
        }
        const totalPages = response.data.totalPages
        const page = params.page
        if (page < totalPages) {
          this.getAvailableEquipment({
            page: page + 1,
            id: this.id
          })
        }
      })
    },
    // 租用器材
    rentEquipment() {
      for (let i = 0; i < this.equipmentNum; i++) {
        // 租用同名器材前i个
        const equipmentId = this.equipmentOptions[this.equipmentName].ids[i]
        rentEquipment({
          equipmentId: equipmentId,
          studentId: this.userId
        }).then(response => {
          if (response.status === 200) {
            this.$message.success('器材租借成功！')
            this.cancel()
            this.rentSucceed()
          } else {
            this.$message.error('器材租借失败：' + response.msg)
          }
        })
      }
    },
    cancel() {
      this.$emit('cancel')
    },
    rentSucceed() {
      this.$emit('rentSucceed')
    }
  }
}
</script>

<style lang="scss">
  .el-append-input {
    width: 300px;

    .el-input-group__append {
      background-color: #409EFF;
      border-color: #409EFF;
      color: white;
      font-size: 18px;
    }
  }

  .dashboard {
    &-container {
      margin: 30px;
    }

    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }
</style>
