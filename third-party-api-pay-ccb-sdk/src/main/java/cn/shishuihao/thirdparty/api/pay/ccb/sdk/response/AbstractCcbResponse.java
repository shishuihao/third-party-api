package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import cn.shishuihao.thirdparty.api.commons.http.response.HttpResponse;
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
public class AbstractCcbResponse implements HttpResponse {
    /**
     * 结果 1 Y.
     * Y：成功
     * N：失败
     * U：不确定（交易超时，建议通过订单查询确认扣款结果）
     * Q：待轮询（需按照[3.2.3.支付及轮询流程说明]继续调用轮询接口查询订单结果）
     * 其他无法明确订单结果的情况，均继续调用轮询接口查询
     * Y
     */
    @JsonProperty("RESULT")
    private String result;
    /**
     * 全局事件跟踪号 30 N.
     * 建行交易流水号
     * 1010113861527649530264100
     */
    @JsonProperty("TRACEID")
    private String traceId;
    /**
     * 错误码 12 N.
     * 报错时返回
     * YTMP1000L006
     */
    @JsonProperty("ERRCODE")
    private String errCode;
    /**
     * 错误信息 80 N.
     * 报错时返回
     * 二维码已过有效期
     */
    @JsonProperty("ERRMSG")
    private String errMsg;
    /**
     * 签名 200 N.
     * 签名串，签名源文格式见下方说明，验签方法详见[4.2.返回报文验签方法]
     * 20924b4c8018c591c62d05fffaa32c0009613050c2b739002b0228e74
     */
    @JsonProperty("SIGN")
    private String sign;

}
