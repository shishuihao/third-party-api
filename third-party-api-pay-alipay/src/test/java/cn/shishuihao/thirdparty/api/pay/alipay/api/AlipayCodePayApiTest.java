package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AlipayCodePayApiTest {
    AlipayPayApiProperties properties = new AlipayPayApiProperties();
    ApiConfiguration configuration;

    @BeforeEach
    void beforeEach() {
        properties.setAppId("appId");
        properties.setMerchantPrivateKey("");
        properties.setAlipayPublicKey("");
        configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.add(configuration);
    }

    @Test
    void execute() {
        CodePayApiRequest request = CodePayApiRequest.builder()
                .channelId(AlipayPayApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .subject("Apple iPhone11 128G")
                .outTradeNo("2234567890")
                .totalAmount(1)
                .authCode("")
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("java.lang.RuntimeException: java.lang.RuntimeException: 签名遭遇异常"));
    }
}