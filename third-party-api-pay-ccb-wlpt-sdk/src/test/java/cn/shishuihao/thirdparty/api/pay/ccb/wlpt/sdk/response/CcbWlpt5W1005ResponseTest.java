package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1005ResponseTest {

    @Test
    void fromXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>   \n" +
                "  <TX>  \n" +
                "   <REQUEST_SN>请求序列码</REQUEST_SN>   \n" +
                "   <CUST_ID>商户号</CUST_ID>   \n" +
                "   <TX_CODE>5W1002</TX_CODE>   \n" +
                "   <RETURN_CODE>响应码</RETURN_CODE>   \n" +
                "   <RETURN_MSG>响应信息</RETURN_MSG>  \n" +
                "   <LANGUAGE>CN</LANGUAGE>  \n" +
                "  <TX_INFO>  \n" +
                "   <FILE_NAME>当前页次</FILE_NAME>   \n" +
                "   <NOTICE>提示信息</NOTICE>  \n" +
                "  </TX_INFO>  \n" +
                "  </TX> \n";
        final CcbWlpt5W1005Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W1005Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}