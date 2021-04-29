package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.event;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * 支付结果通知.
 * 支付完成后，渠道方会通知网付前置账单系统，账单系统收到通知后会组织结果信息发送通知到商户的通知地址。
 * 商户的通知地址可以在商户信息中配置，也可以在上送详单信息时上送，
 * 若都多处都配置了通知地址，那么账单系统会把结果通知到所有的地址上。
 * 注意：商户收到通知后，需要对通知做出响应：
 * 成功收到时响应”SUCCESS”；失败时响应”FAILED”。
 * 针对重复收到通知的问题处理：如果网付没有收到商户响应的SUCCESS，或者网络异常，系统会在24小时内尝试多次通知。
 * 商户收到重复通知时可以执行以下 1或2进行处理:
 * 1. 商户主动调网付查询接口，以查询结果为准。
 * 2. 通知报文里面有商户订单号，商户可根据订单号和订单状态判断是否是重复通知，并忽略已经处理了的订单的重复通知。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class ChinaumsPayResultNotify {
    /**
     * 商户号 字符串 否.
     */
    private final String mid;
    /**
     * 终端号 字符串 否.
     */
    private final String tid;
    /**
     * 业务类型 字符串 否.
     */
    private final String instMid;
    /**
     * 附加数据 字符串 否.
     */
    private final String attachedData;
    /**
     * 支付银行信息 字符串 否.
     */
    private final String bankCardNo;
    /**
     * 资金渠道 字符串 否.
     */
    private final String billFunds;
    /**
     * 资金渠道说明 字符串 否.
     */
    private final String billFundsDesc;
    /**
     * 卖家ID 字符串 否.
     */
    private final String buyerId;
    /**
     * 买家用户名 字符串 否.
     */
    private final String buyerUsername;
    /**
     * 实付金额 数字型 否.
     */
    private final String buyerPayAmount;
    /**
     * 订单金额，单位分 数字型 否.
     */
    private final String totalAmount;
    /**
     * 开票金额 数字型 否.
     */
    private final String invoiceAmount;
    /**
     * 商户订单号 字符串 否.
     */
    private final String merOrderId;
    /**
     * 支付时间 字符串 是 格式yyyy-MM- dd HH:mm:ss receiptAmount 实收金额 数字型 否.
     */
    private final String payTime;
    /**
     * 支付银行卡参 考号 字符串 否.
     */
    private final String refId;
    /**
     * 退款金额 数字型 否. 退货交易
     */
    private final String refundAmount;
    /**
     * 退款说明 字符串 否. 退货交易
     */
    private final String refundDesc;
    /**
     * 系统交易流水 号 字符串 否.
     */
    private final String seqId;
    /**
     * 结算日期 字符串 否. 格式yyyy-MM- dd
     */
    private final String settleDate;
    /**
     * 订单状态 字符串 否. 取值说明
     */
    private final String status;
    /**
     * 卖家子ID 字符串 否.
     */
    private final String subBuyerId;
    /**
     * 渠道订单号 字符串 否.
     */
    private final String targetOrderId;
    /**
     * 支付渠道 字符串 否. 取值说明
     */
    private final String targetSys;
    /**
     * 签名 字符串 否.
     */
    private final String sign;
    /**
     * 商户出资优惠 金额 数字型 否.
     */
    private final String couponMerchantContribute;
    /**
     * 其他出资优惠 金额 数字型 否.
     */
    private final String couponOtherContribute;
    /**
     * 微信活动ID 字符串 否.
     */
    private final String activityIds;
    /**
     * 退货渠道订单 号 字符串 否.
     */
    private final String refundTargetOrderId;
    /**
     * 退货时间 字符串 否.
     */
    private final String refundPayTime;
    /**
     * 结算日期 字符串 否.
     */
    private final String refundSettleDate;
    /**
     * 订单详情 字符串 否.
     */
    private final String orderDesc;
    /**
     * 订单创建时间 字符串 否.
     */
    private final String createTime;
    /**
     * 商户UUID 字符串 否.
     */
    private final String mchntUuid;
    /**
     * 转接系统 字符串 否.
     */
    private final String connectSys;
    /**
     * 商户所属分支 机构代码 字符串 否.
     */
    private final String subInst;
    /**
     * 联盟优惠金额 数字型 否.
     */
    private final String yxlmAmount;
    /**
     * 退货外部订单 号 字符串 否.
     */
    private final String refundExtOrderId;
    /**
     * 商品交易单号 字符串 否.
     */
    private final String goodsTradeNo;
    /**
     * 外部订单号 字符串 否.
     */
    private final String extOrderId;
    /**
     * 担保交易状态 字符串 否.
     */
    private final String secureStatus;
    /**
     * 担保完成金额 字符串 否.
     */
    private final String completeAmount;
    /**
     * 退货订单号 字符串 否.
     */
    private final String refundOrderId;
}
