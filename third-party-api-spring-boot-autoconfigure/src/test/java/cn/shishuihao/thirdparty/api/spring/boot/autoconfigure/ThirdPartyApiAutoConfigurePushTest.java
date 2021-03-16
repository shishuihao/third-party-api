package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiChannel;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiChannel;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiChannel;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiChannel;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiChannel;
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
class ThirdPartyApiAutoConfigurePushTest {
    @Autowired
    FlymePushApiChannel flymePushApiChannel;
    @Autowired
    HuaweiPushApiChannel huaweiPushApiChannel;
    @Autowired
    OppoPushApiChannel oppoPushApiChannel;
    @Autowired
    VivoPushApiChannel vivoPushApiChannel;
    @Autowired
    XiaomiPushApiChannel xiaomiPushApiChannel;

    @Test
    void test() {
        Assertions.assertEquals(flymePushApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(FlymePushApiChannel.CHANNEL_ID));
        Assertions.assertEquals(huaweiPushApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(HuaweiPushApiChannel.CHANNEL_ID));
        Assertions.assertEquals(oppoPushApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(OppoPushApiChannel.CHANNEL_ID));
        Assertions.assertEquals(vivoPushApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(VivoPushApiChannel.CHANNEL_ID));
        Assertions.assertEquals(xiaomiPushApiChannel, ApiRegistry.INSTANCE
                .getApiChannelOrThrow(XiaomiPushApiChannel.CHANNEL_ID));
    }
}