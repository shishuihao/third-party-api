package cn.shishuihao.thirdparty.api.pay.ccb.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay100Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay100Response;
import feign.Param;
import feign.RequestLine;

/**
 * 建行互联网银企被扫支付接口.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface ScannedPayApi {
    /**
     * 客户被扫支付-PAY100.
     * 对于本消费接口返回的结果进行分别处理，如需轮询时必须调用[轮询订单结果-PAY101]接口轮询订单结果。
     * 该接口中的所有金额字段除了明确标明单位为分的字段外，其余金额的单位均为元。
     * 1、 如果支付接口PAY100返回结果为Q-待轮询，则必须调用轮询接口 PAY101 进行轮询。
     * 如WAITTIME有时间返回，请等待相应时间后再发起轮询。
     * 2、 如网络超时等原因导致未能接收到返回结果，请调用PAY101进行轮询（时间间隔建议设置为5秒）。
     * 3、 其他无法明确该笔订单消费成功或失败的情况，请调用 PAY101进行轮询（时间间隔建议设置为5秒）。
     * 4、 注意同一订单号仅能发送一笔 PAY100，出现上述异常情况请调用PAY101进行轮询。
     * 切勿重复发送相同订单号的PAY100，否则可能出现订单重复错误或其他不可预期的问题。
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbPay100Response pay(@Param("channelName") String channelName,
                          CcbPay100Request request);
}
