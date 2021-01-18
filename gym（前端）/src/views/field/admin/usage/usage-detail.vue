<template>
  <div style="width: 100%">
    <div class="detail-item">
      <div>场地名称：<span>{{ data.fieldName }}</span></div>
      <div>场地地点：<span>{{ data.fieldLocale }}</span></div>
      <div>场地收费标准：<span>{{ data.rentCharge }} / 小时</span></div>
      <!--<div>场地管理员姓名：<span>{{ data.fieldLocale }}</span></div>-->
      <!--<div>场地管理员电话：<span>{{ data.fieldLocale }}</span></div>-->
      <div>场地使用日期：<span>{{ data.rentBegin }} - {{ data.rentEnd }}</span></div>
      <div>场地使用时间段：<span>{{ data.fieldTime }}</span></div>
      <div>使用负责人姓名：<span>{{ data.userName }}</span></div>
      <div>使用负责人电话：<span>{{ data.userTel }}</span></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UsageDetail',
  data() {
    return {
      data: {}
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
