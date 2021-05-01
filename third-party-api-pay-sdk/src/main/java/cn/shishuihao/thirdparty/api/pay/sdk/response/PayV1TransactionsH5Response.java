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
public class PayV1TransactionsH5Response
        extends AbstractPayV1Response {
    /**
     * 预支付交易会话标识.
     */
    private final String h5Url;
}
