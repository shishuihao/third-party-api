package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlptRefundQueryPayApiTest {
    CcbWlptPayApiProperties properties = new CcbWlptPayApiProperties();
    ApiConfiguration configuration;

    @BeforeEach
    void beforeEach() {
        properties.setCustomerId("customerId");
        properties.setUserId("userId");
        properties.setPassword("password");
        properties.setKeyStoreType("PKCS12");
        properties.setKeyStorePassword("keyStorePassword");
        properties.setKeyStorePath("customerId-userId.pfx");
        configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
    }

    @Test
    void execute() {
        RefundQueryPayApiRequest request = RefundQueryPayApiRequest.builder()
                .channelId(CcbWlptPayApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .outTradeNo("2234567890")
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("nl.altindag.sslcontext.exception.GenericKeyStoreException: Failed to load the keystore"));
    }
}