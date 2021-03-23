package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@JacksonXmlRootElement(localName = "xml")
public class WxPayPayitilReportRequest extends AbstractWxPayXmlRequest {
    /**
     * 接口URL.
     */
    @WxParameter(
            name = "接口URL",
            required = true, type = "String(127)",
            example = "https://api.mch.weixin.qq.com"
                    + "/pay/batchreport/micropay/total",
            desc = "刷卡支付终端上报统一填：https://api.mch.weixin.qq.com"
                    + "/pay/batchreport/micropay/total")
    @JacksonXmlProperty(localName = "interface_url")
    private final String interfaceUrl;
    /**
     * 访问接口IP.
     */
    @WxParameter(
            name = "访问接口IP",
            required = true, type = "String(16)",
            example = "8.8.8.8",
            desc = "发起接口调用时的机器IP")
    @JacksonXmlProperty(localName = "user_ip")
    private final String userIp;
    /**
     * 上报数据包.
     */
    @WxParameter(
            name = "上报数据包",
            required = true, type = "String(1024)",
            example = "!CDATA[\n"
                    + "[\n"
                    + "    {\n"
                    + "        \"out_trade_no\": \"out_trade_no_test_1\",\n"
                    + "        \"begin_time\": \"20160602203256\",\n"
                    + "        \"end_time\": \"20160602203257\",\n"
                    + "        \"state\": \"OK\",\n"
                    + "        \"err_msg\": \"\"\n"
                    + "    },\n"
                    + "    {\n"
                    + "        \"out_trade_no\": \"out_trade_no_test_2\",\n"
                    + "        \"begin_time\": \"20160602203260\",\n"
                    + "        \"end_time\": \"20160602203262\",\n"
                    + "        \"state\": \"FAIL\",\n"
                    + "        \"err_msg\": \"SYSTEMERROR\"\n"
                    + "    }\n"
                    + "]\n"
                    + "]",
            desc = "POS机采集的交易信息列表，使用JSON格式的数组，每条交易包含：\n"
                    + "1. out_trade_no 商户订单号\n"
                    + "2. begin_time 交易开始时间（扫码时间)\n"
                    + "3. end_time 交易完成时间\n"
                    + "4. state 交易结果\n"
                    + "                   OK   -成功 \n"
                    + "                   FAIL -失败 \n"
                    + "                   CANCEL-取消\n"
                    + "5. err_msg 自定义的错误描述信息\n"
                    + "*注意，将JSON数组的文本串放到XML节点中时，需要使用!CDATA[]标签将JSON文本串保护起来")
    @JacksonXmlProperty(localName = "trades")
    private final String trades;
}
