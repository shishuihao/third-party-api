package cn.shishuihao.thirdparty.api.push.xiaomi.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiProperties;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushClient;
import cn.shishuihao.thirdparty.api.push.xiaomi.assembler.XiaomiPushRequestAssembler;
import cn.shishuihao.thirdparty.api.push.xiaomi.assembler.XiaomiPushResponseAssembler;
import com.xiaomi.xmpush.server.Constants;
import lombok.AllArgsConstructor;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;

/**
 * push message.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class XiaomiPushMessageApi implements PushMessageApi {
    /**
     * xiaomiPushClient.
     */
    private final XiaomiPushClient xiaomiPushClient;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        final XiaomiPushApiProperties properties = (XiaomiPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Constants.useOfficial();
            return XiaomiPushResponseAssembler.INSTANCE
                    .assemble(xiaomiPushClient
                            .getSender(properties)
                            .send(XiaomiPushRequestAssembler.INSTANCE
                                            .assemble(request, properties),
                                    Arrays.asList(request.getRegistrationIds()),
                                    Math.max(1, properties.getRetries())));
        } catch (IOException | ParseException e) {
            throw new ApiException(e);
        }
    }
}
