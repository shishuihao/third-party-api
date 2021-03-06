package cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AppIdTest {

    @Test
    void of() {
        Assertions.assertEquals("<appid>wx2421b1c4370ec43b</appid>", XmlUtils.toXml(AppId.of("wx2421b1c4370ec43b")));
    }
}