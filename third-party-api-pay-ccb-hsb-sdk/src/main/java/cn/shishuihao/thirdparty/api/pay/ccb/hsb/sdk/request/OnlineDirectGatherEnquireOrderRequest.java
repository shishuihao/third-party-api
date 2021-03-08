package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * 这个接口用于让客户查询订单的支付结果，虽然我们会主动通知客户支付结果，但是也会存在因网络故障而通知失败的情况，
 * 建议客户可以设置在支付完成5分钟之后若仍为收到通知信息，可以调用该接口进行主动查询。
 * 调用生成支付订单接口，使用被扫支付（Pymd_Cd=09），且接口返回订单结果类型为待轮询状态，需调用此接口进行获取订单支付结果，
 * 支付结果查询需在一分钟内完成查询，每次查询间隔至少5s，只能查询7次，7次仍然没有结果，30分钟后会通知最终订单状态.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class OnlineDirectGatherEnquireOrderRequest extends AbstractRequest {
    /**
     * 主订单编号.
     * VarChar2 40
     * 必输
     **/
    @JsonProperty("Main_Ordr_No")
    private final String mainOrderNo;
    /**
     * 支付流水号.
     * VarChar2 40
     * 必输
     **/
    @JsonProperty("Py_Trn_No")
    private final String payTransactionNo;
}
