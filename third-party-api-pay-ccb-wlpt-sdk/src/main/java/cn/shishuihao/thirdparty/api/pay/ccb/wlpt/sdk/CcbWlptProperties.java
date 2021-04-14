package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk;

import cn.shishuihao.thirdparty.api.commons.ssl.KeyStoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class CcbWlptProperties extends KeyStoreProperties {
    /**
     * 商户代码 varChar(15).
     */
    private String merchantId;
    /**
     * 网银客户号 varChar(21).
     */
    private String customerId;
    /**
     * 操作员号 varChar(6).
     */
    private String userId;
    /**
     * 操作员密码 varChar(32).
     */
    private String password;
    /**
     * 语言 varChar(2) CN.
     */
    private String language = "CN";
}
