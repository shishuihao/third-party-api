package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.DownloadBillPayApi;
import cn.shishuihao.thirdparty.api.pay.response.DownloadBillPayApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Jacksonized
@SuperBuilder
public class DownloadBillPayApiRequest extends AbstractRequest<
        DownloadBillPayApi,
        DownloadBillPayApiRequest,
        DownloadBillPayApiResponse> implements PayApiRequest<
        DownloadBillPayApi,
        DownloadBillPayApiRequest,
        DownloadBillPayApiResponse> {
    /**
     * bill date.
     */
    @NotBlank
    private final LocalDate billDate;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<DownloadBillPayApi> apiType() {
        return DownloadBillPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<DownloadBillPayApiResponse> responseType() {
        return DownloadBillPayApiResponse.class;
    }
}
