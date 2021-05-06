package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk;

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
public class AppleProperties extends KeyStoreProperties {
    /**
     * (Required) Your app’s shared secret, which is a hexadecimal string.
     */
    private String password;
}
