import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'

const menus = [
  {
    path: '/transactions',
    meta: {
      icon: 'TransactionOutlined',
      title: "transactions.title",
    },
    component: () => import(/* webpackChunkName: "transactions" */ '../views/transactions')
  },
  {
    path: '/reconciliations',
    meta: {
      icon: 'ReconciliationOutlined',
      title: "reconciliations.title",
    },
    component: () => import(/* webpackChunkName: "reconciliations" */ '../views/reconciliations')
  },
  {
    path: '/clearings',
    meta: {
      icon: 'AccountBookOutlined',
      title: "clearings.title",
    },
    component: () => import(/* webpackChunkName: "clearings" */ '../views/clearings')
  },
  {
    path: '/reports',
    meta: {
      icon: 'BarChartOutlined',
      title: "reports.title",
    },
    component: () => import(/* webpackChunkName: "reports" */ '../views/reports/index')
  },
  {
    path: '/users',
    meta: {
      icon: 'UserOutlined',
      title: "users.title",
    },
    component: () => import(/* webpackChunkName: "users" */ '../views/users')
  },
  {
    path: '/applications',
    meta: {
      icon: 'AppstoreOutlined',
      title: "applications.title",
    },
    component: () => import(/* webpackChunkName: "applications" */ '../views/applications/index')
  },
  {
    path: '/channels',
    meta: {
      icon: 'DeploymentUnitOutlined',
      title: "channels.title",
    },
    component: () => import(/* webpackChunkName: "channels" */ '../views/channels/index')
  },
]


const routes = [
  {
    path: '/',
    name: 'Home',
    meta: {
      icon: 'home',
      title: "home.title",
    },
    component: Home,
    children: menus
  },
  {
    path: '/about',
    name: 'About',
    meta: {
      icon: 'about',
      title: "about.title",
    },
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
