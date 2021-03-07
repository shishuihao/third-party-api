package cn.shishuihao.thirdparty.api.pay.weixin.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxCodePayApiTest {

    @Test
    void execute() {
        WxPayApiProperties properties = new WxPayApiProperties();
        properties.setAppId("appId");
        properties.setKey("key");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        CodePayApiRequest request = CodePayApiRequest.builder()
                .channelId(WxPayApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .subject("Apple iPhone11 128G")
                .outTradeNo("2234567890")
                .totalAmount(1)
                .authCode("")
                .build();
        Assertions.assertEquals("mch_id参数格式错误", ApiRegistry.INSTANCE.execute(request).getMessage());
    }
}