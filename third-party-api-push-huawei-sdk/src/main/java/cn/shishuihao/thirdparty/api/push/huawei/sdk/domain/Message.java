package cn.shishuihao.thirdparty.api.push.huawei.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@Builder
@Getter
public class Message {
    /**
     * 通知栏消息内容.
     * 具体字段请参见Notification的定义。
     * 是否必选：否
     */
    private final Notification notification;
    /**
     * Android消息推送控制参数.
     * 具体字段请参见AndroidConfig的定义。
     * 如果是Android通知栏消息，本字段必填。
     * 是否必选：否
     */
    @JsonProperty("android")
    private final AndroidConfig androidConfig;
    /**
     * 按照Token向目标用户推消息.
     * token/topic/condition三者只能且必须设置一个。
     * 样例：["pushtoken1","pushtoken2"]
     * 是否必选：否
     */
    @JsonProperty("token")
    private final List<String> token;
}
