package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.function.Function;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public abstract class AbstractChinaumsRequest {
    /**
     * 认证内容.
     */
    @JsonIgnore
    private final Function<String, String> authorization;
    /**
     * 消息ID， 原样返回 字符串 ⇐64 否.
     */
    @JsonProperty("msgId")
    private final String msgId;
    /**
     * 报文请求时间 字符串 是 格式yyyy-MM-dd HH:mm:ss.
     */
    @JsonProperty("requestTimestamp")
    private final String requestTimestamp;
    /**
     * 请求系统 预留字段 字符串 ⇐255 否.
     */
    @JsonProperty("srcReserve")
    private final String srcReserve;
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
}
