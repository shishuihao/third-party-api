package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1015）历史订单退款交易.
 * 交易名称 历史订单退款交易 请求交易码 5W1015 内部交易码 5W1015
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 外联平台支付交易，一次往返。（报文串需要整个字符串传送，中间需无回车符，否则会签名出错）
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1015RequestTxInfo implements TransactionInfo {
    /**
     * 订单号 varChar(30) F.
     */
    @JacksonXmlProperty(localName = "ORDERID")
    private final String orderId;
    /**
     * 退款金额 Decimal F.
     */
    @JacksonXmlProperty(localName = "PAYMENT")
    private final String payment;
    /**
     * 货币代码 varChar(2) F.
     * 货币代码，默认01，现在只支持01
     * 01：人民币
     */
    @JacksonXmlProperty(localName = "CURCODE")
    private final String currencyCode;
    /**
     * 一级行号 varChar(9) F.
     * 商户所属分行号
     */
    @JacksonXmlProperty(localName = "BRANCHID")
    private final String branchId;
    /**
     * 网银柜台编号 varChar(9) F.
     */
    @JacksonXmlProperty(localName = "POSID")
    private final String posId;
    /**
     * 部分退款标志 varChar(1) F.
     * '0'为全额退货
     * '1'为部分退货
     */
    @JacksonXmlProperty(localName = "BACKFLAG")
    private final int backFlag;
}
