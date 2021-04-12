package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1024）线上集团商户单笔退款.
 * 交易名称 线上集团商户单笔退款 请求交易码 5W1024 内部交易码 5W1024
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 B2C线上集团商户单笔退款
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1024RequestTxInfo implements TransactionInfo {
    /**
     * 退款金额 varChar(100) F.
     */
    @JacksonXmlProperty(localName = "MONEY")
    private final String money;
    /**
     * 订单号 varChar(30) F.
     */
    @JacksonXmlProperty(localName = "ORDER")
    private final String orderId;
    /**
     * 退款流水号 varChar(15) T 可不填，商户可根据需要填写，退款流水号由商户的系统生成.
     */
    @JacksonXmlProperty(localName = "REFUND_CODE")
    private final String refundCode;
    /**
     * 退款子商户号 varChar(15) F 退款商户号（实际退款商户）.
     */
    @JacksonXmlProperty(localName = "Mrch_No")
    private final String merchantNo;
}
