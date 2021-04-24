package cn.shishuihao.thirdparty.api.pay.wechat.sdk.notice;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.annotation.WechatParameter;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.domain.SignType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 支付结果通用通知.
 * 应用场景
 * 支付完成后，微信会把相关支付结果及用户信息通过数据流的形式发送给商户，商户需要接收处理，并按文档规范返回应答。
 * 注意：
 * 1、同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知。
 * 2、后台通知交互时，如果微信收到商户的应答不符合规范或超时，微信会判定本次通知失败，重新发送通知，直到成功为止
 * （在通知一直不成功的情况下，微信总共会发起多次通知，
 * 通知频率为15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h - 总计 24h4m），
 * 但微信不保证通知最终一定能成功。
 * 3、在订单状态不明或者没有收到微信支付结果通知的情况下，建议商户主动调用微信支付【查询订单API】确认订单状态。
 * 特别提醒：
 * 1、商户系统对于支付结果通知的内容一定要做签名验证,并校验返回的订单金额是否与商户侧的订单金额一致，防止数据泄漏导致出现“假通知”，造成资金损失。
 * 2、当收到通知进行处理时，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。
 * 在对业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。
 * 3、技术人员可登进微信商户后台扫描加入接口报警群，获取接口告警信息。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@XStreamAlias("xml")
public class WechatPayResultNoticeRequest {
    // region 返回信息.
    /**
     * 返回状态码.
     */
    @WechatParameter(
            name = "返回状态码",
            required = true, type = "String(16)",
            example = "SUCCESS",
            desc = "SUCCESS/FAIL\n此字段是通信标识，表示接口层的请求结果，并非退款状态。")
    @XStreamAlias("return_code")
    private String returnCode;
    /**
     * 返回信息.
     */
    @WechatParameter(
            name = "返回信息",
            required = false, type = "String(128)",
            example = "签名失败",
            desc = "返回信息，如非空，为错误原因\n签名失败\n参数格式校验错误")
    @XStreamAlias("return_msg")
    private String returnMsg;
    // endregion
    // region 当return_code为SUCCESS的时候，还会包括以下字段
    /**
     * 公众账号ID|应用ID|小程序ID.
     */
    @WechatParameter(
            name = "公众账号ID|应用ID|小程序ID",
            required = true, type = "String(32)",
            example = "wx8888888888888888",
            desc = "公众账号ID|应用ID|小程序ID")
    @XStreamAlias("appid")
    private String appId;
    /**
     * 商户号.
     * 1900000109
     * 微信支付分配的商户号
     */
    @WechatParameter(
            name = "商户号",
            required = true, type = "String(32)",
            example = "1900000109",
            desc = "商户号")
    @XStreamAlias("mch_id")
    private String mchId;
    /**
     * 子商户公众账号ID|子商户应用ID|子商户小程序ID.
     */
    @WechatParameter(
            name = "子商户公众账号ID|子商户应用ID|子商户小程序ID",
            required = true, type = "String(32)",
            example = "wx8888888888888888",
            desc = "子商户公众账号ID|子商户应用ID|子商户小程序ID")
    @XStreamAlias("sub_appid")
    private String subAppId;
    /**
     * 子商户号.
     */
    @WechatParameter(
            name = "子商户号",
            required = true, type = "String(32)",
            example = "1900000109",
            desc = "子商户号")
    @XStreamAlias("sub_mch_id")
    private String subMchId;
    /**
     * 设备号.
     */
    @WechatParameter(
            name = "设备号",
            required = false, type = "String(32)",
            example = "013467007045764",
            desc = "微信支付分配的终端设备号")
    @XStreamAlias("device_info")
    private String deviceInfo;
    /**
     * 随机字符串.
     */
    @WechatParameter(
            name = "随机字符串",
            required = true, type = "String(32)",
            example = "5K8264ILTKCH16CQ2502SI8ZNMTM67VS",
            desc = "随机字符串，不长于32位")
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 签名.
     */
    @WechatParameter(
            name = "签名",
            required = true, type = "String(32)",
            example = "C380BEC2BFD727A4B6845133519F3AD6",
            desc = "签名，详见签名算法")
    @XStreamAlias("sign")
    private String sign;
    /**
     * 签名类型.
     */
    @WechatParameter(
            name = "签名类型",
            required = false, type = "String(32)",
            example = "HMAC-SHA256",
            desc = "签名类型，目前支持HMAC-SHA256和MD5，默认为MD5")
    @XStreamConverter(EnumToStringConverter.class)
    @XStreamAlias("sign_type")
    private SignType signType;
    /**
     * 业务结果.
     */
    @WechatParameter(
            name = "业务结果",
            required = true, type = "String(16)",
            example = "SUCCESS",
            desc = "SUCCESS/FAIL")
    @XStreamAlias("result_code")
    private String resultCode;
    /**
     * 错误代码.
     */
    @WechatParameter(
            name = "错误代码",
            required = true, type = "String(32)",
            example = "SYSTEMERROR",
            desc = "详细参见错误列表")
    @XStreamAlias("err_code")
    private String errCode;
    /**
     * 错误描述.
     */
    @WechatParameter(
            name = "错误描述",
            required = true, type = "String(128)",
            example = "系统错误",
            desc = "结果信息描述")
    @XStreamAlias("err_code_des")
    private String errCodeDes;

