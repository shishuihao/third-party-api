package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W101B）线下商户交易流水查询.
 * 交易名称 线下商户交易流水查询 请求交易码 5W101B 内部交易码 5W101B
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 B2C外联线下商户交易流水查询
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W101BRequestTxInfo implements CcbWlptTxInfo {
    /**
     * 交易类型 Char(1) F.
     * 2-全部；
     * A-消费；
     * B-消费撤销；
     * C-退货；
     * D-预授权撤销；
     * E-预授权完成；
     * F-预授权完成撤销；
     * G-分期付款（含分期退货）；
     * H-电子现金；
     * I-积分兑换；
     * a-允许退货
     */
    @JacksonXmlProperty(localName = "TX_SPECIAL_EC")
    private final String transactionSpecialEc;
    /**
     * 流水类型 varChar(14) F.
     * 0-未出账单
     * 1-已出账单
     * 2-未出+已出
     */
    @JacksonXmlProperty(localName = "Clrg_StCd")
    private final String clearingStatusCode;
    /**
     * 开始日期时间 varChar(14) F.
     * 格式[yyyymmddhhffss]
     */
    @JacksonXmlProperty(localName = "StDt_Tm")
    private final String startDateTime;
    /**
     * 结束日期时间 varChar(14) F.
     * 格式[yyyymmddhhffss]
     */
    @JacksonXmlProperty(localName = "EdDt_Tm")
    private final String endDateTime;
    /**
     * 系统参考号 varChar(12) T.
     */
    @JacksonXmlProperty(localName = "Rtrvl_Ref_No")
    private final String refNo;
    /**
     * 订单编号 varChar(60) T.
     */
    @JacksonXmlProperty(localName = "OnLn_Py_Txn_Ordr_ID")
    private final String orderId;
    /**
     * 场景标识 varChar(3) T.
     * L01 - 龙支付
     * Y01 - 被扫
     * Y02 - 主扫
     * ZFB - 聚合支付支付宝
     * CFT - 聚合支付微信
     * Q01 - 客户回馈的券处理商户账
     */
    @JacksonXmlProperty(localName = "Scn_Idr")
    private final String sceneId;
    /**
     * 排序方式类别代码   varChar(19) T.
     * 0按日期
     * 1按订单
     * 默认0
     */
    @JacksonXmlProperty(localName = "Seq_Mod_CgyCd")
    private final String seqModCategoryCode;
    /**
     * POS终端编号 varChar(19) T.
     */
    @JacksonXmlProperty(localName = "POS_ID")
    private final String posId;
    /**
     * 交易卡号 varChar(32) T.
     */
    @JacksonXmlProperty(localName = "Cst_AccNo")
    private final String cstAccNo;
    /**
     * 交易区间最小金额     Decimal(16,2) T.
     */
    @JacksonXmlProperty(localName = "Rng_Min_Amt")
    private final String rangeMinAmount;
    /**
     * 交易区间最大金额     Decimal(16,2) T.
     */
    @JacksonXmlProperty(localName = "Rng_Max_Amt")
    private final String rangeMaxAmount;
    /**
     * 交易状态   varChar(2) T.
     * 00-交易成功标志
     * 01-交易失败
     * 02-不确定
     */
    @JacksonXmlProperty(localName = "Txn_Status")
    private final String transactionStatus;
    /**
     * 网银凭证号 varChar(12) T.
     */
    @JacksonXmlProperty(localName = "EBNK_VCHR_NO")
    private final String ebankVoucherNo;
    /**
     * 流水跟踪号  varChar(25) T.
     */
    @JacksonXmlProperty(localName = "OriOvrlsttnEV_Trck_No")
    private final String trackNo;
    /**
     * 原交易的清算交易码   varChar(9) T.
     */
    @JacksonXmlProperty(localName = "Ori_Txn_ECD")
    private final String originTransactionEcd;
    /**
     * 子商户号   varChar(32) T.
     * 集团商户查询子商户流水时有效
     */
    @JacksonXmlProperty(localName = "Mrch_No")
    private final String merchantNo;
    /**
     * 当前页次 Int F.
     */
    @JacksonXmlProperty(localName = "PAGE")
    private final int page;
}
