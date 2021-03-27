import {createApp} from 'vue'
import App from './App';
import router from './router'
import store from './store'
import i18n from './i18n';
import {Button, Icon, Layout, Menu} from 'ant-design-vue';

const app = createApp(App);
app.use(router);
app.use(store);
app.use(i18n)
// ant-design-vue
app.config.productionTip = false;
app.use(Layout);
app.use(Menu);
app.use(Icon);
app.use(Button);
//app.prototype.$message = message;
app.mount('#app');
