package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.assembler;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.FileType;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.FlowStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.OrderBy;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.QueryOrderStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1002RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1003RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1004RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;

import java.util.Optional;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlptPayRequestAssembler {
    /**
     * 实例.
     */
    public static final CcbWlptPayRequestAssembler INSTANCE
            = new CcbWlptPayRequestAssembler();

    /**
     * 装配 （5W1002）商户支付流水查询请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link CcbWlptRequest<CcbWlpt5W1002RequestTxInfo>}
     */
    public CcbWlptRequest<CcbWlpt5W1002RequestTxInfo> assemble(
            final QueryPayApiRequest request,
            final CcbWlptPayApiProperties properties) {
        return CcbWlptRequest.<CcbWlpt5W1002RequestTxInfo>builder()
                .requestSn(String.valueOf(System.nanoTime()))
                .customerId(properties.getCustomerId())
                .userId(properties.getUserId())
                .password(properties.getPassword())
                .txCode("5W1002")
                .language(Optional.ofNullable(properties.getLanguage())
                        .orElse("CN"))
                .txInfo(CcbWlpt5W1002RequestTxInfo.builder()
                        .kind(FlowStatus.SETTLED.ordinal())
                        .orderId(request.getOutTradeNo())
                        .fileType(FileType.NONE)
                        .orderBy(OrderBy.ORDER)
                        .page(1)
                        .posCode(null)
                        .status(QueryOrderStatus.ALL.ordinal())
                        .merchantNo(null)
                        .build())
                .signInfo(null)
                .signCert(null)
                .build();
    }

    /**
     * 装配 （5W1003）商户退款流水查询请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link CcbWlptRequest<CcbWlpt5W1003RequestTxInfo>}
     */
    public CcbWlptRequest<CcbWlpt5W1003RequestTxInfo> assemble(
            final RefundQueryPayApiRequest request,
            final CcbWlptPayApiProperties properties) {
        return CcbWlptRequest.<CcbWlpt5W1003RequestTxInfo>builder()
                .requestSn(String.valueOf(System.nanoTime()))
                .customerId(properties.getCustomerId())
                .userId(properties.getUserId())
                .password(properties.getPassword())
                .txCode("5W1003")
                .language(Optional.ofNullable(properties.getLanguage())
                        .orElse("CN"))
                .txInfo(CcbWlpt5W1003RequestTxInfo.builder()
                        .kind(FlowStatus.SETTLED.ordinal())
                        .orderId(request.getOutTradeNo())
                        .orderBy(OrderBy.ORDER)
                        .page(1)
                        .posCode(null)
                        .status(QueryOrderStatus.ALL.ordinal())
                        .merchantNo(null)
                        .build())
                .signInfo(null)
                .signCert(null)
                .build();
    }

    /**
     * 装配 （5W1004）商户单笔退款交易请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link CcbWlptRequest<CcbWlpt5W1004RequestTxInfo>}
     */
    public CcbWlptRequest<CcbWlpt5W1004RequestTxInfo> assemble(
            final RefundPayApiRequest request,
            final CcbWlptPayApiProperties properties) {
        return CcbWlptRequest.<CcbWlpt5W1004RequestTxInfo>builder()
                .requestSn(String.valueOf(System.nanoTime()))
                .customerId(properties.getCustomerId())
                .userId(properties.getUserId())
                .password(properties.getPassword())
                .txCode("5W1004")
                .language(Optional.ofNullable(properties.getLanguage())
                        .orElse("CN"))
                .txInfo(CcbWlpt5W1004RequestTxInfo.builder()
                        .orderId(request.getOutTradeNo())
                        .refundCode(request.getOutRefundNo())
                        .money(AmountUtils
                                .toYuanString(request.getRefundAmount()))
                        .build())
                .signInfo(null)
                .signCert(null)
                .build();
    }
}
