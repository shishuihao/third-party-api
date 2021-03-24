export default {
    path: '/sms',
    meta: {
        title: 'sms'
    },
    children: [
        {
            path: '/sms',
            meta: {
                icon: 'sms',
                title: "sms",
            },
            component: () => import(/* webpackChunkName: "sms-messages" */ '../views/sms/messages.vue'),
        }
    ],
    component: () => import(/* webpackChunkName: "sms-index" */ '../views/sms/index.vue')
}