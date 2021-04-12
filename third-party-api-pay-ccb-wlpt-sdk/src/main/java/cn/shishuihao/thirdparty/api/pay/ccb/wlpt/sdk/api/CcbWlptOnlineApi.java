package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt6W0111RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt6W0111Response;

/**
 * 线上商户.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface CcbWlptOnlineApi {
    /**
     * 商户流水文件下载.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt6W0111Response downloadMerchantFlowFile(
            CcbWlptRequest<CcbWlpt6W0111RequestTxInfo> request);
}
