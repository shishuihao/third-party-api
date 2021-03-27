<template>
  <a-dropdown>
    <a class="ant-dropdown-link" @click="e => e.preventDefault()">
      {{languageLabels[locale]}}
      <a-icon type="down" />
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
import { useI18n } from "vue-i18n";
import {setI18nLanguage} from "@/i18n";

export default {
  setup() {
    const { locale }  = useI18n();
    const locales = [
      'zh-CN',
      'en-US'
    ];
    const languageLabels = {
      'zh-CN': '简体中文',
      'en-US': 'English',
    };
    const languageIcons = {
      'zh-CN': '🇨🇳',
      'en-US': '🇺🇸',
    };
    // 切换语言
    const switchLanguage = ({key}) => setI18nLanguage(key);

    return {
      locales,
      languageLabels,
      languageIcons,
      switchLanguage,
      locale: locale
    }
  }
}
</script>

<style scoped>

</style>