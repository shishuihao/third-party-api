package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1001RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1004RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1024RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt6W0111RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1001Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1004Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1024Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt6W0111Response;

/**
 * 线上商户.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface CcbWlptOnlineApi {
    /**
     * 5W1001 商户连接交易.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1001Response connect(
            CcbWlptRequest<CcbWlpt5W1001RequestTxInfo> request);

    /**
     * 5W1004 商户单笔退款交易.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1004Response merchantRefund(
            CcbWlptRequest<CcbWlpt5W1004RequestTxInfo> request);

    /**
     * 5W1005 商户流水文件下载.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt6W0111Response downloadMerchantFlowFile(
            CcbWlptRequest<CcbWlpt6W0111RequestTxInfo> request);

    /**
     * 5W1024 线上集团商户单笔退款.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1024Response groupMerchantRefund(
            CcbWlptRequest<CcbWlpt5W1024RequestTxInfo> request);
}
