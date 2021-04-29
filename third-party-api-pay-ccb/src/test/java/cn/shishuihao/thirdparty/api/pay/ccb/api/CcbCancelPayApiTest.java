package cn.shishuihao.thirdparty.api.pay.ccb.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbCancelPayApiTest {
    CcbPayApiProperties properties = new CcbPayApiProperties();
    ApiConfiguration configuration;

    @BeforeEach
    void beforeEach() {
        properties.setCustomerId("customerId");
        properties.setUserId("userId");
        properties.setPassword("password");
        properties.setKeyStoreType("PKCS12");
        properties.setKeyStorePassword("keyStorePassword");
        properties.setKeyStorePath("customerId-userId.pfx");
        // ccb
        properties.setPosId("posId");
        properties.setBranchId("branchId");
        properties.setPublicKey("publicKey");
        properties.setMerchantFlag(1);
        properties.setProductInfo("productInfo");
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
                .channelId(CcbPayApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .outTradeNo("2234567890")
                .authCode("")
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("nl.altindag.sslcontext.exception.GenericKeyStoreException: Failed to load the keystore"));
    }
}