<template>
  <div class="navbar">
    <hamburger
      :is-active="sidebar.opened"
      class="hamburger-container"
      @toggleClick="toggleSideBar"
    />

    <breadcrumb class="breadcrumb-container" />

    <div class="right-menu">
      <el-dropdown class="avatar-container" trigger="hover">
        <div class="avatar-wrapper">
          <el-avatar :size="32" :src="avatar" fit="contain" />
          <span class="name">{{ name }}</span>
          <i class="el-icon-caret-bottom" />
        </div>
        <el-dropdown-menu slot="dropdown" class="user-dropdown">
          <router-link to="/">
            <el-dropdown-item>首页</el-dropdown-item>
          </router-link>
          <el-dropdown-item divided @click.native="logout">
            <span style="display:block;">注销</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import Hamburger from '@/components/Hamburger'

export default {
  components: {
    Breadcrumb,
    Hamburger
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'name'
    ]),
    avatar() {
      const imgs = [
        'https://pic.feizl.com/upload/allimg/190731/gxtxwuahnllnk3m.jpg',
        'http://img2.touxiang.cn/file/20180208/a6aca6842d5a9a9f360c585e18a9928d.jpg',
        'https://img2.woyaogexing.com/2017/06/12/f19d06acd2d21e79!400x400_big.jpg',
        'http://www.3gmfw.cn/article/UploadPic/2013-1/2013122111818882.jpg',
        'http://img2.touxiang.cn/file/20180208/d7e0d2e65aba78502e639f63925d45be.jpg'
      ]
      return imgs[Math.floor(Math.random() * imgs.length)]
    }
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch('app/toggleSideBar')
    },
    async logout() {
      sessionStorage.removeItem('store')
      await this.$store.dispatch('user/logout')
      await this.$store.dispatch('resetRouters')
      this.$router.push(`/login?redirect=${this.$route.fullPath}`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .navbar {
    height: 50px;
    overflow: hidden;
    position: relative;
    background: #fff;
    box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);

    .hamburger-container {
      line-height: 46px;
      height: 100%;
      float: left;
      cursor: pointer;
      transition: background 0.3s;
      -webkit-tap-highlight-color: transparent;

      &:hover {
        background: rgba(0, 0, 0, 0.025);
      }
    }

    .breadcrumb-container {
      float: left;
    }

    .right-menu {
      float: right;
      height: 100%;
      line-height: 50px;

      &:focus {
        outline: none;
      }

      .right-menu-item {
        display: inline-block;
        padding: 0 8px;
        height: 100%;
        font-size: 18px;
        color: #5a5e66;
        vertical-align: text-bottom;

        &.hover-effect {
          cursor: pointer;
          transition: background 0.3s;

          &:hover {
            background: rgba(0, 0, 0, 0.025);
          }
        }
      }

      .avatar-container {
        margin-right: 20px;
        height: 100%;

        .avatar-wrapper {
          height: 100%;
          cursor: pointer;
          display: flex;
          align-items: center;
          justify-items: center;

          &:hover {
            .el-icon-caret-bottom {
              transform: rotate(180deg);
            }
          }

          .name {
            margin: 0 5px 0 10px;
          }

          .el-icon-caret-bottom {
            transition: all .7s;
            font-size: 14px;
          }
        }
      }
    }
  }
</style>
