package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain.Good;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain.ReturnCommonParams;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain.SubOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 下单.
 * 本接口为商户的订单信息发向银商网络支付前置系统以获取支付要素
 * 商户需遵循商户订单号生成规范，
 * 即以银商分配的4位来源编号作为账单号的前4位，且在商户系统中此账单号保证唯一。
 * 总长度需大于6位，小于28位。银商的推荐规则为（无特殊情况下，建议遵守此规则）：
 * {来源编号(4位)}{时间(yyyyMMddmmHHssSSS)(17位)}{7位随机数}
 * 备注：
 * 在传分账标记的情况下，接口中goods和subOrders二者必传其一；
 * 若传goods则分账信息会按goods中每个商品的总额占支付总额减平台分账金额等比例生成；
 * 若传subOrders，则分账信息则严格按subOrders里的分账方案生成。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPayPlaceRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..64 否 商户自行生成.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 微信子商户appId 字符串 ⇐32 是.
     */
    @JsonProperty("subAppId")
    private final String subAppId;
    /**
     * 商品信息 数组→JSON 否.
     */
    @JsonProperty("goods")
    private final Good[] goods;
    /**
     * 商户附加 数据 字符串 ⇐255 否.
     */
    @JsonProperty("attachedData")
    private final String attachedData;
    /**
     * 订单过期时间 字符串 否.
     * 为空则使用系统默认过期时间（30分钟），格式 yyyy-MM-dd HH:mm:ss
     */
    @JsonProperty("expireTime")
    private final String expireTime;
    /**
     * 商品标记 字符串 ⇐32 否.
     * 用于优惠活动
     */
    @JsonProperty("goodsTag")
    private final String goodsTag;
    /**
     * 商品交易单号 字符串 否.
     * 跟goods字段二选一，商品信息通过goods.add接口提前上送
     */
    @JsonProperty("goodsTradeNo")
    private final String goodsTradeNo;
    /**
     * 账单描述 字符串 ⇐255 否.
     */
    @JsonProperty("orderDesc")
    private final String orderDesc;
    /**
     * 订单原始 金额 数字型 1..100000000 否.
     * 单位分，用于记录前端系 统打折前的金额
     */
    @JsonProperty("originalAmount")
    private final Integer originalAmount;
    /**
     * 商品ID 字符串 否.
     */
    @JsonProperty("productId")
    private final String productId;
    /**
     * 支付总金 额 数字型 1..100000000 否.
     * 单位分 若divisionFlag为 true，则：
     * totalAmount=subOrders字段中的所有totalAmount值之和+platformAmount值
     * =goods中的所有subOrderAmount值之和。
     */
    @JsonProperty("totalAmount")
    private final Integer totalAmount;
    /**
     * 分账标记 布尔型 否.
     * 若为true，则goods字段和subOrders字段不能同时为空；
     * 且secureTransaction字段上送false或不上送。
     */
    @JsonProperty("divisionFlag")
    private final String divisionFlag;
    /**
     * 平台商户 分账金额 数字型 1..100000000 否.
     * 若分账标记传，则分账金额必传
     */
    @JsonProperty("platformAmount")
    private final Integer platformAmount;
    /**
     * 子订单信息 JSON 否.
     * 在传分账标记的情况下，若传子商户号，子商户分账金额必传，
     * 即subOrders每个元素的mid和totalAmount非空且mid不超过20个。
     * （分账方案subOrders里子商户分账总额+platformAmount要与支付总额totalAmount相等）。
     * 详见接口下方备注部分.
     */
    @JsonProperty("subOrders")
    private final SubOrder[] subOrders;
    /**
     * 支付结果 通知地址 字符串 ⇐255 否.
     */
    @JsonProperty("notifyUrl")
    private final String notifyUrl;
    /**
     * 订单展示 页面 字符串 ⇐255 否.
     */
    @JsonProperty("showUrl")
    private final String showUrl;
    /**
     * 担保交易标识 字符串 否.
     * 取值：
     * true或false，默认false
     * 若上送为true，则交易的金额将会被暂缓结算。
     * 调用担保完成接口后，完成部分金额会在t+1日结算给商户，剩余部分金额退还用户。
     * 调用担保撤销接口，则全部资金退还给用户。
     * 30天后没有主动调用担保完成且没有主动调用担保撤销的交易 将会自动按撤销处理。
     */
    @JsonProperty("secureTransaction")
    private final String secureTransaction;
    /**
     * 交易类型 字符串 是微信必传:APP` .
     */
    @JsonProperty("tradeType")
    private final String tradeType;
    /**
     * 商户用户 号 字符串 ⇐32 否 全民付必传.
     */
    @JsonProperty("merchantUserId")
    private final String merchantUserId;
    /**
     * 手机号 字符串 ⇐11 否 全民付必传.
     */
    @JsonProperty("mobile")
    private final String mobile;
    /**
     * 是否需要 限制信用 卡支付 字符串 否 .
     * 取值：true或false，默认false .
     */
    @JsonProperty("limitCreditCard")
    private final String limitCreditCard;
    /**
     * 花呗分期数 数字型 否 取值：仅支持3、6、12.
     */
    @JsonProperty("installmentNumber")
    private final Integer installmentNumber;
    /**
     * 支付宝支 付方式 字符串 否 仅支持支付宝.
     * 一笔订单中仅允许商户一次上送一个值，可上送的取值范围 为：
     * balance（余额），
     * moneyFund（余额宝），
     * pcredit（花呗），
     * pcreditpayInstallment （花呗分期），
     * creditCard（信用 卡），
     * debitCardExpress（借 记卡）.
     */
    @JsonProperty("enablePayChnl")
    private final String enablePayChannel;
    /**
     * 返佣字段 JSON 255 否 目前支持支付宝渠道.
     */
    @JsonProperty("retCommParams")
    private final ReturnCommonParams retCommParams;
}
