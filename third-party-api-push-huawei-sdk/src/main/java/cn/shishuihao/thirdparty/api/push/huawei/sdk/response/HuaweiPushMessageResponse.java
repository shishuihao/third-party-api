package cn.shishuihao.thirdparty.api.push.huawei.sdk.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class HuaweiPushMessageResponse implements HuaweiPushResponse {
    /**
     * 错误码.
     */
    private String code;
    /**
     * 错误码描述.
     */
    private String msg;
    /**
     * 请求标识.
     */
    private String requestId;
}
