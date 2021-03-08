package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.format.DateTimeFormatter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder
public abstract class AbstractRequest {
    /**
     * TIMESTAMP_FORMATTER.
     */
    public static final DateTimeFormatter TIMESTAMP_FORMATTER
            = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    /**
     * 发起渠道编号.
     * VarChar2 5
     * 必输
     * 默认送25个0
     **/
    @JsonProperty("Ittparty_Stm_Id")
    private final String ittPartyStmId;
    /**
     * 支付渠道代码.
     * VarChar2 25
     * 必输
     **/
    @JsonProperty("Py_Chnl_Cd")
    private final String payChannelCode;
    /**
     * 发起方时间戳.
     * VarChar2 23
     * 必输
     **/
    @JsonProperty("Ittparty_Tms")
    private final String ittPartyTimestamp;
    /**
     * 发起方流水号.
     * VarChar2 32
     * 必输
     **/
    @JsonProperty("Ittparty_Jrnl_No")
    private final String ittPartyJrnlNo;
    /**
     * 市场编号.
     * VarChar2 30
     * 必输
     **/
    @JsonProperty("Mkt_Id")
    private final String marketId;
    /**
     * 版本号.
     * NUMBER 9
     * 必输
     **/
    @JsonProperty("Vno")
    private final String versionNo;
    /**
     * 签名信息.
     * VarChar2 1500
     * 必输
     **/
    @JsonProperty(value = "Sign_Inf")
    private String signInfo;
}
