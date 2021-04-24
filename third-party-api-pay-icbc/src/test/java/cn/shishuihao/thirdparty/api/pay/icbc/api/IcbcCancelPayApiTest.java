package cn.shishuihao.thirdparty.api.pay.icbc.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class IcbcCancelPayApiTest {
    IcbcPayApiProperties properties = new IcbcPayApiProperties();
    ApiConfiguration configuration;

    @BeforeEach
    void beforeEach() {
        properties.setAppId("appId");
        properties.setPrivateKey("privateKey");
        properties.setIcbcPublicKey("icbcPublicKey");
        configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
    }

    @Test
    void execute() {
        CancelPayApiRequest request = CancelPayApiRequest.builder()
                .channelId(IcbcPayApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .outTradeNo("2234567890")
                .authCode("")
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("com.icbc.api.IcbcApiException: sign exception."));
    }
}