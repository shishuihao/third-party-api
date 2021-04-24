package cn.shishuihao.thirdparty.api.pay.weixin.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.assembler.WxRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.weixin.assembler.WxResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayOrderQueryResponse;
import lombok.AllArgsConstructor;

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
                    .orderQuery(WxRequestAssembler.INSTANCE
                            .assemble(request, properties));
            return WxResponseAssembler.INSTANCE
                    .assemble(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
