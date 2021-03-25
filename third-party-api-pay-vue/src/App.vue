<template>
  <ConfigProvider :locale="zh_CN">
    <div id="app">
      <router-view/>
    </div>
  </ConfigProvider>
</template>

<script>
import {ConfigProvider} from 'ant-design-vue'
import zh_CN from 'ant-design-vue/es/locale-provider/zh_CN'

export default {
  name: 'App',
  components: {
    ConfigProvider
  },
  data() {
    return {
      zh_CN,
    }
  }
}
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
