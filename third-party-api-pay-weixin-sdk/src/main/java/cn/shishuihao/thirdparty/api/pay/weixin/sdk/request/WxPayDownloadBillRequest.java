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
public class WxPayDownloadBillRequest extends AbstractWxPayXmlRequest {
    /**
     * 对账单日期.
     */
    @WxParameter(
            name = "对账单日期",
            required = true, type = "String(8)",
            example = "20140603",
            desc = "下载对账单的日期，格式：20140603")
    @JacksonXmlProperty(localName = "bill_date")
    private final String billDate;
    /**
     * 账单类型.
     */
    @WxParameter(
            name = "账单类型",
            required = false, type = "String(8)",
            example = "ALL",
            desc = "ALL（默认值），返回当日所有订单信息（不含充值退款订单）\n"
                    + "SUCCESS，返回当日成功支付的订单（不含充值退款订单）\n"
                    + "REFUND，返回当日退款订单（不含充值退款订单）\n"
                    + "RECHARGE_REFUND，返回当日充值退款订单")
    @JacksonXmlProperty(localName = "bill_type")
    private final String billType;
    /**
     * 压缩账单.
     */
    @WxParameter(
            name = "压缩账单",
            required = false, type = "String",
            example = "GZIP",
            desc = "非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。")
    @JacksonXmlProperty(localName = "tar_type")
    private final String tarType;
}
