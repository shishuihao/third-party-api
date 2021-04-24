package cn.shishuihao.thirdparty.api.pay.icbc.assembler;

import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import com.icbc.api.request.QrcodePayRequestV2;
import com.icbc.api.request.QrcodeQueryRequestV2;
import com.icbc.api.request.QrcodeRejectQueryRequestV3;
import com.icbc.api.request.QrcodeRejectRequestV2;
import com.icbc.api.request.QrcodeReverseRequestV2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayRequestAssembler {
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
    public static final IcbcPayRequestAssembler INSTANCE
            = new IcbcPayRequestAssembler();

    /**
     * 装配 二维码冲正请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link QrcodeReverseRequestV2}
     */
    public QrcodeReverseRequestV2 assemble(
            final CancelPayApiRequest request,
            final IcbcPayApiProperties properties) {
        final QrcodeReverseRequestV2 requestV2 = new QrcodeReverseRequestV2();
        final QrcodeReverseRequestV2.QrcodeReverseRequestV2Biz biz
                = new QrcodeReverseRequestV2.QrcodeReverseRequestV2Biz();
        requestV2.setServiceUrl(IcbcPayApiChannel.GATEWAY
                + "/qrcode/V2/reverse");
        biz.setMerId(properties.getMerId());
        biz.setOutTradeNo(request.getOutTradeNo());
        requestV2.setBizContent(biz);
        return requestV2;
    }

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
        final QrcodePayRequestV2 requestV2 = new QrcodePayRequestV2();
        final QrcodePayRequestV2.QrcodePayRequestV2Biz biz
                = new QrcodePayRequestV2.QrcodePayRequestV2Biz();
        requestV2.setServiceUrl(IcbcPayApiChannel.GATEWAY
                + "/qrcode/V2/pay");
        biz.setQrCode(request.getAuthCode());
        biz.setMerId(properties.getMerId());
        biz.setOutTradeNo(request.getOutTradeNo());
        biz.setOrderAmt(String.valueOf(request.getTotalAmount()));
        biz.setTradeDate(LocalDate.now().format(COMPACT_DATE_FORMATTER));
        biz.setTradeTime(LocalTime.now().format(COMPACT_TIME_FORMATTER));
        requestV2.setBizContent(biz);
        return requestV2;
    }

    /**
     * 装配 二维码查询请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link QrcodeQueryRequestV2}
     */
    public QrcodeQueryRequestV2 assemble(
            final QueryPayApiRequest request,
            final IcbcPayApiProperties properties) {
        final QrcodeQueryRequestV2 requestV2 = new QrcodeQueryRequestV2();
        final QrcodeQueryRequestV2.QrcodeQueryRequestV2Biz biz
                = new QrcodeQueryRequestV2.QrcodeQueryRequestV2Biz();
        requestV2.setServiceUrl(IcbcPayApiChannel.GATEWAY
                + "/qrcode/V2/query");
        biz.setMerId(properties.getMerId());
        biz.setOutTradeNo(request.getOutTradeNo());
        biz.setOrderId(request.getChannelTransactionId());
        requestV2.setBizContent(biz);
        return requestV2;
    }

    /**
     * 装配 二维码退款请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link QrcodeRejectRequestV2}
     */
    public QrcodeRejectRequestV2 assemble(
            final RefundPayApiRequest request,
            final IcbcPayApiProperties properties) {
        final QrcodeRejectRequestV2 requestV2 = new QrcodeRejectRequestV2();
        final QrcodeRejectRequestV2.QrcodeRejectRequestV2Biz biz
                = new QrcodeRejectRequestV2.QrcodeRejectRequestV2Biz();
        requestV2.setServiceUrl(IcbcPayApiChannel.GATEWAY
                + "/qrcode/V2/reject");
        biz.setMerId(properties.getMerId());
        biz.setOutTradeNo(request.getOutTradeNo());
        biz.setOrderId(request.getChannelTransactionId());
        biz.setRejectNo(request.getOutRefundNo());
        biz.setRejectAmt(String.valueOf(request.getRefundAmount()));
        requestV2.setBizContent(biz);
        return requestV2;
    }

    /**
     * 装配 二维码查询请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link QrcodeRejectQueryRequestV3}
     */
    public QrcodeRejectQueryRequestV3 assemble(
            final RefundQueryPayApiRequest request,
            final IcbcPayApiProperties properties) {
        final QrcodeRejectQueryRequestV3 requestV3
                = new QrcodeRejectQueryRequestV3();
        final QrcodeRejectQueryRequestV3
                .QrcodeRejectQueryRequestV3Biz biz
                = new QrcodeRejectQueryRequestV3
                .QrcodeRejectQueryRequestV3Biz();
        requestV3.setServiceUrl(IcbcPayApiChannel.GATEWAY
                + "/qrcode/reject/query/V3");
        biz.setMerId(properties.getMerId());
        biz.setOutTradeNo(request.getOutTradeNo());
        biz.setOrderId(request.getChannelTransactionId());
        biz.setRejectNo(request.getOutRefundNo());
        requestV3.setBizContent(biz);
        return requestV3;
    }
}
