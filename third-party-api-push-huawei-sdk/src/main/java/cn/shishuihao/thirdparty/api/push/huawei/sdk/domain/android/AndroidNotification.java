package cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.android;

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
public class AndroidNotification {
    /**
     * Android通知栏消息标题.
     * 如果此处设置了title则会覆盖message.notification.title字段，
     * 且发送通知栏消息时，此处title和message.notification.title两者最少需要设置一个。
     */
    private final String title;
    /**
     * Android通知栏消息内容.
     * 如果此处设置了body则会覆盖message.notification.body字段，
     * 且发送通知栏消息时，此处body和message.notification.body两者最少需要设置一个。
     */
    private final String body;
    /**
     * 消息点击行为.
     * 具体字段请参见ClickAction结构体的定义。
     * 如果是Android通知栏消息时，则该参数必选。
     */
    @JsonProperty("click_action")
    private final ClickAction clickAction;
}
