package cn.shishuihao.thirdparty.api.pay.sdk.response;

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
public abstract class AbstractPayV1Response {
    /**
     * 应用ID.
     */
    private final String appId;
    /**
     * 商户号.
     */
    private final String merchantId;
}
