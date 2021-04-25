package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk;

import cn.shishuihao.thirdparty.api.commons.ssl.SslContextProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public interface CcbWlptProperties
        extends SslContextProperties {
    /**
     * 商户代码 varChar(15).
     *
     * @return String
     */
    String getMerchantId();

    /**
     * 网银客户号 varChar(21).
     *
     * @return String
     */
    String getCustomerId();

    /**
     * 操作员号 varChar(6).
     *
     * @return String
     */
    String getUserId();

    /**
     * 操作员密码 varChar(32).
     *
     * @return String
     */
    String getPassword();

    /**
     * 语言 varChar(2) CN.
     *
     * @return String
     */
    String getLanguage();
}
