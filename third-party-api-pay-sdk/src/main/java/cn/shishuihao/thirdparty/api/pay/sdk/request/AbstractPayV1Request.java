package cn.shishuihao.thirdparty.api.pay.sdk.request;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public abstract class AbstractPayV1Request {
    /**
     * 商户号.
     */
    private final String merchantId;
}
