package cn.shishuihao.thirdparty.api.sms.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.sms.SmsApiResponse;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
public class SendSmsApiResponse
        extends BaseApiResponse
        implements SmsApiResponse {
}
