<template>
  <div class="home">
    <Layout class="ant-layout">
      <a-layout-header class="ant-layout-header">
        <img alt="商标" class="logo" src="../assets/logo.png" style="height: 100%;width: auto;float: left">
        <div style="float: right">
        </div>
      </a-layout-header>
      <Layout class="ant-layout">
        <a-layout-sider class="ant-layout-sider">
          <Menu v-model="current"
                mode="vertical"
                @click="handleClickMenu"
          >
            <template v-for="(item) in menus">
              <template v-if="item.children && item.children.length > 0">
                <SubMenu :key="item.path">
                  <template #title>
                    <Icon :type="item.meta.icon"/>
                    <span>{{ t(item.meta.title) }}</span>
                  </template>
                  <a-menu-item v-for="(subItem) in item.children" :key="subItem.path">
                    <Icon :type="subItem.meta.icon"/>
                    <span>{{ t(subItem.meta.title) }}</span>
                  </a-menu-item>
                </SubMenu>
              </template>
              <template v-else>
                <a-menu-item :key="item.path">
                  <Icon :type="item.meta.icon"/>
                  <span>{{ t(item.meta.title) }}</span>
                </a-menu-item>
              </template>
            </template>
          </Menu>
        </a-layout-sider>
        <a-layout-content class="ant-layout-content">
          <router-view/>
        </a-layout-content>
      </Layout>
      <a-layout-footer class="ant-layout-footer">
        copyright &copy; 2021 shishuihao
      </a-layout-footer>
    </Layout>
  </div>
</template>

<script>

import router from "@/router";
import {useI18n} from "vue-i18n";
import {Icon, Layout, Menu} from "ant-design-vue"
import {SubMenu} from "ant-design-vue/lib/vc-menu"

export default {
  name: 'Home',
  components: {Layout, Menu, SubMenu, Icon},
  data() {
    return {
      menus: router.options.routes.filter(item => '/' === item.path)[0].children,
      current: ['/transactions'],
    };
  },
  methods: {
    handleClickMenu(e) {
      console.log('handleClickMenu:' + e.key)
      this.$router.push(e.key)
    },
  },
  setup() {
    const {t} = useI18n();

    return {
      t
    }
  }
}
</script>

<style scoped>
.home {
  text-align: center;
}

.home .ant-layout-header {
  background: rgb(240, 242, 245);
}

.home .ant-layout-footer {
}

.home .ant-layout-footer {
  line-height: 1.5;
}

.home .ant-layout-sider {
  background: #fff;
  color: #2c3e50;
  line-height: 120px;
  width: 200px;
}

.home .ant-layout-content {
  background: #fff;
  line-height: 120px;
  width: 200px;
  text-align: center;
  color: #2c3e50;
}

.home > .ant-layout {
  margin-bottom: 48px;
}

.home > .ant-layout:last-child {
  margin: 0;
}
</style>
