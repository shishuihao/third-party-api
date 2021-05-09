package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.identity_info;

/**
 * 证件类型.
 *
 * @author shishuihao
 * @version 1.0.0
 */
public enum IdentityType {
    /**
     * 中国大陆居民-身份证.
     */
    ID_CARD,
    /**
     * 其他国家或地区居民-护照.
     */
    OVERSEA_PASSPORT,
    /**
     * 中国香港居民-来往内地通行证.
     */
    HONG_KONG_PASSPORT,
    /**
     * 中国澳门居民-来往内地通行证.
     */
    MACAO_PASSPORT,
    /**
     * 中国台湾居民-来往大陆通行证.
     */
    TAIWAN_PASSPORT;
}
