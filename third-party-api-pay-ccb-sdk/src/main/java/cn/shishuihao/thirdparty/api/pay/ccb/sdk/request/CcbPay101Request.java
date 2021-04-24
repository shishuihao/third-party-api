package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 轮询订单结果-PAY101请求.
 * 客户被扫支付的场景中，客户付款码通常仅支持一定额度（比如 1000 元）以内免密，
 * 超过一定金额或达到某些条件，需客户主动输入支付密码验证来完成扣款流程，
 * 此时需商户调用此轮询接口获取订单最终付款结果。
 * 因此在消费接口 PAY100 返回“Q”-待轮询状态时，订单可能正在等待客户付款，
 * 或者消费接口 PAY100 未能明确订单状态，此时需商户调用此轮询接口不断查询订单结果直到超时
 * （时间间隔以 PAY100 返回为准，如未返回建议设置为 5 秒，总超时时间通常为 30s）。
 * 具体请参考 3.2.3.支付及轮询流程说明。
 * 请注意：该接口为被扫支付 PAY100 的配套接口，实质完成的操作有两步：
 * 1.查询客户在支付宝/微信是否扣款成功；
 * 2.如果客户扣款成功，则发起入商户账操作。
 * 如果商户只是单纯想查询订单的当前状态，建议调用“3.6 通用订单查询接口”来获取订单的当前状态。
 * 请求样例：（注意用 post 方式提交参数）
 * https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY
 * ?MERCHANTID=105421097080009
 * &POSID=902807340
 * &BRANCHID=360000000
 * &ccbParam=ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT
 * %2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6Pa7rQPRMJ6nmkqO7B
 * 支付及轮询流程说明
 * 请商户参考[2.3.交互流程]，按照如下流程说明完成客户被扫支付的完整交易流程。
 * 1、 扫描客户付款码后，商户通过 PAY100 提交支付交易。
 * 2、 根据 PAY100 返回结果状态含义：
 * a) Y-成功：交易成功
 * b) N-失败：交易失败，如有错误码，返显错误码和错误信息
 * c) U-不确定：交易不确定，
 * 请查询核实，等待 PAY100 返回的等待时间 WAITTIME 后(若未返回该字段，则建议设置为 5 秒），调用 PAY101 开始轮询
 * d) Q-待查询：交易处理中，等待 PAY100 返回的等待时间 WAITTIME 后，调用 PAY101开始轮询
 * e) 其他无法明确交易成功或失败的场景（如网络超时）：
 * 交易不确定，等待 PAY100返回的等待时间 WAITTIME 后(若未返回该字段，则建议设置为 5 秒），调用 PAY101开始轮询
 * 3、 根据 PAY101 返回结果，进行不同处理：
 * a) Y-成功：返显“交易成功”，交易结束。
 * b) N-失败：返显“交易失败”，如有错误码，返显错误码和错误信息，交易结束。
 * c) U-不确定：
 * 返显“交易不确定，请查询核实”，
 * 等待 PAY101 返回的等待时间 WAITTIME后(若未返回该字段，则建议设置为 5 秒），调用 PAY101 进入下一次轮询
 * d) Q-待查询：
 * 返显“交易处理中，请稍候”，
 * 等待 PAY101 返回的等待时间 WAITTIME后，调用 PAY101 进入下一次轮询。
 * e) 其他无法明确交易结果的情况：返显“交易处理中，请稍候”，
 * 等待 PAY101 返回的等待时间 WAITTIME 后(若未返回该字段，则建议设置为 5 秒），调用 PAY101 进入下一次轮询。
 * 4、 调用 PAY101 进行交易轮询，轮询次数 QRYTIME 请商户自行叠加（从 1 开始，每调用 1 次加 1，直到服务端返回 Y 或 N）。
 * 当轮询次数超限（当前为 6 次）建行会发起订单关闭交易（其中银联系二维码暂不支持订单关闭），如不叠加则不会自动发起关闭交易，如
 * 不按规范调用，极有可能产生重复付款等异常情况，因此请商户务必自行叠加轮询次数QRYTIME 字段。
 * 5、 当 PAY101 返回 N，且错误码为 9002 时，则代表建行此时未收到商户发起的 PAY100 扣款交易。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public class CcbPay101Request extends AbstractCcbRequest {
    /**
     * 订单号 30 Y.
     * 订单标识，确保在商户系统中唯一
     * 20180906101102
     */
    @JsonProperty("ORDERID")
    private final String orderId;
    /**
     * 查询次数 2 Y.
     * 上送查询的次数，从 1 开始（每次加 1）
     * 1
     */
    @JsonProperty("QRYTIME")
    private final Integer queryTimes;
    /**
     * 二维码类型 2 N.
     * 1：龙支付
     * 2：微信
     * 3：支付宝
     * 4：银联
     * 如未上送QRCODE则此参数为必输
     * 2
     */
    @JsonProperty("QRCODETYPE")
    private final String qrCodeType;
    /**
     * 码信息（一维码、二维码）128 Y.
     * 客户出示的付款码（现支 持龙支付、支付宝、微信、银联系的付款码）
     * 如无法正确获取二维码类型，可上送消费时扫描传输的码信息。
     * QRCODE与QRCODETYPE参数必选其中一个上送。
     * 134737690209713402
     */
    @JsonProperty("QRCODE")
    private final String qrCode;
    /**
     * 备注1 30 N.
     * 商户自定义，按需上送。在建行商户服务平台查询流水时可见，
     * 中文需使用UTF-8编码。
     * 需与消费接口上送值保持一致
     * remark1
     */
    @JsonProperty("REMARK1")
    private final String remark1;
    /**
     * 备注2 30 N.
     * 商户自定义，按需上送。在建行商户服务平台查询流水时可见，
     * 中文需使用UTF-8编码。
     * 需与消费接口上送值保持一致
     * remark2
     */
    @JsonProperty("REMARK2")
    private final String remark2;
    /**
     * 子商户公众账号ID 32 N.
     * 微信支付专有字段。如果子商户号没有绑定appid，只返回openid；
     * 如果子商户号绑定一个appid或多个 ppid，返回openid和sub_openid；
     * 子商户是否绑定appid，请联系开立商户的分行
     * wx3b8bb3fad101bb07
     */
    @JsonProperty("SUB_APPID")
    private final String subAppId;
    /**
     * 返回信息位图 20 N.
     * 共20位，位图，0 或空-不返回，1-返回。
     * 第 1 位：是否返回OPENID和SUB_OPENID
     * 第 2 位：是否返回优惠金额相关字段
     * 第 4 位：是否返回支付详细信息字段
     * 11000000000000000000
     */
    @JsonProperty("RETURN_FIELD")
    private final String returnField;
}
