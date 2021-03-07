package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public abstract class AbstractWxPayXmlResponse {
    /**
     * 返回状态码.
     * String(16)
     * SUCCESS
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
     */
    @XStreamAlias("return_code")
    private String returnCode;
    /**
     * 返回信息.
     * String(128)
     * OK
     * 当return_code为FAIL时返回信息为错误原因 ，例如 签名失败 参数格式校验错误
     */
    @XStreamAlias("return_msg")
    private String returnMsg;

    //region 当return_code为SUCCESS的时候，还会包括以下字段

    /**
     * 业务结果.
     * String(16)
     * SUCCESS SUCCESS/FAIL
     */
    @XStreamAlias("result_code")
    private String resultCode;
    /**
     * 错误代码.
     * String(32)
     * SYSTEMERROR
     * 详细参见错误列表
     */
    @XStreamAlias("err_code")
    private String errCode;
    /**
     * 错误描述.
     * String(128)
     * 系统错误
     * 结果信息描述
     */
    @XStreamAlias("err_code_des")
    private String errCodeDes;


    /**
     * 公众账号ID.
     * wx8888888888888888
     * 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    @XStreamAlias("appid")
    private String appId;
    /**
     * 商户号.
     * 1900000109
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;
    /**
     * 小程序的APPID.
     * wx8888888888888888
     * 微信支付分配的子商户号
     */
    @XStreamAlias("sub_appid")
    private String subAppId;
    /**
     * 子商户号.
     * 1900000109
     * 微信支付分配的子商户号
     */
    @XStreamAlias("sub_mch_id")
    private String subMchId;
    /**
     * 设备号.
     * device_info
     * 否
     * String(32)
     * 013467007045764
     * 微信支付分配的终端设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;
    /**
     * 随机字符串.
     * 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * 随机字符串，不长于32位。推荐随机数生成算法
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 签名.
     * HMAC-C380BEC2BFD727A4B6845133519F3AD6
     * 签名，详见签名生成算法
     */
    @XStreamAlias("sign")
    private String sign;
}
