import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'

const menus = [
  {
    path: '/transactions',
    meta: {
      icon: 'transaction',
      title: "transactions.title",
    },
    component: () => import(/* webpackChunkName: "transactions" */ '../views/transactions')
  },
  {
    path: '/reconciliations',
    meta: {
      icon: 'reconciliation',
      title: "reconciliations.title",
    },
    component: () => import(/* webpackChunkName: "reconciliations" */ '../views/reconciliations')
  },
  {
    path: '/clearings',
    meta: {
      icon: 'account-book',
      title: "clearings.title",
    },
    component: () => import(/* webpackChunkName: "clearings" */ '../views/clearings')
  },
  {
    path: '/reports',
    meta: {
      icon: 'table',
      title: "reports.title",
    },
    component: () => import(/* webpackChunkName: "reports" */ '../views/reports/index')
  },
  {
    path: '/users',
    meta: {
      icon: 'user',
      title: "users.title",
    },
    component: () => import(/* webpackChunkName: "users" */ '../views/users')
  },
  {
    path: '/channels',
    meta: {
      icon: 'gateway',
      title: "channels.title",
    },
    component: () => import(/* webpackChunkName: "channels" */ '../views/channels/index')
  },
  {
    path: '/configurations',
    meta: {
      icon: 'profile',
      title: "configurations.title",
    },
    component: () => import(/* webpackChunkName: "configurations" */ '../views/configurations')
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
