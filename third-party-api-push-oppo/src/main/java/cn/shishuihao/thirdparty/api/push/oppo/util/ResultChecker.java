package cn.shishuihao.thirdparty.api.push.oppo.util;

import com.oppo.push.server.Result;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ResultChecker {
    private ResultChecker() {
    }

    /**
     * 判断一个请求返回的响应是否成功
     *
     * @param result 响应对象
     * @return true：成功；false：失败
     */
    public static boolean success(Result result) {
        return result != null && result.getReturnCode() != null && result.getReturnCode().getCode() == 0;
    }
}
