package cn.shishuihao.thirdparty.api.pay.weixin.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.QueryOrderPayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryOrderApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryOrderApiResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayOrderQueryRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.ResponseChecker;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class WxQueryOrderPayApi implements QueryOrderPayApi {
    /**
     * WxPayCodeApi.
     */
    private final WxPayCodeApi wxPayCodeApi;

    /**
     * execute QueryOrderApiRequest by weixin.
     *
     * @param request request
     * @return QueryOrderApiResponse
     */
    @Override
    public QueryOrderApiResponse execute(final QueryOrderApiRequest request) {
        WxPayApiProperties properties = (WxPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            WxPayOrderQueryRequest wxRequest = getWxRequest(request, properties);
            wxRequest.sign(properties.getKey());
            WxPayOrderQueryResponse wxResponse = wxPayCodeApi.orderQuery(wxRequest);
            return getApiResponse(wxResponse);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private WxPayOrderQueryRequest getWxRequest(
            final QueryOrderApiRequest request,
            final WxPayApiProperties properties) {
        return WxPayOrderQueryRequest.builder()
                .appId(properties.getAppId())
                .mchId(properties.getMchId())
                .subAppId(properties.getSubAppId())
                .subMchId(properties.getSubMchId())
                .deviceInfo(properties.getDeviceInfo())
                .nonceStr(RandomStringUtils
                        .randomAlphanumeric(Integer.SIZE))
                .signType(properties.getSignType())
                .outTradeNo(request.getOutTradeNo())
                .build();
    }

    private QueryOrderApiResponse getApiResponse(
            final WxPayOrderQueryResponse wxPayMicropayResponse) {
        return QueryOrderApiResponse.builder()
                .success(ResponseChecker.success(wxPayMicropayResponse))
                .code(ResponseChecker.getCode(wxPayMicropayResponse))
                .message(ResponseChecker.getMsg(wxPayMicropayResponse))
                .requestId(null)
                .build();
    }
}
