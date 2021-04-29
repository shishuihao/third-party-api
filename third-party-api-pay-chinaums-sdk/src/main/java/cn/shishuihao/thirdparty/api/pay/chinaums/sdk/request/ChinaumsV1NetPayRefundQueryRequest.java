package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 退款查询.
 * 钱包支付时，因通讯故障、服务器故障等原因，造成收银机最终没有收到退货结果通知，
 * 收银员不确定该笔退货后台处理结果，查询该笔退货交易订单在钱包后台的支付结果，并将退货结果返回给收银机。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPayRefundQueryRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..64 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
}
