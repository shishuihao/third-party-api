import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import i18n from './i18n';
import Antd from "ant-design-vue/lib";
import 'ant-design-vue/dist/antd.css'

const app = createApp(App);
app.use(router);
app.use(store);
app.use(i18n)
app.use(Antd)
app.mount('#app');
