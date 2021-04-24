package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 客户被扫支付-PAY100请求.
 * 注意参考 [3.2.3.支付及轮询流程说明]中的流程，对于本消费接口返回的结果进行分别处理，
 * 如需轮询时必须调用[3.2.轮询订单结果-PAY101]接口轮询订单结果。
 * 该接口中的所有金额字段除了明确标明单位为分的字段外，其余金额的单位均为元。
 * 请求样例：（注意用 post 方式提交参数）
 * https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY
 * ?MERCHANTID=105421097080009
 * &POSID=902807340
 * &BRANCHID=360000000
 * &ccbParam=ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT
 * %2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6Pa7rQPRMJ6nmkqO7B
 * 1、 如果支付接口PAY100返回结果为Q-待轮询，则必须调用轮询接口 PAY101 进行轮询。
 * 如WAITTIME有时间返回，请等待相应时间后再发起轮询。
 * 2、 如网络超时等原因导致未能接收到返回结果，请调用PAY101进行轮询（时间间隔建议设置为5秒）。
 * 3、 其他无法明确该笔订单消费成功或失败的情况，请调用 PAY101进行轮询（时间间隔建议设置为5秒）。
 * 4、 注意同一订单号仅能发送一笔 PAY100，出现上述异常情况请调用PAY101进行轮询。
 * 切勿重复发送相同订单号的PAY100，否则可能出现订单重复错误或其他不可预期的问题。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public class CcbPay100Request extends AbstractCcbRequest {
    /**
     * 订单号 30 Y.
     * 订单标识，确保在商户系统中唯一
     * 20180906101102
     */
    @JsonProperty("ORDERID")
    private final String orderId;
    /**
     * 码信息（一维码、二维码）128 Y.
     * 客户出示的付款码（现支 持龙支付、支付宝、微信、银联系的付款码）
     * 134737690209713402
     */
    @JsonProperty("QRCODE")
    private final String qrCode;
    /**
     * 订单金额16（带2位小数） Y.
     * 该笔订单的资金总额
     * 0.01
     */
    @JsonProperty("AMOUNT")
    private final String amount;
    /**
     * 商品名称 128 N.
     * 当 RETURN_FIELD 字段第三位上送 1 时，该字段将展示在客户微信/支付宝账单的商品名称字段，
     * 按微信文档要求1个中文算3个字节，1个英文或数字算1个字节，请注意不要超长。
     * MobilePhone
     */
    @JsonProperty("PROINFO")
    private final String productInfo;
    /**
     * 备注1 30 N.
     * 商户自定义，按需上送。在建行商户服务平台查询流水时可见，
     * 中文需使用UTF-8编码。
     * 如需轮询，在轮询接口中需同步上送
     * remark1
     */
    @JsonProperty("REMARK1")
    private final String remark1;
    /**
     * 备注2 30 N.
     * 商户自定义，按需上送。在建行商户服务平台查询流水时可见，
     * 中文需使用UTF-8编码。
     * 如需轮询，在轮询接口中需同步上送
     * remark2
     */
    @JsonProperty("REMARK2")
    private final String remark2;
    /**
     * 分账信息一 200 N.
     */
    @JsonProperty("FZINFO1")
    private final String fzInfo1;
    /**
     * 分账信息二 200 N.
     */
    @JsonProperty("FZINFO2")
    private final String fzInfo2;
    /**
     * 子商户公众账号ID 32 N.
     * 微信支付专有字段。如果子商户号没有绑定appid，只返回openid；
     * wx3b8bb3fad101bb07
     */
    @JsonProperty("SUB_APPID")
    private final String subAppId;
    /**
     * 返回信息位图 20 N.
     * 共20位，位图，0 或空-不返回，1-返回。
     * 第 1 位：是否返回OPENID和SUB_OPENID
     * 第 2 位：是否返回优惠金额相关字段
     * 第 3 位：是否将“商品名称PROINFO”的值上送支付宝/微信，以便展示在客户的支付宝/微信账单中
     * 1：上送
     * 0或空：不上送
     * 第 4 位：是否返回支付详细信息字段
     * 第 5 位：是否返回微信优惠详情字段
     * 11000000000000000000
     */
    @JsonProperty("RETURN_FIELD")
    private final String returnField;
    /**
     * 实名支付 JSON N.
     * {
     * "USERNAME":"张三",
     * "IDNUMBER":"330000000000000000",
     * "IDTYPE":"IDENTITY_CARD"
     * }
     */
    @JsonProperty("USERPARAM")
    private final UserParam userParam;
    /**
     * 商品详情 JSON N.
     * 单品优惠功能字段
     * 暂不支持，预计9月上线。
     */
    @JsonProperty("detail")
    private final Detail detail;
    /**
     * 订单优惠标记 32 N.
     * 订单优惠标记，代金券或立减优惠功能的参数。
     * 若创建优惠活动时添加了标志，则商户下单时需要传入相同的标记，用户同时符合其他规则才能享受优惠。
     * 暂不支持，预计9月上线。
     * WXG
     */
    @JsonProperty("goods_tag")
    private final String goodsTag;

    /**
     * 实名支付 JSON N.
     * 实名支付功能，包含类型、证件号、姓名三个子域
     * 如果本字段出现，那么本字段包含的三个子域均需出现。
     */
    @ToString
    @SuperBuilder
    @Getter
    public static class UserParam {
        /**
         * 姓名     VARCHAR(16) 否 证件姓名.
         * 张三
         */
        @JsonProperty("USERNAME")
        private final String username;
        /**
         * 证件号码 VARCHAR(32) 否 证件号，如身份证号.
         * 330000000000000000
         */
        @JsonProperty("IDNUMBER")
        private final String idNumber;
        /**
         * 证件类型 VARCHAR(32) 否 证件类型.
         * 证件类型说明，目前只支持身份证：
         * 身份证 IDENTITY_CARD
         * 护照   PASSPORT
         * 军官证 OFFICER_CARD
         * 士兵证 SOLDIER_CARD
         * 户口本 HOKOU
         * IDENTITY_CARD
         */
        @JsonProperty("IDTYPE")
        private final String idType;
    }

    /**
     * 商品详情.
     */
    @ToString
    @SuperBuilder
    @Getter
    public static class Detail {
        /**
         * 订单原价 Int N.
         * 商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
         * 当订单原价与支付金额不相等，则不享受优惠。
         * 该字段主要用于防止同一张小票分多次支付，以享受多次优惠的情况，正常支付订单不必上传此参数。
         * 1
         */
        @JsonProperty("cost_price")
        private final Integer costPrice;
        /**
         * 商品小票ID String(32) N.
         * 商家小票ID
         * wx123
         */
        @JsonProperty("receipt_id")
        private final String receiptId;
        /**
         * 单品列表 String Y.
         * 单品信息，使用Json数组格式提交
         * 示例见下文
         */
        @JsonProperty("goods_detail")
        private final GoodsDetail goodsDetail;
    }

    /**
     * 单品优惠活动.
     */
    @ToString
    @SuperBuilder
    @Getter
    public static class GoodsDetail {
        /**
         * 商品编码 String(32) Y.
         * 由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。
         * id1
         */
        @JsonProperty("goods_id")
        private final String goodsId;
        /**
         * 微信侧商品编码 String(32) N.
         * 微信支付定义的统一商品编号（没有可不传）。
         * 1001
         */
        @JsonProperty("wxpay_goods_id")
        private final String wxPayGoodsId;
        /**
         * 商品名称 String(256) N.
         * 商品的实际名称
         * iPhone6s 16G
         */
        @JsonProperty("goods_name")
        private final String goodsName;
        /**
         * 商品数量 Int Y.
         * 用户购买的数量。
         * 1
         */
        @JsonProperty("quantity")
        private final Integer quantity;
        /**
         * 商品单价 Int Y.
         * 单位为分。如果商户有优惠，需传输商户优惠后的单价
         * 例如：用户对一笔100元的订单使用了商场发的优惠券 100-50，则活动商品的单价应为原单价-50。
         * 1
         */
        @JsonProperty("price")
        private final Integer price;
    }
}
