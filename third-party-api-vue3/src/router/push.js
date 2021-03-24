export default {
    path: '/push',
    meta: {
        title: 'push'
    },
    children: [
        {
            path: '/push',
            meta: {
                icon: 'message',
                title: "push",
            },
            component: () => import(/* webpackChunkName: "pay-messages" */ '../views/push/messages.vue'),
        }
    ],
    component: () => import(/* webpackChunkName: "pay-index" */ '../views/push/index.vue')
}