package cn.shishuihao.thirdparty.api.push.xiaomi.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
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
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        PushMessageApiResponse response = ApiRegistry.INSTANCE.execute(PushMessageApiRequest.Builder.builder()
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