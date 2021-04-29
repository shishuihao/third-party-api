package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public abstract class AbstractChinaumsResponse {
    /**
     * 平台错误码 字符串 是.
     */
    @JsonProperty("errCode")
    private final String errCode;
    /**
     * 平台错误信息 字符串 否.
     */
    @JsonProperty("errMsg")
    private final String errMsg;
    /**
     * 消息ID， 原样返回 字符串 ⇐64 否.
     */
    @JsonProperty("msgId")
    private final String msgId;
    /**
     * 请求系统 预留字段 字符串 ⇐255 否.
     */
    @JsonProperty("srcReserve")
    private final String srcReserve;
    /**
     * 报文应答时间 字符串 是 格式yyyy-MM-dd HH:mm:ss.
     */
    @JsonProperty("responseTimestamp")
    private final String responseTimestamp;
    /**
     * 商户号 字符串 8..32 是.
     */
    @JsonProperty("mid")
    private final String mid;
    /**
     * 终端号 字符串 2..32 是.
     */
    @JsonProperty("tid")
    private final String tid;
    /**
     * 机构商户号 字符串 8..32 是.
     */
    @JsonProperty("instMid")
    private final String instMid;
    /**
     * 链接系统 字符串 否.
     */
    @JsonProperty("connectSys")
    private final String connectSys;
}
