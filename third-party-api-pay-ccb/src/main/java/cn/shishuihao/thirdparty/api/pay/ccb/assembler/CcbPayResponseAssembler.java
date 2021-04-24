package cn.shishuihao.thirdparty.api.pay.ccb.assembler;

import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay100Response;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay103Response;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbPayResponseAssembler {
    /**
     * 实例.
     */
    public static final CcbPayResponseAssembler INSTANCE
            = new CcbPayResponseAssembler();

    /**
     * 装配.
     *
     * @param response 客户被扫支付-PAY100响应
     * @return {@link CodePayApiResponse}
     */
    public CodePayApiResponse assemble(
            final CcbPay100Response response) {
        return CodePayApiResponse.builder()
                .success("Y".equalsIgnoreCase(response.getResult()))
                .code(response.getErrCode())
                .message(response.getErrMsg())
                .requestId(response.getTraceId())
                .build();
    }

    /**
     * 装配.
     *
     * @param response 支付宝/微信订单关闭-PAY103响应
     * @return {@link CancelPayApiResponse}
     */
    public CancelPayApiResponse assemble(
            final CcbPay103Response response) {
        return CancelPayApiResponse.builder()
                .success(response.isSuccess())
                .code(response.getErrCode())
                .message(response.getErrMsg())
                .requestId(response.getTraceId())
                .retry("Y".equals(response.getRecall()))
                .build();
    }
}
