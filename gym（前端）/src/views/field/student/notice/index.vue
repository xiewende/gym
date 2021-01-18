<template>
  <div class="app-container">
    <div class="notice">
      <h1 class="title">{{ notice.announcementTitle }}</h1>
      <div class="content">{{ notice.announcementConten }}</div>
      <div class="signature clearfix">
        <div v-if="succeed" class="left">特此通知</div>
        <div class="right">
          <div>{{ notice.announcementAuthor }}</div>
          <div>{{ notice.announcementTime }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { selectByRencent } from '@/api/field/notice'

export default {
  name: 'Index',
  data() {
    return {
      notice: {
        announcementTitle: '',
        announcementConten: '',
        announcementAuthor: '',
        announcementTime: ''
      },
      succeed: false
    }
  },
  created() {
    selectByRencent().then(response => {
      if (response.status === 200) {
        this.notice = response.data
        this.succeed = true
      } else {
        this.$message.error('公告显示出错：' + response.msg)
      }
    })
  }
}
</script>

<style scoped lang="scss">
  .notice {
    width: 50%;
    margin: 50px auto 0;

    .title {
      text-align: center;
    }

    .content {
      line-height: 150%;
      font-size: 18px;
      word-wrap: break-word;
    }

    .signature {
      margin-top: 20px;
      font-size: 18px;

      div {
        padding: 5px 0;
      }

      .right {
        float: right;
      }
    }
  }
</style>
