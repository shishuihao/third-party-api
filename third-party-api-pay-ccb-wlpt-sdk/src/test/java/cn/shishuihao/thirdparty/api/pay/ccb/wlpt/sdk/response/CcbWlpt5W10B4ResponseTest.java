package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W10B4ResponseTest {

    @Test
    void fromXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
                "<TX> \n" +
                "  <REQUEST_SN>请求序列号</REQUEST_SN> \n" +
                "  <CUST_ID>商户号</CUST_ID> \n" +
                "  <TX_CODE>5W10B4</TX_CODE> \n" +
                "  <RETURN_CODE>返回码</RETURN_CODE> \n" +
                "  <RETURN_MSG>返回码说明</RETURN_MSG> \n" +
                "  <LANGUAGE>CN</LANGUAGE> \n" +
                "  <TX_INFO> \n" +
                "    <Ordr_ID>订单号</Ordr_ID> \n" +
                "    <PAY_AMOUNT>支付金额</PAY_AMOUNT> \n" +
                "    <AMOUNT>退款金额</AMOUNT> \n" +
                "    <rXtNo>系统参考号</rXtNo> \n" +
                "    <REM1>备注1</REM1> \n" +
                "    <REM2>备注2</REM2> \n" +
                "  </TX_INFO>   \n" +
                "</TX> \n";
        final CcbWlpt5W10B4Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W10B4Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}