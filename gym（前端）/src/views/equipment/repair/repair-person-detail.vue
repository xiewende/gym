<template>
  <div style="width: 100%">
    <div class="detail-item">
      <div>报修人：<span>{{ data.name }}</span></div>
      <div>学号：<span>{{ data.cardNo }}</span></div>
      <div>电话：<span>{{ data.phone }}</span></div>
      <div>角色：<span>{{ role }}</span></div>
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
        cardNo: '',
        phone: '',
        role: ''
      }
    }
  },
  computed: {
    role() {
      const roleId = this.data.role
      if (roleId === 1) {
        return '超级管理员'
      } else if (roleId === 21) {
        return '器材管理员'
      } else if (roleId === 22) {
        return '赛事管理员'
      } else if (roleId === 23) {
        return '场地管理员'
      } else if (roleId === 3) {
        return '普通用户'
      }
      return ''
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
