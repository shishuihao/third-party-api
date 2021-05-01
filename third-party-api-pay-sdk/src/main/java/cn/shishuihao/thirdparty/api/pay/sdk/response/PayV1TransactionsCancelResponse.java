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
public class PayV1TransactionsCancelResponse
        extends AbstractPayV1Response {
    /**
     * 是否需要继续调用撤销.
     */
    private final Boolean recall;
}
