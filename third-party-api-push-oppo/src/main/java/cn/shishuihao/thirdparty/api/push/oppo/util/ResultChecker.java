package cn.shishuihao.thirdparty.api.push.oppo.util;

import com.oppo.push.server.Result;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class ResultChecker {
    private ResultChecker() {
    }

    /**
     * 判断结果是否成功.
     *
     * @param result 结果
     * @return true：成功；false：失败
     */
    public static boolean success(final Result result) {
        return result != null
                && result.getReturnCode() != null
                && result.getReturnCode().getCode() == 0;
    }
}
