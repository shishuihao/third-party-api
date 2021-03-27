import {createApp} from 'vue'
import App from './App';
import router from './router'
import store from './store'
import i18n from './i18n';
import {
    Button,
    Card,
    DatePicker,
    Descriptions,
    Divider,
    Dropdown,
    Icon,
    Input,
    Layout,
    Menu,
    Table
} from 'ant-design-vue';

const app = createApp(App);
app.use(router);
app.use(store);
app.use(i18n)
// ant-design-vue
app.config.productionTip = false;
app.use(Button);
app.use(Card);
app.use(Descriptions);
app.use(Divider);
app.use(Dropdown);
app.use(Icon);
app.use(Input);
app.use(DatePicker);
app.use(Layout);
app.use(Menu);
app.use(Table);
//app.prototype.$message = message;
app.mount('#app');
