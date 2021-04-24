package cn.shishuihao.thirdparty.api.pay.wechat.assembler;

import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayMicroPayResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.ResponseChecker;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatResponseAssembler {
    /**
     * 实例.
     */
    public static final WechatResponseAssembler INSTANCE
            = new WechatResponseAssembler();

    /**
     * 装配.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_10&index=1"}
     *
     * @param response 付款码支付响应
     * @return {@link CodePayApiResponse}
     */
    public CodePayApiResponse assemble(
            final WechatPayMicroPayResponse response) {
        return CodePayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .build();
    }

    /**
     * 装配.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_02"}
     *
     * @param response 查询订单响应
     * @return {@link QueryPayApiResponse}
     */
    public QueryPayApiResponse assemble(
            final WechatPayOrderQueryResponse response) {
        return QueryPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .build();
    }
}
