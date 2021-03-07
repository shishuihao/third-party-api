package cn.shishuihao.thirdparty.api.push.huawei.sdk.util;

import cn.shishuihao.thirdparty.api.push.huawei.sdk.response.HuaweiPushMessageResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class ResponseChecker {
    private ResponseChecker() {
    }

    /**
     * 判断一个请求返回的响应是否成功.
     *
     * @param response 响应对象
     * @return true：成功；false：失败
     */
    public static boolean success(final HuaweiPushMessageResponse response) {
        return "80000000".equals(response.getCode());
    }
}
