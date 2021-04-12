package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1004）商户单笔退款交易.
 * 交易名称 商户单笔退款交易 请求交易码 5W1004 内部交易码 5W1004
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 B2C商户单笔退款交易
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1004RequestTxInfo implements TransactionInfo {
    /**
     * 退款金额 varChar(100) F.
     */
    @JacksonXmlProperty(localName = "MONEY")
    private final String money;
    /**
     * 订单号 varChar(30) F
     */
    @JacksonXmlProperty(localName = "ORDER")
    private final String orderId;
    /**
     * 退款流水号 varChar(15) T 可不填，商户可根据需要填写，退款流水号由商户的系统生成.
     */
    @JacksonXmlProperty(localName = "REFUND_CODE")
    private final String refundCode;
}
