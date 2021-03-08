package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class BaseCcbHsbPayResponse {
    /**
     * 服务响应状态.
     * VarChar2	2
     * 必输
     * 00-成功
     * 01-失败
     */
    @JsonProperty("Svc_Rsp_St")
    private String serviceResponseStatus;
    /**
     * 服务响应码.
     * VarChar2	12
     * 非必输
     * 接收失败时返回
     */
    @JsonProperty("Svc_Rsp_Cd")
    private String serviceResponseCode;
    /**
     * 响应信息.
     * VarChar2	600
     * 非必输
     * 接收失败时返回
     */
    @JsonProperty("Rsp_Inf")
    private String responseInfo;
    /**
     * 发起方时间戳.
     * VarChar2	23
     * 必输
     * yyyymmddhhmmssfff 年月日, 时分秒，毫秒（直接返回接收到的时间）
     */
    @JsonProperty("Ittparty_Tms")
    private String ittPartyTms;
    /**
     * 签名信息.
     * VarChar2	1500
     * 必输
     * 将上述参数进行拼接并用私钥生成签名
     */
    @JsonProperty("Sign_Inf")
    private String signInfo;
}
