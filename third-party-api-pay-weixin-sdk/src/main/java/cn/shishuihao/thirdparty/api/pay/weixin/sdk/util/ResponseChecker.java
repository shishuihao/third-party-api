package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.AbstractWxPayXmlResponse;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class ResponseChecker {
    /**
     * SUCCESS.
     */
    public static final String SUCCESS = "SUCCESS";
    /**
     * FAIL.
     */
    public static final String FAIL = "FAIL";

    private ResponseChecker() {
    }

    /**
     * 判断一个请求返回的响应是否成功.
     *
     * @param response 响应对象
     * @return boolean
     */
    public static boolean success(final AbstractWxPayXmlResponse response) {
        return SUCCESS.equals(response.getReturnCode())
                && SUCCESS.equals(response.getResultCode());
    }

    /**
     * 获取错误码.
     *
     * @param response 响应对象
     * @return String
     */
    public static String getCode(final AbstractWxPayXmlResponse response) {
        // 接口通信情况
        if (FAIL.equals(response.getReturnCode())) {
            return response.getReturnCode();
        }
        // 错误代码 > 业务结果
        return Optional.ofNullable(response.getErrCode())
                .orElseGet(response::getResultCode);
    }

    /**
     * 获取错误信息.
     *
     * @param response 响应对象
     * @return String
     */
    public static String getMsg(final AbstractWxPayXmlResponse response) {
        // 接口通信情况
        if (FAIL.equals(response.getReturnCode())) {
            return response.getReturnMsg();
        }
        // 错误代码 > 业务结果
        return Optional.ofNullable(response.getErrCodeDes())
                .orElseGet(response::getResultMsg);
    }
}
