package cn.shishuihao.thirdparty.api.pay.sdk;

import cn.shishuihao.thirdparty.api.commons.ssl.KeyStoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {
        "appId"
}, callSuper = true)
@Getter
@Setter
public class PayProperties extends KeyStoreProperties {
    /**
     * 应用ID.
     */
    private String appId;
    /**
     * 商户号.
     */
    private String mchId;
    /**
     * 签名类型.
     */
    private String signType;
    /**
     * 商户密钥.
     */
    private String key;
}
