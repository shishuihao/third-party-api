package cn.shishuihao.thirdparty.api.pay.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.pay.PayApiResponse;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
public class DownloadBillPayApiResponse
        extends BaseApiResponse
        implements PayApiResponse {
    /**
     * downloadUrl.
     * alipay: billDownloadUrl
     */
    private final String downloadUrl;
}