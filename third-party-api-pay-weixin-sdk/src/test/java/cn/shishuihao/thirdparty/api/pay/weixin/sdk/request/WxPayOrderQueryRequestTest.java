package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.AppId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.MchId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxPayOrderQueryRequestTest {

    @Test
    void toXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>ec2316275641faa3aacf3cc599e8730f</nonce_str>\n" +
                "   <transaction_id>1008450740201411110005820873</transaction_id>\n" +
                "   <sign>FDD167FAA73459FD921B144BAF4F4CA2</sign>\n" +
                "</xml>";
        WxPayOrderQueryRequest request = WxPayOrderQueryRequest.Builder.builder()
                .appId(AppId.of("wx2421b1c4370ec43b"))
                .mchId(MchId.of("10000100"))
                .nonceStr("ec2316275641faa3aacf3cc599e8730f")
                .transactionId("1008450740201411110005820873")
                .sign("FDD167FAA73459FD921B144BAF4F4CA2")
                .build();
        Assertions.assertEquals(XmlUtils.fromXml(xml, HashMap.class), XmlUtils.fromXml(request.toXml(), HashMap.class));
    }
}