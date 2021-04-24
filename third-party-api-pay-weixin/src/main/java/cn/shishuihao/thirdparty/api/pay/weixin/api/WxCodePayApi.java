package cn.shishuihao.thirdparty.api.pay.weixin.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.assembler.WxRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.weixin.assembler.WxResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayMicroPayResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class WxCodePayApi implements CodePayApi {
    /**
     * WxPayCodeApi.
     */
    private final WxPayCodeApi wxPayCodeApi;

    /**
     * execute CodePayApiRequest by weixin.
     *
     * @param request request
     * @return CodePayApiResponse
     */
    @Override
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        WxPayApiProperties properties = (WxPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            WxPayMicroPayResponse response = wxPayCodeApi
                    .microPay(WxRequestAssembler.INSTANCE
                            .assemble(request, properties));
            return WxResponseAssembler.INSTANCE
                    .assemble(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
