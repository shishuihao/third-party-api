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
public class WxPayDownloadFundFowRequest extends AbstractWxPayXmlRequest {
    /**
     * 资金账单日期.
     */
    @WxParameter(
            name = "资金账单日期",
            required = true, type = "String(8)",
            example = "20140603",
            desc = "下载对账单的日期，格式：20140603")
    @JacksonXmlProperty(localName = "bill_date")
    private final String billDate;
    /**
     * 资金账户类型.
     */
    @WxParameter(
            name = "资金账户类型",
            required = true, type = "String(8)",
            example = "Basic",
            desc = "账单的资金来源账户：\n"
                    + "Basic  基本账户\n"
                    + "Operation 运营账户\n"
                    + "Fees 手续费账户")
    @JacksonXmlProperty(localName = "account_type")
    private final String accountType;
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
