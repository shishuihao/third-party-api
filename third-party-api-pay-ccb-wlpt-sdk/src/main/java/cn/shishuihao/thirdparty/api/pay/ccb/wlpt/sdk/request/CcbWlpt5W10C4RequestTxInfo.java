package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W10C4）线下集团商户单笔退款.
 * <p>
 * 交易名称 线下集团商户单笔退款 请求交易码 5W10C4 内部交易码 5W10C4
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 B2C线下集团商户单笔退款
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W10C4RequestTxInfo implements CcbWlptTxInfo {
    /**
     * 退款金额 varChar(100) F.
     */
    @JacksonXmlProperty(localName = "MONEY")
    private final String money;
    /**
     * 订单号 varChar(30) F.
     * 订单号和系统参考号必须选一.
     */
    @JacksonXmlProperty(localName = "Ordr_ID")
    private final String orderId;
    /**
     * 退款流水号 varChar(15) T 可不填，商户可根据需要填写，退款流水号由商户的系统生成.
     */
    @JacksonXmlProperty(localName = "REFUND_CODE")
    private final String refundCode;
    /**
     * 退款系统参考号 varChar(12) T 刷卡消费退货时，由商户填写，用于唯一区分退货流水.
     */
    @JacksonXmlProperty(localName = "Rtrvl_Ref_No")
    private final String refundRefNo;
    /**
     * 退款子商户号 varChar(15) F 退款商户号（实际退款商户）.
     */
    @JacksonXmlProperty(localName = "Mrch_No")
    private final String merchantNo;
    /**
     * 支付返回的全局事件跟踪号  varChar(25) T.
     */
    @JacksonXmlProperty(localName = "OriOvrlsttnEV_Trck_No")
    private final String trackNo;
    /**
     * 清算交易码 varChar(9) T.
     */
    @JacksonXmlProperty(localName = "Clrg_Txn_CD")
    private final String clearingTransactionCode;
    /**
     * 系统参考号 varChar(15) F.
     * 订单号和系统参考号必须选一.
     */
    @JacksonXmlProperty(localName = "rXtNo")
    private final String rxtNo;
}
