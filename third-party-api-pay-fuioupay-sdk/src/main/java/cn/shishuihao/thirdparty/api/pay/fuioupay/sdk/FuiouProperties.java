package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class FuiouProperties {
    /**
     * 富友分配给各合作商户的唯一识别码.
     */
    private String merchantId;
    /**
     * 32位的商户密钥，系统分配.
     */
    private String privateKey;
}
