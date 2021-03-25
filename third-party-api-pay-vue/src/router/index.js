import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'

const menus = [
  {
    path: '/transactions',
    meta: {
      icon: 'transaction',
      title: "transaction",
    },
    component: () => import(/* webpackChunkName: "transactions" */ '../views/transactions')
  },
  {
    path: '/reconciliations',
    meta: {
      icon: 'reconciliation',
      title: "reconciliation",
    },
    component: () => import(/* webpackChunkName: "reconciliations" */ '../views/reconciliations')
  },
  {
    path: '/clearings',
    meta: {
      icon: 'account-book',
      title: "clearing",
    },
    component: () => import(/* webpackChunkName: "clearings" */ '../views/clearings')
  },
  {
    path: '/reports',
    meta: {
      icon: 'table',
      title: "report",
    },
    component: () => import(/* webpackChunkName: "reports" */ '../views/reports/index')
  },
  {
    path: '/users',
    meta: {
      icon: 'user',
      title: "user",
    },
    component: () => import(/* webpackChunkName: "users" */ '../views/users')
  },
  {
    path: '/channels',
    meta: {
      icon: 'gateway',
      title: "channel",
    },
    component: () => import(/* webpackChunkName: "channels" */ '../views/channels/index')
  },
  {
    path: '/configurations',
    meta: {
      icon: 'profile',
      title: "configuration",
    },
    component: () => import(/* webpackChunkName: "configurations" */ '../views/configurations')
  },
]


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: menus
  },
  {
    path: '/about',
    name: 'About',
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
