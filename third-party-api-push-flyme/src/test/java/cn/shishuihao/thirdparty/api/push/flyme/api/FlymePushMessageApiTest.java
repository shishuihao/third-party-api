package cn.shishuihao.thirdparty.api.push.flyme.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiChannel;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiProperties;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class FlymePushMessageApiTest {

    @Test
    void execute() {
        FlymePushApiProperties properties = new FlymePushApiProperties();
        properties.setAppId(0L);
        properties.setAppSecret("appSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.Builder.builder()
                .channelId(FlymePushApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build());
        Assertions.assertNotNull(response);
    }
}