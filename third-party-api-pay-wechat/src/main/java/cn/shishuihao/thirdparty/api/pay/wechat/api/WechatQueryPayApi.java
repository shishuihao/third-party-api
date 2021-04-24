package cn.shishuihao.thirdparty.api.pay.wechat.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.wechat.assembler.WechatPayRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.wechat.assembler.WechatPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayCodeApi;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class WechatQueryPayApi implements QueryPayApi {
    /**
     * WechatPayCodeApi.
     */
    private final WechatPayCodeApi wechatPayCodeApi;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public QueryPayApiResponse execute(final QueryPayApiRequest request) {
        final WechatPayApiProperties properties = (WechatPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return WechatPayResponseAssembler.INSTANCE
                    .assemble(wechatPayCodeApi
                            .orderQuery(WechatPayRequestAssembler.INSTANCE
                                    .assemble(request, properties)));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
