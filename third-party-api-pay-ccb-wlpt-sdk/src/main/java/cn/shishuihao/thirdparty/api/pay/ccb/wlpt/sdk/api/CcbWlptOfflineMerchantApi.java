package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptFactory;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1005RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W101BRequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W10B4RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W10C4RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1005Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W101BResponse;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W10B4Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W10C4Response;
import feign.Headers;
import feign.RequestLine;

/**
 * 线下商户.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Headers({
        "User-Agent: " + CcbWlptFactory.USER_AGENT,
        "Content-Type: application/x-www-form-urlencoded;charset=UTF-8"
})
public interface CcbWlptOfflineMerchantApi {
    /**
     * 5W1005 商户流水文件下载.
     *
     * @param request 请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/MER01B2BMainPlat")
    CcbWlpt5W1005Response downloadFlow(
            CcbWlptRequest<CcbWlpt5W1005RequestTxInfo> request);

    /**
     * 5W101B 线下商户交易流水查询.
     *
     * @param request 请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/MER01B2BMainPlat")
    CcbWlpt5W101BResponse queryFlow(
            CcbWlptRequest<CcbWlpt5W101BRequestTxInfo> request);

    /**
     * 5W10B4 线下商户单笔退款.
     *
     * @param request 请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/MER01B2BMainPlat")
    CcbWlpt5W10B4Response refund(
            CcbWlptRequest<CcbWlpt5W10B4RequestTxInfo> request);

    /**
     * 5W10C4 线下集团商户单笔退款.
     *
     * @param request 请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/MER01B2BMainPlat")
    CcbWlpt5W10C4Response groupRefund(
            CcbWlptRequest<CcbWlpt5W10C4RequestTxInfo> request);
}
