package cn.shishuihao.thirdparty.api.pay.wechat.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.wechat.assembler.WechatRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.wechat.assembler.WechatResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayMicroPayResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class WechatCodePayApi implements CodePayApi {
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
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        final WechatPayApiProperties properties = (WechatPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            final WechatPayMicroPayResponse response = wechatPayCodeApi
                    .microPay(WechatRequestAssembler.INSTANCE
                            .assemble(request, properties));
            return WechatResponseAssembler.INSTANCE
                    .assemble(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
