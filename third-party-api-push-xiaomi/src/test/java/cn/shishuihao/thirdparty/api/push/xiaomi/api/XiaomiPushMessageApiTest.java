package cn.shishuihao.thirdparty.api.push.xiaomi.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.push.request.PushMessageRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageResponse;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class XiaomiPushMessageApiTest {

    @Test
    void execute() {
        XiaomiPushProperties properties = new XiaomiPushProperties();
        properties.setAppId("appId");
        properties.setAppSecretKey("appSecretKey");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageResponse response = ApiRegistry.INSTANCE.execute(PushMessageRequest.Builder.builder()
                .channelId("push.xiaomi")
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