import {createApp} from 'vue'
import App from './App';
import router from './router'
import store from './store'
import i18n from './i18n';
import {Button, Divider, Icon, Layout, Menu, Table} from 'ant-design-vue';

const app = createApp(App);
app.use(router);
app.use(store);
app.use(i18n)
// ant-design-vue
app.config.productionTip = false;
app.use(Button);
app.use(Divider);
app.use(Icon);
app.use(Layout);
app.use(Menu);
app.use(Table);
//app.prototype.$message = message;
app.mount('#app');
