export default {
    path: '/pay',
    meta: {
        title: 'pay'
    },
    children: [
        {
            path: '/orders',
            meta: {
                icon: 'transaction',
                title: "orders",
            },
            component: () => import(/* webpackChunkName: "pay-orders" */ '../views/pay/orders.vue'),
        }
    ],
    component: () => import(/* webpackChunkName: "pay-index" */ '../views/pay/index.vue')
}