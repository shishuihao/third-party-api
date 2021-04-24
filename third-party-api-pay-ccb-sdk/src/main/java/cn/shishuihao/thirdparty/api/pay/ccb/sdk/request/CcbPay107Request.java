package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 扫付款码获取客户ID-PAY107请求.
 * 若商户在扫码收款时，需先查询付款客户的唯一标识，可调用本接口。
 * 目前支持查询微信客户 openid 与龙支付客户 id，暂不支持查询支付宝付款二维码和非龙支付的银联标准二维码。
 * 请求样例：（注意用 post 方式提交参数）
 * https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY
 * ?MERCHANTID=105421097080009
 * &POSID=902807340
 * &BRANCHID=360000000
 * &ccbParam=ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT
 * %2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6Pa7rQPRMJ3245frfyMQ
 *
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public class CcbPay107Request extends AbstractCcbRequest {
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
     * 码信息（一维码、二维码）128 Y.
     * 客户出示的付款码（现支 持龙支付、微信的付款码，暂不支持支付宝与银联）
     * 识别规则为：
     * 支付宝付款码 ：[20-33]开头的，长度范围是[16-23]的全数字字符串
     * 微信付款码：以 10、11、12、13、14、15 开头，18位纯数字
     * 龙支付付款码：62+1位随机数+0105开头的19位纯数字串为龙支付二维码；
     * 银联付款码： 62开头的19位纯数字串为银联标准码
     * 134737690209713402
     */
    @JsonProperty("QRCODE")
    private final String qrCode;
}
