package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ChinaumsV1NetPaySubOrdersConfirmResponse
        extends AbstractChinaumsResponse {
    /**
     * 商户订单号 字符串 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 异步分账状态 字符串 否.
     * success：异步 分账成功，
     * fail：异步分账 失败.
     */
    @JsonProperty("asynDivisionStatus")
    private final String asyncDivisionStatus;
    /**
     * 异步分账信息 字符串 否.
     */
    @JsonProperty("asynDivisionMsg")
    private final Integer asyncDivisionMsg;
}
