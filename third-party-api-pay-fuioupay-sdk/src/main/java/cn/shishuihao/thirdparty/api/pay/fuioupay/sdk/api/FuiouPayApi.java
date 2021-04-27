package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.api;

import cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request.FuiouPaySmpAQueryGateRequest;
import cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request.FuiouPaySmpGateRequest;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface FuiouPayApi {
    /**
     * B2C/B2B 支付.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /smpGate.do?")
    String pay(FuiouPaySmpGateRequest request);

    /**
     * 支付结果查询(直接返回).
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /smpAQueryGate.do?")
    String query(FuiouPaySmpAQueryGateRequest request);
}
