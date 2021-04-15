package cn.shishuihao.thirdparty.api.pay.weixin.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayOrderQueryRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.ResponseChecker;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class WxQueryPayApi implements QueryPayApi {
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
    public QueryPayApiResponse execute(final QueryPayApiRequest request) {
        WxPayApiProperties properties = (WxPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            WxPayOrderQueryResponse response = wxPayCodeApi
                    .orderQuery(buildRequest(request, properties));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private WxPayOrderQueryRequest buildRequest(
            final QueryPayApiRequest request,
            final WxPayApiProperties properties)
            throws UnsupportedEncodingException {
        WxPayOrderQueryRequest wxRequest = WxPayOrderQueryRequest.builder()
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
        wxRequest.sign(properties.getKey());
        return wxRequest;
    }

    private QueryPayApiResponse buildResponse(
            final WxPayOrderQueryResponse response) {
        return QueryPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .build();
    }
}
