package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W10B4RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W10C4RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt6W0111RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W10B4Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W10C4Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt6W0111Response;

/**
 * 线下商户.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface CcbWlptOfflineApi {
    /**
     * 商户流水文件下载.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt6W0111Response downloadMerchantFlowFile(
            CcbWlptRequest<CcbWlpt6W0111RequestTxInfo> request);

    /**
     * 线下商户单笔退款.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W10B4Response merchantRefund(
            CcbWlptRequest<CcbWlpt5W10B4RequestTxInfo> request);

    /**
     * 线下集团商户单笔退款.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W10C4Response groupMerchantRefund(
            CcbWlptRequest<CcbWlpt5W10C4RequestTxInfo> request);
}
