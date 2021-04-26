package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.DownloadBillPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.DownloadBillPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface DownloadBillPayApi extends PayApi<
        DownloadBillPayApi,
        DownloadBillPayApiRequest,
        DownloadBillPayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<DownloadBillPayApi> apiType() {
        return DownloadBillPayApi.class;
    }
}
