import {createI18n} from "vue-i18n";
import zh_CN from "./locale/zh_CN";
import en_US from "./locale/en_US";

// window.localStorage 存储key
export const localeKey = 'locale';

// 默认语言
export const defaultLang = 'zh-CN';

export const getLocale = () => {
    const lang = typeof window.localStorage !== 'undefined' ? window.localStorage.getItem(localeKey) : '';
    const isNavigatorLanguageValid = typeof navigator !== 'undefined' && typeof navigator.language === 'string';
    const browserLang = isNavigatorLanguageValid ? navigator.language.split('-').join('-') : '';
    return lang || browserLang || defaultLang;
};

export const messages = {
    'zh-CN': zh_CN,
    'en-US': en_US
};

const i18n = createI18n({
    legacy: false,
    locale: getLocale(),
    messages,
});

export default i18n;