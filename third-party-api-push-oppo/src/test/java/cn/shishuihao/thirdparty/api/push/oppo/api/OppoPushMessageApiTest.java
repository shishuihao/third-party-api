package cn.shishuihao.thirdparty.api.push.oppo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiChannel;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class OppoPushMessageApiTest {

    @Test
    void execute() {
        OppoPushApiProperties properties = new OppoPushApiProperties();
        properties.setAppKey("appKey");
        properties.setMasterSecret("masterSecret");
        ApiConfiguration configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
        PushMessageApiRequest request = PushMessageApiRequest.builder()
                .channelId(OppoPushApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .title("title")
                .description("description")
                .payload("payload")
                .restrictedPackageName("restrictedPackageName")
                .registrationIds(new String[]{"registrationId"})
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertEquals("java.lang.RuntimeException: get token error: {\"reason\":\"OK\",\"returnCode\":{\"code\":14,\"message\":\"Invalid App Key\"},\"statusCode\":200}", apiException.getMessage());
    }
}