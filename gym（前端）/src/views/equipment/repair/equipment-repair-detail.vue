<template>
  <div style="width: 100%">
    <div class="detail-item">
      <div>器材名：<span>{{ data.name }}</span></div>
      <div>损坏程度：<span>{{ damageStatus }}</span></div>
      <div>出租状态：<span>{{ rentStatus }}</span></div>
      <div>租赁价格：<span>{{ data.rentPrice }} 元/小时</span></div>
      <div>进购价格：<span>{{ data.salePrice }} 元/件</span></div>
      <div>器材组：<span>{{ data.equipmentGroup.name }}</span></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UsageDetail',
  data() {
    return {
      data: {
        name: '',
        rentPrice: '',
        damageStatus: '',
        rentStatus: '',
        salePrice: '',
        equipmentGroup: {
          name: ''
        }
      }
    }
  },
  computed: {
    damageStatus() {
      let status_string = ''
      const status = this.data.damageStatus
      if (status === 1) {
        status_string = '完好'
      } else if (status === 2) {
        status_string = '损坏'
      } else if (status === 3) {
        status_string = '报废'
      }
      return status_string
    },
    rentStatus() {
      let status_string = ''
      const status = this.data.rentStatus
      if (status === 1) {
        status_string = '未出租'
      } else if (status === 2) {
        status_string = '已出租'
      }
      return status_string
    }
  },
  methods: {
    setFormData(data) {
      this.data = data
    }
  }
}
</script>

<style scoped lang="scss">
  .detail-item{
    div{
      padding: 10px 0;
      font-size: 18px;
    }
    width: 100%;
  }
</style>
