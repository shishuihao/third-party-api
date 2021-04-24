package cn.shishuihao.thirdparty.api.pay.wechat.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatPayDownloadBillRequestTest {

    @Test
    void toXml() {
        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <bill_date>20141110</bill_date>\n" +
                "   <bill_type>ALL</bill_type>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>21df7dc9cd8616b56919f20d9f679233</nonce_str>\n" +
                "   <sign>332F17B766FC787203EBE9D6E40457A1</sign>\n" +
                "</xml>";
        WechatPayDownloadBillRequest request = WechatPayDownloadBillRequest.builder()
                .appId("wx2421b1c4370ec43b")
                .mchId("10000100")
                .nonceStr("21df7dc9cd8616b56919f20d9f679233")
                .billDate("20141110")
                .billType("ALL")
                .sign("332F17B766FC787203EBE9D6E40457A1")
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}