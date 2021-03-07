package cn.shishuihao.thirdparty.api.sms.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.sms.SmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class SendBatchSmsApiRequest extends AbstractRequest<
        SendBatchSmsApi,
        SendBatchSmsApiRequest,
        SendBatchSmsApiResponse> implements SmsApiRequest<
        SendBatchSmsApi,
        SendBatchSmsApiRequest,
        SendBatchSmsApiResponse> {
    /**
     * template Id.
     */
    private final String templateId;
    /**
     * phone numbers.
     */
    private final List<SmsMessage> messages;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<SendBatchSmsApi> apiType() {
        return SendBatchSmsApi.class;
    }

    /**
     * get properties id.
     * immutable
     *
     * @return properties id
     */
    @Override
    public Class<SendBatchSmsApiResponse> responseType() {
        return SendBatchSmsApiResponse.class;
    }
}
