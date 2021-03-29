<template>
  <a-config-provider :locale="locales[locale]">
    <div id="app">
      <router-view/>
    </div>
  </a-config-provider>
</template>

<script>
import {defineComponent} from "vue";
import enUS from 'ant-design-vue/es/locale/en_US';
import zhCN from 'ant-design-vue/es/locale/zh_CN';
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: 'App',
  setup() {
    const {locale} = useI18n();

    const locales = {
      'zh_CN': zhCN,
      'en_US': enUS,
    };

    return {
      locale,
      locales
    }
  }
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
