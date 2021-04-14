package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1016ResponseTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>   \n" +
            "  <TX>  \n" +
            "   <REQUEST_SN>请求序列码</REQUEST_SN>   \n" +
            "   <TX_CODE>5W1016</TX_CODE>   \n" +
            "   <RETURN_CODE>响应码</RETURN_CODE>   \n" +
            "   <RETURN_MSG>响应信息</RETURN_MSG>  \n" +
            "  <TX_INFO>  \n" +
            "   <CUR_PAGE>1</CUR_PAGE>   \n" +
            "   <LIST>  \n" +
            "    <TRAN_DATE>>交易日期</TRAN_DATE>>   \n" +
            "    <REFUND_DATE>退款日期</REFUND_DATE>   \n" +
            "    <ORDER_NUMBER>订单号</ORDER_NUMBER>   \n" +
            "    <REFUNDEMENT_AMOUNT>退款金额</REFUNDEMENT_AMOUNT>   \n" +
            "    <POS_CODE>柜台号</POS_CODE>   \n" +
            "    <USERID>操作员</USERID>   \n" +
            "    <STATUS>1</STATUS>   \n" +
            "    <ERRCODE>订单退款失败错误码</ERRCODE>   \n" +
            "    <ERRMSG>失败原因</ERRMSG>   \n" +
            "   </LIST>  \n" +
            "   </TX_INFO> \n" +
            " </TX> \n";

    @Test
    void fromXml() {
        final CcbWlpt5W1016Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W1016Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}