<template>
  <div class="app-container">
    <div class="title">
      亲爱的
      <span>{{ name }}</span>
      <br><br>
      欢迎您使用海大体育馆管理系统
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
  .title{
    text-align: center;
    font-size: 36px;
    margin-top: 50px;

    span{
      color: #409EFF;
    }
  }
</style>
