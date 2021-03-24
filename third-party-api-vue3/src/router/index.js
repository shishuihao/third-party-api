import {createRouter, createWebHashHistory} from 'vue-router'
import Home from '../views/Home.vue'
import pay from './pay'
import push from './push'
import sms from './sms'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
        meta: {
            title: 'home'
        },
        children: [pay, push, sms]
    },
    {
        path: '/about',
        name: 'About',
        meta: {
            title: 'about'
        },
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

export default router
