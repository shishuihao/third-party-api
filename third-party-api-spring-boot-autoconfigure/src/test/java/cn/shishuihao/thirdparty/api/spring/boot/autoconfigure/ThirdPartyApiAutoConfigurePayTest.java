package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiChannel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ThirdPartyApiAutoConfigureApplication.class})
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ThirdPartyApiAutoConfigurePayTest {
    @Autowired
    AlipayPayApiChannel alipayPayApiChannel;
    @Autowired
    IcbcPayApiChannel icbcPayApiChannel;
    @Autowired
    WechatPayApiChannel wechatPayApiChannel;

    @Test
    void test() {
        Assertions.assertEquals(alipayPayApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(AlipayPayApiChannel.CHANNEL_ID));
        Assertions.assertEquals(icbcPayApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(IcbcPayApiChannel.CHANNEL_ID));
        Assertions.assertEquals(wechatPayApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(WechatPayApiChannel.CHANNEL_ID));
    }
}