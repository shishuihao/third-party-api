package cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.android;

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
public class ClickAction {
    /**
     * 消息点击行为类型.
     * 取值如下：
     * 1：打开应用自定义页面
     * 2：点击后打开特定URL
     * 3：点击后打开应用
     */
    private final Integer type;
    /**
     * 自定义页面中intent的实现.
     * 请参见指定intent参数
     * 当type为1时，字段intent和action至少二选一。
     */
    private final String intent;
    /**
     * 设置打开特定URL.
     * 本字段填写需要打开的URL，URL使用的协议必须是HTTPS协议，
     * 取值样例：https://example.com/image.png。
     * 当type为2时必选。
     * 如果是游戏类应用，不支持设置特定URL。
     */
    private final String url;
    /**
     * 设置通过action打开应用自定义页面时.
     * 本字段填写要打开的页面activity对应的action。
     * 当type为1（打开自定义页面）时，字段intent和action至少二选一。
     */
    private final String action;
}
