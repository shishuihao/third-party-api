package cn.shishuihao.thirdparty.api.sms.tencent.assembler;

import cn.shishuihao.thirdparty.api.sms.domain.SmsSendStatus;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20190711.models.SendStatus;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsResponseAssembler {
    /**
     * 实例.
     */
    public static final TencentSmsResponseAssembler INSTANCE
            = new TencentSmsResponseAssembler();

    /**
     * 装配.
     *
     * @param response 响应
     * @return {@link SendBatchSmsApiResponse}
     */
    public SendBatchSmsApiResponse assemble(
            final SendSmsResponse response) {
        return SendBatchSmsApiResponse.builder()
                .requestId(response.getRequestId())
                .success(Arrays.stream(response.getSendStatusSet())
                        .allMatch(it -> "Ok".equals(it.getCode())))
                .code(Arrays.stream(response.getSendStatusSet())
                        .map(SendStatus::getCode)
                        .collect(Collectors.joining()))
                .message(Arrays.stream(response.getSendStatusSet())
                        .map(SendStatus::getMessage)
                        .collect(Collectors.joining()))
                .sendStatuses(Arrays.stream(response.getSendStatusSet())
                        .map(it -> new SmsSendStatus(
                                it.getCode(),
                                it.getMessage()))
                        .toArray(SmsSendStatus[]::new))
                .build();
    }

    /**
     * 装配.
     *
     * @param response 响应
     * @return {@link SendSmsApiResponse}
     */
    public SendSmsApiResponse assemble(
            final SendBatchSmsApiResponse response) {
        return SendSmsApiResponse.builder()
                .requestId(response.getRequestId())
                .success(response.isSuccess())
                .code(response.getSendStatuses()[0].getCode())
                .message(response.getSendStatuses()[0].getMessage())
                .build();
    }
}
