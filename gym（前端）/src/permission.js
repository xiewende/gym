import router from './router'
import store from './store'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({ showSpinner: false }) // NProgress Configuration

const whiteList = ['/login'] // no redirect whitelist

router.beforeEach(async(to, from, next) => {
  // start progress bar
  NProgress.start()

  // set page title
  document.title = getPageTitle(to.meta.title)

  if (sessionStorage.getItem('isLogin')) {
    if (to.path === '/login') {
      // if is logged in, redirect to the home page
      next({ path: '/' })
      NProgress.done()
    } else {
      // 生成可访问的路由表
      // const roles = ['3']
      if (store.getters.addRouters === null || store.getters.addRouters.length === 0) {
        setTimeout(() => {
          const roles = [store.getters.role]
          store.dispatch('GenerateRoutes', { roles }).then(() => {

          })
          // 动态添加可访问路由表
          router.options.routes = store.getters.routers
          router.addRoutes([...store.getters.addRouters])
          // hack方法 确保addRoutes已完成 ,set the replace: true so the navigation will not leave a history record
          next({ ...to, replace: true })
        }, 200)
      } else {
        next()
      }
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach((to, from) => {
  // finish progress bar
  NProgress.done()

  document.title = getPageTitle(to.meta.title)
})
