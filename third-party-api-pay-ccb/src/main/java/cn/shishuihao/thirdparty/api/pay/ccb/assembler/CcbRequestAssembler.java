package cn.shishuihao.thirdparty.api.pay.ccb.assembler;

import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain.QrCodeType;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay100Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay103Request;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbRequestAssembler {
    /**
     * 实例.
     */
    public static final CcbRequestAssembler INSTANCE
            = new CcbRequestAssembler();

    /**
     * 装配 客户被扫支付-PAY100请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link CcbPay100Request}
     */
    public CcbPay100Request assemble(
            final CodePayApiRequest request,
            final CcbPayApiProperties properties) {
        return CcbPay100Request.builder()
                .merchantId(properties.getMerchantId())
                .posId(properties.getPosId())
                .branchId(properties.getBranchId())
                .groupMch(properties.getGroupMch())
                .txCode("PAY100")
                .merchantFlag(properties.getMerchantFlag())
                .termNo1(properties.getTermNo1())
                .termNo2(properties.getTermNo2())
                .orderId(request.getOutTradeNo())
                .qrCode(request.getAuthCode())
                .amount(AmountUtils.toYuanString(request.getTotalAmount()))
                .productInfo(properties.getProductInfo())
                .fzInfo1(properties.getFzInfo1())
                .fzInfo2(properties.getFzInfo2())
                .returnField(properties.getReturnField())
                .queryString(r -> r.queryString(properties.getPublicKey()))
                .build();
    }

    /**
     * 装配 支付宝/微信订单关闭-PAY103请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link CcbPay103Request}
     */
    public CcbPay103Request assemble(
            final CancelPayApiRequest request,
            final CcbPayApiProperties properties) {
        return CcbPay103Request.builder()
                .merchantId(properties.getMerchantId())
                .posId(properties.getPosId())
                .branchId(properties.getBranchId())
                .groupMch(properties.getGroupMch())
                .txCode("PAY103")
                .merchantFlag(properties.getMerchantFlag())
                .termNo1(properties.getTermNo1())
                .termNo2(properties.getTermNo2())
                .orderId(request.getOutTradeNo())
                .qrCodeType(String.valueOf(QrCodeType
                        .codeType(request.getAuthCode())
                        .ordinal()))
                .queryString(r -> r.queryString(properties.getPublicKey()))
                .build();
    }
}
