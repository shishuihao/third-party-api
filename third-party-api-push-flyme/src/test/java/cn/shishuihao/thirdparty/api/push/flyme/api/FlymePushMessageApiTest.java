package cn.shishuihao.thirdparty.api.push.flyme.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
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
        ApiConfiguration configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.add(configuration);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.builder()
                .channelId(FlymePushApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build());
        Assertions.assertNotNull(response);
    }
}