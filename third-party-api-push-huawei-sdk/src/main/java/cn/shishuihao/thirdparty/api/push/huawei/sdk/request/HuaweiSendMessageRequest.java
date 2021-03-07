package cn.shishuihao.thirdparty.api.push.huawei.sdk.request;

import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Message;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Review;
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
public class HuaweiSendMessageRequest {
    /**
     * 控制当前是否为测试消息.
     * 测试消息只做格式合法性校验，不会推送给用户设备.
     * 取值如下：
     * true：测试消息
     * false：正式消息
     * 默认值是false
     * 是否必选：否
     */
    @JsonProperty("validate_only")
    private final boolean validateOnly;
    /**
     * 推送消息结构体.
     * message结构体中必须要有有效消息负载以及有效发送目标，具体字段请参见Message的定义。
     * 是否必选：是
     */
    private final Message message;
    /**
     * 第三方审核机构对推送消息体内容的审核结果信息.
     * 具体结构请参见Review的定义。
     * 是否必选：否
     */
    private final Review review;
}
