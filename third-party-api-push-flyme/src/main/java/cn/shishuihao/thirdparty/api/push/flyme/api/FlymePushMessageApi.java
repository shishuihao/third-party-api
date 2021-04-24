package cn.shishuihao.thirdparty.api.push.flyme.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiProperties;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushClient;
import cn.shishuihao.thirdparty.api.push.flyme.assembler.FlymePushRequestAssembler;
import cn.shishuihao.thirdparty.api.push.flyme.assembler.FlymePushResponseAssembler;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.util.ArrayUtils;
import com.meizu.push.sdk.constant.PushType;
import com.meizu.push.sdk.server.IFlymePush;
import com.meizu.push.sdk.server.constant.ResultPack;
import com.meizu.push.sdk.server.model.push.VarnishedMessage;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Arrays;

/**
 * push message.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class FlymePushMessageApi implements PushMessageApi {
    /**
     * flymePushClient.
     */
    private final FlymePushClient flymePushClient;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        final FlymePushApiProperties properties = (FlymePushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            final IFlymePush push = flymePushClient.getClient(properties);
            final VarnishedMessage message = FlymePushRequestAssembler.INSTANCE
                    .assemble(request, properties);
            final ResultPack<?> result;
            if (ArrayUtils.isEmpty(request.getRegistrationIds())) {
                result = push.pushToApp(PushType.STATUSBAR, message);
            } else {
                result = push.pushMessage(message,
                        Arrays.asList(request.getRegistrationIds()),
                        Math.max(1, properties.getRetries()));
            }
            return FlymePushResponseAssembler.INSTANCE
                    .assemble(result);
        } catch (IOException e) {
            throw new ApiException(e);
        }
    }
}
