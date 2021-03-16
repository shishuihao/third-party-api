package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiChannel;
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
class ThirdPartyApiAutoConfigureSmsTest {
    @Autowired
    AliYunSmsApiChannel aliYunSmsApiChannel;
    @Autowired
    TencentSmsApiChannel tencentSmsApiChannel;

    @Test
    void test() {
        Assertions.assertEquals(aliYunSmsApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(AliYunSmsApiChannel.CHANNEL_ID));
        Assertions.assertEquals(tencentSmsApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(TencentSmsApiChannel.CHANNEL_ID));
    }
}