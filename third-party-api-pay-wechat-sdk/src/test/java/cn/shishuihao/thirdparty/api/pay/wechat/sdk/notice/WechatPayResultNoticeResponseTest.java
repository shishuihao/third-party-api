package cn.shishuihao.thirdparty.api.pay.wechat.sdk.notice;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatPayResultNoticeResponseTest {

    @Test
    void toXml() {
        String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        WechatPayResultNoticeResponse response = WechatPayResultNoticeResponse.builder()
                .returnCode("SUCCESS")
                .returnMsg("OK")
                .build();
        Assertions.assertEquals(xml, JacksonXmlUtils.toXml(response));
    }
}