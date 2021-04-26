package cn.shishuihao.thirdparty.api.pay.wechat.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.RefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.wechat.assembler.WechatPayRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.wechat.assembler.WechatPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.WechatPayClient;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class WechatRefundQueryPayApi implements RefundQueryPayApi {
    /**
     * WechatPayClient.
     */
    private final WechatPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public RefundQueryPayApiResponse execute(
            final RefundQueryPayApiRequest request) {
        final WechatPayApiProperties properties = (WechatPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return WechatPayResponseAssembler.INSTANCE
                    .assemble(client
                            .codeApi(properties)
                            .refundQuery(WechatPayRequestAssembler.INSTANCE
                                    .assemble(request, properties)));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
