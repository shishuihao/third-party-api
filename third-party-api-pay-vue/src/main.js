import {createApp} from 'vue'
import App from './App';
import router from './router'
import store from './store'
import i18n from './i18n';
import {
    Badge,
    Button,
    Calendar,
    Card,
    ConfigProvider,
    DatePicker,
    Descriptions,
    Divider,
    Dropdown,
    Input,
    Layout,
    Menu,
    message,
    Table
} from 'ant-design-vue';
import * as antIcons from '@ant-design/icons-vue'
import 'ant-design-vue/dist/antd.css'

const app = createApp(App);
app.use(router);
app.use(store);
app.use(i18n)
// ant-design-vue
app.config.productionTip = false;
app.use(Badge);
app.use(Button);
app.use(Calendar);
app.use(Card);
app.use(ConfigProvider);
app.use(Descriptions);
app.use(Divider);
app.use(Dropdown);
app.use(Input);
app.use(DatePicker);
app.use(Layout);
app.use(Menu);
app.use(Table);
// 注册组件
Object.keys(antIcons).forEach(key => {
    app.component(key, antIcons[key])
})
//app.config.globalProperties.$i18n = i18n
app.config.globalProperties.$message = message
app.config.globalProperties.$antIcons = antIcons
app.mount('#app');
