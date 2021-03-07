package cn.shishuihao.thirdparty.api.sms.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.sms.SmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.domain.SmsSendStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class SendBatchSmsApiResponse
        extends BaseApiResponse
        implements SmsApiResponse {
    /**
     * sendStatuses.
     */
    private final SmsSendStatus[] sendStatuses;
}
