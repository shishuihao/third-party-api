package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1006ResponseTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>   \n" +
            "  <TX>  \n" +
            "   <REQUEST_SN>请求序列码</REQUEST_SN>   \n" +
            "   <CUST_ID>商户号</CUST_ID>   \n" +
            "   <TX_CODE>5W1006</TX_CODE>   \n" +
            "   <RETURN_CODE>响应码</RETURN_CODE>   \n" +
            "   <RETURN_MSG>响应信息</RETURN_MSG>  \n" +
            "   <LANGUAGE>CN</LANGUAGE>  \n" +
            "  <TX_INFO>  \n" +
            "   <MER_CODE>商户号</MER_CODE>   \n" +
            "   <AUTH_DATE>授权日期</AUTH_DATE>   \n" +
            "   <GRANT_NUM>授权号</GRANT_NUM>   \n" +
            "   <CUSTOMER_NAME>客户姓名</CUSTOMER_NAME>   \n" +
            "   <SINGLE_TRAN_LIMIT>单笔交易限额</SINGLE_TRAN_LIMIT>   \n" +
            "   <DAY_TRAN_LIMIT>日累计交易限额</DAY_TRAN_LIMIT>  \n" +
            "   <GRANT_FLAG>预留字段</GRANT_FLAG>   \n" +
            "  </TX_INFO>  \n" +
            "  </TX> \n";

    @Test
    void fromXml() {
        final CcbWlpt5W1006Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W1006Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}