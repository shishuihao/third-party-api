package cn.shishuihao.thirdparty.api.pay.icbc.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayClient;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import com.icbc.api.IcbcClient;
import com.icbc.api.request.QrcodePayRequestV2;
import com.icbc.api.response.QrcodePayResponseV2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcCodePayApi implements CodePayApi {
    public static final DateTimeFormatter COMPACT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter COMPACT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");
    private final IcbcPayClient icbcPayClient;

    public IcbcCodePayApi(IcbcPayClient icbcPayClient) {
        this.icbcPayClient = icbcPayClient;
    }

    @Override
    public CodePayApiResponse execute(CodePayApiRequest request) {
        IcbcPayApiProperties properties = (IcbcPayApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        IcbcClient client = icbcPayClient.getClient(properties);
        try {
            QrcodePayRequestV2 qrcodePayRequestV2 = new QrcodePayRequestV2();
            QrcodePayRequestV2.QrcodePayRequestV2Biz biz = new QrcodePayRequestV2.QrcodePayRequestV2Biz();
            // 请求路径
            qrcodePayRequestV2.setServiceUrl("https://gw.open.icbc.com.cn/api/qrcode/V2/pay");
            biz.setQrCode(request.getAuthCode());
            biz.setMerId(properties.getMerId());
            biz.setOutTradeNo(request.getOutTradeNo());
            biz.setOrderAmt(String.valueOf(request.getTotalAmount()));
            biz.setTradeDate(LocalDate.now().format(COMPACT_DATE_FORMATTER));
            biz.setTradeTime(LocalTime.now().format(COMPACT_TIME_FORMATTER));
            qrcodePayRequestV2.setBizContent(biz);
            QrcodePayResponseV2 response = client.execute(qrcodePayRequestV2);
            return CodePayApiResponse.Builder.builder()
                    .success(response.isSuccess())
                    .code(String.valueOf(response.getReturnCode()))
                    .message(response.getReturnMsg())
                    .requestId(response.getMsgId())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
