package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AlipayCodePayApiTest {

    @Test
    void execute() {
        AlipayPayApiProperties properties = new AlipayPayApiProperties();
        properties.setAppId("appId");
        properties.setMerchantPrivateKey("");
        properties.setAlipayPublicKey("");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        CodePayApiRequest request = CodePayApiRequest.builder()
                .channelId(AlipayPayApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .subject("Apple iPhone11 128G")
                .outTradeNo("2234567890")
                .totalAmount(1)
                .authCode("")
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("java.lang.RuntimeException: java.lang.RuntimeException: 签名遭遇异常"));
    }
}