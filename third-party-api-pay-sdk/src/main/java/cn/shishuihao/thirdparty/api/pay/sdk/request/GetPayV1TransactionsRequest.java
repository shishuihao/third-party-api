package cn.shishuihao.thirdparty.api.pay.sdk.request;

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
public class GetPayV1TransactionsRequest
        extends AbstractPayV1Request {
}