    /**
     * 用户标识.
     */
    @WechatParameter(
            name = "用户标识",
            required = true, type = "String(128)",
            example = "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o",
            desc = "用户在商户appid下的唯一标识")
    @XStreamAlias("openid")
    private String openid;
    /**
     * 是否关注公众账号.
     */
    @WechatParameter(
            name = "是否关注公众账号",
            required = true, type = "String(1)",
            example = "Y",
            desc = "用户是否关注公众账号，Y-关注，N-未关注（机构商户不返回）")
    @XStreamAlias("is_subscribe")
    private String isSubscribe;
    /**
     * 用户子标识.
     */
    @WechatParameter(
            name = "用户子标识",
            required = false, type = "String(128)",
            example = "wxd930ea5d5a258f4f",
            desc = "子商户appid下用户唯一标识，如需返回则请求时需要传sub_appid")
    @XStreamAlias("sub_openid")
    private String subOpenid;
    /**
     * 是否关注子公众账号.
     */
    @WechatParameter(
            name = "是否关注子公众账号",
            required = false, type = "String(1)",
            example = "Y",
            desc = "用户是否关注子公众账号，Y-关注，N-未关注（机构商户不返回）")
    @XStreamAlias("sub_is_subscribe")
    private String subIsSubscribe;
    /**
     * 交易类型.
     */
    @WechatParameter(
            name = "交易类型",
            required = true, type = "String(16)",
            example = "JSAPI",
            desc = "调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定")
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 付款银行.
     */
    @WechatParameter(
            name = "付款银行",
            required = true, type = "String(16)",
            example = "CMC",
            desc = "银行类型，采用字符串类型的银行标识")
    @XStreamAlias("bank_type")
    private String bankType;
    /**
     * 总金额.
     */
    @WechatParameter(
            name = "总金额",
            required = true, type = "Int",
            example = "888",
            desc = "订单总金额，单位为分，只能为整数，详见支付金额")
    @XStreamAlias("total_fee")
    private Integer totalFee;
    /**
     * 货币类型.
     */
    @WechatParameter(
            name = "货币类型",
            required = false, type = "String(16)",
            example = "CNY",
            desc = "符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("fee_type")
    private String feeType;
    /**
     * 现金支付金额.
     */
    @WechatParameter(
            name = "现金支付金额",
            required = true, type = "Int",
            example = "100",
            desc = "现金支付金额订单现金支付金额，详见支付金额")
    @XStreamAlias("cash_fee")
    private Integer cashFee;
    /**
     * 现金支付货币类型.
     */
    @WechatParameter(
            name = "现金支付货币类型",
            required = false, type = "String(16) ",
            example = "CNY",
            desc = "货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;
    /**
     * 应结订单金额.
     */
    @WechatParameter(
            name = "应结订单金额",
            required = false, type = "Int",
            example = "100",
            desc = "当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。")
    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;
    /**
     * 代金券金额.
     */
    @WechatParameter(
            name = "代金券金额",
            required = false, type = "Int",
            example = "100",
            desc = "“代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额")
    @XStreamAlias("coupon_fee")
    private Integer couponFee;
    /**
     * 代金券使用数量.
     */
    @WechatParameter(
            name = "代金券使用数量",
            required = false, type = "Int",
            example = "1",
            desc = "代金券或立减优惠使用数量")
    @XStreamAlias("coupon_count")
    private Integer couponCount;
    /**
     * 代金券类型.
     */
    @WechatParameter(
            name = "代金券类型",
            required = false, type = "Int",
            example = "CASH",
            desc = "CASH--充值代金券\n"
                    + "NO_CASH---非充值代金券\n"
                    + "并且订单使用了免充值券后有返回（取值：CASH、NO_CASH）。"
                    + "$n为下标,从0开始编号，举例：coupon_type_$0\n"
                    + "注意：只有下单时订单使用了优惠，回调通知才会返回券信息。\n"
                    + "下列情况可能导致订单不可以享受优惠：可能情况。")
    @XStreamAlias("coupon_type_$n")
    private List<String> couponTypes;
    /**
     * 代金券ID.
     */
    @WechatParameter(
            name = "代金券ID",
            required = false, type = "String(20)",
            example = "10000",
            desc = "代金券ID,$n为下标，从0开始编号\n"
                    + "注意：只有下单时订单使用了优惠，回调通知才会返回券信息。\n"
                    + "下列情况可能导致订单不可以享受优惠：可能情况。")
    @XStreamAlias("coupon_id_$n")
    private List<String> couponIds;
    /**
     * 单个代金券支付金额.
     */
    @WechatParameter(
            name = "单个代金券支付金额",
            required = false, type = "Int",
            example = "100",
            desc = "单个代金券支付金额,$n为下标，从0开始编号")
    @XStreamAlias("coupon_fee_$n")
    private List<Integer> couponFees;
    /**
     * 微信支付订单号.
     */
    @WechatParameter(
            name = "微信支付订单号",
            required = true,
            type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "微信支付订单号")
    @XStreamAlias("transaction_id")
    private String transactionId;
    /**
     * 商户订单号.
     */
    @WechatParameter(
            name = "商户订单号",
            required = true, type = "String(32)",
            example = "1212321211201407033568112322",
            desc = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 商家数据包.
     */
    @WechatParameter(
            name = "商家数据包",
            required = false, type = "String(128)",
            example = "123456",
            desc = "商家数据包，原样返回")
    @XStreamAlias("attach")
    private String attach;
    /**
     * 支付完成时间.
     */
    @WechatParameter(
            name = "支付完成时间",
            required = true, type = "String(14)",
            example = "20141030133525",
            desc = "订单支付时间，格式为yyyyMMddHHmmss，"
                    + "如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则")
    @XStreamAlias("time_end")
    private String timeEnd;
}
