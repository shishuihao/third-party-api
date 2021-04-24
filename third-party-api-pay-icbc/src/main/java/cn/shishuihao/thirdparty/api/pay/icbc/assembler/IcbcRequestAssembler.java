package cn.shishuihao.thirdparty.api.pay.icbc.assembler;

import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import com.icbc.api.request.QrcodePayRequestV2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcRequestAssembler {
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
     * 实例.
     */
    public static final IcbcRequestAssembler INSTANCE
            = new IcbcRequestAssembler();

    /**
     * 装配 二维码被扫支付请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link QrcodePayRequestV2}
     */
    public QrcodePayRequestV2 assemble(
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
}
