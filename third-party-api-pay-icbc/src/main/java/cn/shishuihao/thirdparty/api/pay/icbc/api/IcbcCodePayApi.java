package cn.shishuihao.thirdparty.api.pay.icbc.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayClient;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import com.icbc.api.request.QrcodePayRequestV2;
import com.icbc.api.response.QrcodePayResponseV2;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class IcbcCodePayApi implements CodePayApi {
    /**
     * DATE_FORMATTER.
     */
    public static final DateTimeFormatter COMPACT_DATE_FORMATTER
            = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * TIME_FORMATTER.
     */
    public static final DateTimeFormatter COMPACT_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("HHmmss");
    /**
     * IcbcPayClient.
     */
    private final IcbcPayClient icbcPayClient;

    /**
     * execute CodePayApiRequest by icbc.
     *
     * @param request request
     * @return CodePayApiResponse
     */
    @Override
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        IcbcPayApiProperties properties = (IcbcPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            QrcodePayResponseV2 response = icbcPayClient
                    .getClient(properties)
                    .execute(buildRequest(request, properties));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private QrcodePayRequestV2 buildRequest(
            final CodePayApiRequest request,
            final IcbcPayApiProperties properties) {
        QrcodePayRequestV2 qrcodePayRequestV2 = new QrcodePayRequestV2();
        QrcodePayRequestV2.QrcodePayRequestV2Biz biz
                = new QrcodePayRequestV2.QrcodePayRequestV2Biz();
        qrcodePayRequestV2.setServiceUrl(IcbcPayApiChannel.GATEWAY
                + "/api/qrcode/V2/pay");
        biz.setQrCode(request.getAuthCode());
        biz.setMerId(properties.getMerId());
        biz.setOutTradeNo(request.getOutTradeNo());
        biz.setOrderAmt(String.valueOf(request.getTotalAmount()));
        biz.setTradeDate(LocalDate.now().format(COMPACT_DATE_FORMATTER));
        biz.setTradeTime(LocalTime.now().format(COMPACT_TIME_FORMATTER));
        qrcodePayRequestV2.setBizContent(biz);
        return qrcodePayRequestV2;
    }

    private CodePayApiResponse buildResponse(
            final QrcodePayResponseV2 response) {
        return CodePayApiResponse.builder()
                .success(response.isSuccess())
                .code(String.valueOf(response.getReturnCode()))
                .message(response.getReturnMsg())
                .requestId(response.getMsgId())
                .build();
    }
}
