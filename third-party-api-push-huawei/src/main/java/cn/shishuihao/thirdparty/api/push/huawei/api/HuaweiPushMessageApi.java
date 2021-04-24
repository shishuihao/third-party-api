package cn.shishuihao.thirdparty.api.push.huawei.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiProperties;
import cn.shishuihao.thirdparty.api.push.huawei.assembler.HuaweiPushRequestAssembler;
import cn.shishuihao.thirdparty.api.push.huawei.assembler.HuaweiPushResponseAssembler;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.HuaweiFactory;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.api.HuaweiPushApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import lombok.AllArgsConstructor;

/**
 * push message.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class HuaweiPushMessageApi implements PushMessageApi {
    /**
     * huaweiPushApi.
     */
    private final HuaweiPushApi huaweiPushApi = HuaweiFactory.Push.pushApi();

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        final HuaweiPushApiProperties properties = (HuaweiPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return HuaweiPushResponseAssembler.INSTANCE
                    .assemble(huaweiPushApi
                            .sendMessage(properties.getAppId(),
                                    HuaweiPushRequestAssembler.INSTANCE
                                            .assemble(request, properties)));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
