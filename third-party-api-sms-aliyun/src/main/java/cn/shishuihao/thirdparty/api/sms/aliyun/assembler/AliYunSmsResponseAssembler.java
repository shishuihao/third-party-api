package cn.shishuihao.thirdparty.api.sms.aliyun.assembler;

import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponseBody;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsResponseAssembler {
    /**
     * 实例.
     */
    public static final AliYunSmsResponseAssembler INSTANCE
            = new AliYunSmsResponseAssembler();

    /**
     * 装配.
     *
     * @param responseBody 响应
     * @return {@link SendSmsApiResponse}
     */
    public SendSmsApiResponse assemble(
            final SendSmsResponseBody responseBody) {
        return SendSmsApiResponse.builder()
                .requestId(responseBody.getRequestId())
                .success("OK".equals(responseBody.getCode()))
                .code(responseBody.getCode())
                .message(responseBody.getMessage())
                .build();
    }

    /**
     * 装配.
     *
     * @param responseBody 响应
     * @return {@link SendBatchSmsApiResponse}
     */
    public SendBatchSmsApiResponse assemble(
            final SendBatchSmsResponseBody responseBody) {
        return SendBatchSmsApiResponse.builder()
                .requestId(responseBody.getRequestId())
                .success("OK".equals(responseBody.getCode()))
                .code(responseBody.getCode())
                .message(responseBody.getMessage())
                .build();
    }
}
