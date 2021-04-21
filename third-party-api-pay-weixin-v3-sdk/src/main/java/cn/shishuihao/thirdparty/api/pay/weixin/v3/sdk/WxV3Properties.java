package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk;

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
public class WxV3Properties extends KeyStoreProperties {
    /**
     * 直连商户的商户号，由微信支付生成并下发.
     */
    private String mchId;
}
