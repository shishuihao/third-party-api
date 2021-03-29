<template>
  <a-dropdown>
    <a class="ant-dropdown-link" @click="e => e.preventDefault()">
      {{ languageLabels[locale] }}
      <DownOutlined/>
    </a>
    <template #overlay>
      <a-menu class="menu" @click="switchLanguage" :selectedKeys="[locale]">
        <a-menu-item v-for="item in locales" :key="item">
          <span role="img" :aria-label="languageLabels[item]">
            {{ languageIcons[item] }}
          </span>
          {{ languageLabels[item] }}
        </a-menu-item>
      </a-menu>
    </template>
  </a-dropdown>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";
import {setI18nLanguage} from "@/i18n";
import moment from 'moment'
import 'moment/locale/zh-cn'
import {DownOutlined} from "@ant-design/icons-vue";

moment.locale('zh_CN')

export default defineComponent({
  components: {DownOutlined},
  setup() {
    const {locale} = useI18n();

    const locales = [
      'zh_CN',
      'en_US'
    ];

    const languageLabels = {
      'zh_CN': '简体中文',
      'en_US': 'English',
    };

    const languageIcons = {
      'zh_CN': '🇨🇳',
      'en_US': '🇺🇸',
    };

    // 切换语言
    const switchLanguage = ({key}) => {
      setI18nLanguage(key);
      moment.locale(key);
    };

    return {
      locales,
      languageLabels,
      languageIcons,
      switchLanguage,
      locale: locale
    }
  }
});
</script>

<style scoped>

</style>