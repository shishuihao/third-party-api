package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 订单交易查询.
 * 钱包支付时，因通讯故障、服务器故障等原因，造成收银机最终没有收到支付结果通知，
 * 收银员不确定该笔支付后台处理结果，可以在收银机上发起“查询”交易，
 * 查询该笔交易订单在钱包后台的支付结果，并将支付结果返回给收银机。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPayQueryRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..64 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 支付订单号 字符串 6..64 否.
     */
    @JsonProperty("targetOrderId")
    private final String targetOrderId;
}
