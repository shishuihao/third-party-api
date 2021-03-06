package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.AbstractWxPayXmlResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ResponseChecker {
    private ResponseChecker() {
    }

    /**
     * 判断一个请求返回的响应是否成功
     *
     * @param response 响应对象
     * @return true：成功；false：失败
     */
    public static boolean success(AbstractWxPayXmlResponse response) {
        return "SUCCESS".equals(response.getReturnCode());
    }
}
