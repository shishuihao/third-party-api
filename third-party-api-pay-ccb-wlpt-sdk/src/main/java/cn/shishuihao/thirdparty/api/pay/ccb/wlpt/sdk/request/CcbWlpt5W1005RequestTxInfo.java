package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1005）商户流水文件下载.
 * 交易名称 商户流水文件下载 请求交易码 5W100505 内部交易码 5W1005
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 B2C外联商户流水文件下载查询，返回文件名后，通过6W0111交易进行文件下载
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1005RequestTxInfo implements TransactionInfo {
    /**
     * 日期 varChar(8) F YYYYMMDD.
     */
    @JacksonXmlProperty(localName = "DATE")
    private final String date;
    /**
     * 流水状态 Char(1) F.
     * 1：已结流水（默认），
     * 0：未结流水 （POS商户送1） .
     */
    @JacksonXmlProperty(localName = "KIND")
    private final int kind;
    /**
     * 文件类型 Char(1) F.
     * 1-txt（默认）
     * 2-excel
     * 3-txt+excel（POS商户、龙商户送1；
     * 网络特约商户可送1/2/3，对账单下载时间在3秒内为实时返回账单文件名，
     * 超过3秒转为异步下载，具体请参考应答报文RETURN_CODE字段说明处理）.
     */
    @JacksonXmlProperty(localName = "FILETYPE")
    private final int fileType;
    /**
     * 流水类型.     Char(1) T
     * 0：支付流水；
     * 1：退款流水 （KIND为0时有效且非空）
     */
    @JacksonXmlProperty(localName = "TYPE")
    private final Integer type;
    /**
     * 排序     Char(1) T.
     * 1：交易日期；
     * 2：订单号 （KIND为0时有效） .
     */
    @JacksonXmlProperty(localName = "NORDERBY")
    private final Integer orderBy;
    /**
     * 柜台号   varChar(9) T 不输入为全部 （KIND为0时有效）.
     */
    @JacksonXmlProperty(localName = "POS_CODE")
    private final String posCode;
    /**
     * 订单号 varChar(30) T （KIND为0时有效）.
     */
    @JacksonXmlProperty(localName = "ORDER")
    private final String order;
    /**
     * 订单状态 Char(1) T.
     * 0：交易失败,
     * 1：交易成功,
     * 2：待银行确认(未结流水);
     * 3：全部(未结流水) （KIND为0时有效且非 .
     */
    @JacksonXmlProperty(localName = "STATUS")
    private final Integer status;
    /**
     * 对账单标志 Char(1) T.
     * 0-旧
     * 1-新（默认）（KIND为0时有效） .
     */
    @JacksonXmlProperty(localName = "BILL_FLAG")
    private final Integer billFlag;
    /**
     * 子商户号   varChar(32) T.
     * 集团商户查询子商户流水时有效，支持全部下载(送-all) .
     */
    @JacksonXmlProperty(localName = "Mrch_No")
    private final String merchantNo;
    /**
     * 集团账单汇总标志 Char(1) T.
     * 0-打包对账单（默认）
     * 1-汇总对账单
     * 2-打包+汇总对账单（网络特约商户且KIND为1、Mrch_No为all时有效）
     */
    @JacksonXmlProperty(localName = "GROUP_FLAG ")
    private final Integer groupFlag;
}
