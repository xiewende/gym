import Vue from 'vue'
import Router from 'vue-router'
/* Layout */
import Layout from '@/layout'

Vue.use(Router)

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/user/login/index'),
    meta: { title: '登录' },
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [{
      path: 'home',
      name: 'Home',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'home' }
    }]
  }
]

// // 实例化vue的时候只挂载constantRouter
// export default new Router({
//   routes: constantRoutes
// })

// 动态路由，根据用户角色分配
export const asyncRoutes = [
  { // 用户管理
    path: '/user',
    component: Layout,
    redirect: '/user/userlist',
    name: 'User',
    meta: { title: '用户管理', icon: 'user', roles: ['1'] },
    children: [
      {
        path: 'userlist',
        name: 'UserList',
        component: () => import('@/views/user/userlist/index'),
        meta: { title: '用户管理', icon: 'user' }
      }
    ]
  },

  { // 场地管理（管理员）
    path: '/field/admin',
    component: Layout,
    redirect: '/field/admin/main',
    name: 'FieldAdmin',
    meta: { title: '场地管理', icon: 'field', roles: ['1', '23'] },
    children: [
      {
        path: 'main',
        name: 'FieldAdminMain',
        component: () => import('@/views/field/admin/main/index'),
        meta: { title: '场地管理', icon: 'field' }
      },
      {
        path: 'review',
        name: 'FieldAdminReview',
        component: () => import('@/views/field/admin/review/index'),
        meta: { title: '场地审核', icon: 'review' }
      },
      {
        path: 'usage',
        name: 'FieldAdminUsage',
        component: () => import('@/views/field/admin/usage/index'),
        meta: { title: '场地使用', icon: 'use' }
      },
      {
        path: 'notice',
        name: 'FieldAdminNotice',
        component: () => import('@/views/field/admin/notice/index'),
        meta: { title: '场馆公告', icon: 'notice' }
      }
    ]
  },

  { // 场地管理（学生）
    path: '/field/student',
    component: Layout,
    redirect: '/field/student/reserve',
    name: 'FieldStudent',
    meta: { title: '场地管理（用户）', icon: 'field', roles: ['1', '21', '22', '3'] },
    children: [
      {
        path: 'reserve',
        name: 'FieldStudentReserve',
        component: () => import('@/views/field/student/reserve/index'),
        meta: { title: '场地预约', icon: 'reserve' }
      },
      {
        path: 'my-reservation',
        name: 'FieldStudentMyReserve',
        component: () => import('@/views/field/student/my-reservation/index'),
        meta: { title: '我的预约', icon: 'reservation' }
      },
      {
        path: 'notice',
        name: 'FieldStudentNotice',
        component: () => import('@/views/field/student/notice/index'),
        meta: { title: '场馆公告', icon: 'notice' }
      }
    ]
  },

  { // 器材管理(管理员)
    path: '/equipment',
    component: Layout,
    redirect: '/equipment/list',
    name: 'Equipment',
    meta: { title: '器材管理', icon: 'equipment', roles: ['1', '21'] },
    children: [
      {
        path: 'list',
        component: () => import('@/views/equipment/equipment/index'),
        name: 'EquipmentList',
        meta: { title: '器材列表', icon: 'list' }
      },
      {
        path: 'equipment-group',
        component: () => import('@/views/equipment/equipment-group/index'),
        name: 'EquipmentGroup',
        meta: { title: '器材分类', icon: '分类' }
      },
      {
        path: 'rentEquipment',
        component: () => import('@/views/equipment/rentEquipment/index'),
        name: 'RentEquipment',
        meta: { title: '器材租借', icon: 'rent' }
      },
      {
        path: 'repair',
        component: () => import('@/views/equipment/repair/index'),
        name: 'Repair',
        meta: { title: '维修列表', icon: 'repair' }
      },
      {
        path: 'scrap',
        component: () => import('@/views/equipment/scrap/index'),
        name: 'Scrap',
        meta: { title: '报废列表', icon: 'scrap' }
      },
      {
        path: 'addmanage',
        component: () => import('@/views/equipment/addmanage/index'),
        name: 'Addmanage',
        meta: { title: '器材新增', icon: 'add' }
      },
      {
        path: 'order',
        name: 'FormIndex',
        component: () => import('@/views/equipment/formlist/index'),
        meta: { title: '器材订单', icon: 'order' }
      }
    ]
  },

  { // 器材管理（用户）
    path: '/equipmentStudent',
    component: Layout,
    redirect: '/equipmentStudent/order',
    name: 'EquipmentStudent',
    meta: { title: '器材管理（用户）', icon: 'equipment', roles: ['1', '22', '23', '3'] },
    children: [
      {
        path: 'order',
        name: 'StudentOrderEquipment',
        component: () => import('@/views/equipment/formlist/studentindex'),
        meta: { title: '器材订单', icon: 'order' }
      },
      {
        path: 'rentEquipment',
        component: () => import('@/views/equipment/rentEquipment/index'),
        name: 'StudentRentEquipment',
        meta: { title: '器材租借', icon: 'rent' }
      },
      {
        path: 'repairList',
        component: () => import('@/views/equipment/repair/studentIndex'),
        name: 'StudentRepairList',
        meta: { title: '维修列表', icon: 'repair' }
      },
      {
        path: 'student',
        component: () => import('@/views/equipment/addmanage/student'),
        name: 'StudentAddEquipment',
        meta: { title: '器材新增', icon: 'add' }
      }
    ]
  },

  { // 赛事管理（管理员）
    path: '/event',
    component: Layout,
    redirect: '/event/main',
    name: 'Event',
    meta: { title: '赛事管理', icon: 'event', roles: ['1', '22'] },
    children: [
      {
        path: 'main',
        name: 'EventMain',
        component: () => import('@/views/event/main/index'),
        meta: { title: '赛事管理', icon: 'event' }
      },
      {
        path: 'judge',
        name: 'EventJudge',
        component: () => import('@/views/event/judge/index'),
        meta: { title: '裁判管理', icon: 'person' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
