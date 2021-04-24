package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AlipayRefundPayApiTest {
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
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
    }

    @Test
    void execute() {
        RefundPayApiRequest request = RefundPayApiRequest.builder()
                .channelId(AlipayPayApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .outTradeNo("2234567890")
                .refundAmount(1)
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().contains("java.lang.RuntimeException: java.lang.RuntimeException: 签名遭遇异常"));
    }
}