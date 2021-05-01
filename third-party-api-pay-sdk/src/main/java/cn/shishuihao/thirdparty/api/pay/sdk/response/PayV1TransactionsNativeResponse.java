package cn.shishuihao.thirdparty.api.pay.sdk.response;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class PayV1TransactionsNativeResponse
        extends AbstractPayV1Response {
    /**
     * 二维码链接.
     * 此URL用于生成支付二维码，然后提供给用户扫码支付
     */
    private final String codeUrl;
}
