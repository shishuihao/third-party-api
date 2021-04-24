package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@Getter
@Setter
public class CcbPay103Response extends AbstractCcbResponse {
    /**
     * 订单结果 1 Y.
     * Y：成功
     * N：失败
     * U：不确定（交易超时，建议通过查询接口确认订单状态）
     * Y
     */
    @JsonProperty("RESULT")
    private String result;
    /**
     * 订单号 30 N.
     * 从请求参数中获得
     * 20180906101102
     */
    @JsonProperty("ORDERID")
    private String orderId;
    /**
     * 是否重调 1 N.
     * 是否需要继续调用订单关闭交易
     * Y：需要
     * N：不需要
     * N
     */
    @JsonProperty("RECALL")
    private String recall;

    /**
     * 是否成功.
     *
     * @return boolean
     */
    @JsonIgnore
    @Override
    public boolean isSuccess() {
        return "Y".equalsIgnoreCase(result);
    }
}
