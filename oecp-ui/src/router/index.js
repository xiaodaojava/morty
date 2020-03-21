import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/authRedirect',
    component: () => import('@/views/login/authRedirect'),
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
    redirect: '/dashboard',
    children: [
    {
      path: 'dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'One ErrorCode Platform', icon: 'dashboard' }
    }]
  },
  {
    path: '/errorInfo',
    component: Layout,
    redirect: '/errorInfo/table',
    meta: { title: '错误码管理', icon: 'example' },
    children: [
    {
      path: '/errorInfo/list',
      component: () => import('@/views/errorInfo/index'),
      meta: { title: '错误码编辑', icon: 'dashboard' }
    },
    {
      path: '/errorInfo/example',
      component: () => import('@/views/errorInfo/example'),
      meta: { title: '错误码案例', icon: 'dashboard' }
    },
    {
      path: '/errorInfo/example-add',
      component: () => import('@/views/errorInfo/example-add'),
      meta: { title: '错误码案例增加', icon: 'dashboard' },
      hidden: true
    },
    {
      path: '/errorInfo/tag',
      component: () => import('@/views/errorInfo/tags'),
      meta: { title: '错误码标签', icon: 'dashboard' }
    }]
  },
  {
    path: '/user',
    component: Layout,
    name: '个人信息',
    children: [
    {
      path: 'index',
      name: '个人信息设置',
      component: () => import('@/views/user/index'),
      meta: { title: '个人信息设置', icon: 'user' }
    }]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  //mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router