package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1016）历史订单退款结果查询.
 * 交易名称 历史订单退款结果查询 请求交易码 5W1016 内部交易码 5W1016
 * 后端系统 ECTIP 交易类型 查询类 XML示例 Sample
 * 交易说明 外联平台支付交易，一次往返。（报文串需要整个字符串传送，中间需无回车符，否则会签名出错）
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1016RequestTxInfo implements TransactionInfo {
    /**
     * 订单号 varChar(30) F.
     * 按订单号查询时，时间段不起作用
     */
    @JacksonXmlProperty(localName = "ORDERID")
    private final String orderId;
    /**
     * 起始日期 varChar(8) T.
     */
    @JacksonXmlProperty(localName = "STARTDATE")
    private final String startDate;
    /**
     * 结束日期 varChar(8) T.
     */
    @JacksonXmlProperty(localName = "ENDDATE")
    private final String endDate;
    /**
     * 页次 Int F.
     */
    @JacksonXmlProperty(localName = "PAGE")
    private final int page;
}
