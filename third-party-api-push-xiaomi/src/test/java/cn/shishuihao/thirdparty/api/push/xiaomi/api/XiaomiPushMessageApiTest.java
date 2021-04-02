package cn.shishuihao.thirdparty.api.push.xiaomi.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiChannel;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class XiaomiPushMessageApiTest {

    @Test
    void execute() {
        XiaomiPushApiProperties properties = new XiaomiPushApiProperties();
        properties.setAppId("appId");
        properties.setAppSecretKey("appSecretKey");
        ApiConfiguration configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.builder()
                .channelId(XiaomiPushApiChannel.CHANNEL_ID)
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