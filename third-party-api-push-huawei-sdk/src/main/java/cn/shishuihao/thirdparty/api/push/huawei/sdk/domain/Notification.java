package cn.shishuihao.thirdparty.api.push.huawei.sdk.domain;

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
public class Notification {
    /**
     * 通知栏消息的标题.
     * 是否必选：是
     */
    private final String title;
    /**
     * 通知栏消息的内容.
     * 是否必选：是
     */
    private final String body;
    /**
     * 用户自定义的通知栏消息右侧大图标URL.
     * 如果不设置，则不展示通知栏右侧图标。
     * URL使用的协议必须是HTTPS协议。
     * 取值样例：https://example.com/image.png。
     * 是否必选：否
     */
    private final String image;
}
