package cn.shishuihao.thirdparty.api.push.vivo.util;

import com.vivo.push.sdk.notofication.Result;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ResultChecker {
    private ResultChecker() {
    }

    /**
     * 判断结果是否成功
     *
     * @param result 结果
     * @return true：成功；false：失败
     */
    public static boolean success(Result result) {
        return result != null && result.getResult() == 0;
    }
}
