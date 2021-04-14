package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1002）商户支付流水查询.
 * 交易名称 商户支付流水查询 请求交易码 5W1002 内部交易码 5W1002
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 B2C外联商户支付流水查询
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1002RequestTxInfo implements TransactionInfo {
    /**
     * 起始日期 varChar(8) T.
     */
    @JacksonXmlProperty(localName = "START")
    private final String start;
    /**
     * 开始小时 varChar(2) T.
     */
    @JacksonXmlProperty(localName = "STARTHOUR")
    private final String startHour;
    /**
     * 开始分钟 varChar(2) T.
     */
    @JacksonXmlProperty(localName = "STARTMIN")
    private final String startMinute;
    /**
     * 截止日期 varChar(8) T.
     */
    @JacksonXmlProperty(localName = "END")
    private final String end;
    /**
     * 结束小时 varChar(2) T.
     */
    @JacksonXmlProperty(localName = "ENDHOUR")
    private final String endHour;
    /**
     * 结束分钟 varChar(2) T.
     */
    @JacksonXmlProperty(localName = "ENDMIN")
    private final String endMinute;
    /**
     * 流水状态 Char(1) F.
     * 0:未结流水
     * 1:已结流水
     */
    @JacksonXmlProperty(localName = "KIND")
    private final int kind;
    /**
     * 订单号   varChar(30) F 按订单号查询时，时间段不起作用.
     */
    @JacksonXmlProperty(localName = "ORDER")
    private final String orderId;
    /**
     * 结算账户号 varChar(30) T 暂不用.
     */
    @JacksonXmlProperty(localName = "ACCOUNT")
    private final String account;
    /**
     * 文件类型 Char(1) F 默认为“1”.
     * 1:不压缩
     * 2.压缩成zip文件
     */
    @JacksonXmlProperty(localName = "DEXCEL")
    private final int fileType;
    /**
     * 金额     Decimal(16,2) T 不支持以金额查询.
     */
    @JacksonXmlProperty(localName = "MONEY")
    private final String money;
    /**
     * 排序     Char(1) T.
     * 1：交易日期
     * 2：订单号
     */
    @JacksonXmlProperty(localName = "NORDERBY")
    private final Integer orderBy;
    /**
     * 当前页次 Int F.
     */
    @JacksonXmlProperty(localName = "PAGE")
    private final int page;
    /**
     * 柜台号   varChar(9) T.
     */
    @JacksonXmlProperty(localName = "POS_CODE")
    private final String posCode;
    /**
     * 订单状态 Char(1) T.
     * 0:交易失败
     * 1:交易成功
     * 2:待银行确认(针对未结流水查询)
     * 3:全部
     */
    @JacksonXmlProperty(localName = "STATUS")
    private final Integer status;
    /**
     * 子商户号   varChar(32) T.
     * 集团商户查询子商户流水时有效 .
     */
    @JacksonXmlProperty(localName = "Mrch_No")
    private final String merchantNo;
}
