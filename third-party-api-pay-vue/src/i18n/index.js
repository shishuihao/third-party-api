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

/**
 * 设置 html lang 属性值
 * @param lang 语言的 key
 */
export const setHtmlLang = (lang) => {
    /**
     * axios.defaults.headers.common['Accept-Language'] = locale
     */
    const htmlSelector = document.querySelector('html');
    htmlSelector && htmlSelector.setAttribute('lang', lang)
}

/**
 * 验证语言命名规则 zh-CN
 * @returns boolean
 */
export const localeNameExp = (lang) => {
    const localeExp = new RegExp(`^([a-z]{2})-?([A-Z]{2})?$`);
    return localeExp.test(lang);
}

/**
 * 切换语言
 * @param lang 语言的 key
 * @param realReload 是否刷新页面，默认刷新
 * @param callback 回调
 */
export const setLocale = (lang, realReload = true, callback = () => {
}) => {
    if (lang !== undefined && !localeNameExp(lang)) {
        // for reset when lang === undefined
        throw new Error('setLocale lang format error');
    }
    if (getLocale() !== lang) {
        if (typeof window.localStorage !== 'undefined') {
            window.localStorage.setItem(localeKey, lang || '');
        }
        if (realReload) {
            window.location.reload();
        } else {
            setHtmlLang(lang);
            if (typeof callback === 'function') {
                callback();
            }
        }
    }
};

/**
 * 设置语言
 * @param locale
 * @param realReload 是否刷新页面，默认不刷新
 */
export function setI18nLanguage(locale, realReload = false) {
    setLocale(locale, realReload, function () {
        // i18n.global.locale = locale // legacy: true
        i18n.global.locale.value = locale;
    })
}

export default i18n;