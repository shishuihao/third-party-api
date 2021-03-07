package cn.shishuihao.thirdparty.api.push.huawei.sdk.domain;

import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.android.AndroidNotification;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@Builder
@Getter
public class AndroidConfig {
    /**
     * Android通知栏消息结构体.
     * 具体字段请参见AndroidNotification结构体的定义。
     */
    @JsonProperty("notification")
    private final AndroidNotification notification;
}
