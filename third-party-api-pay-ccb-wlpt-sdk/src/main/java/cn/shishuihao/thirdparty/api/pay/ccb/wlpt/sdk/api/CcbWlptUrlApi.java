package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 文件传输.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Headers({
        "User-Agent: " + CcbWlptPayClient.USER_AGENT,
        "Content-Type: application/x-www-form-urlencoded;charset=UTF-8"
})
public interface CcbWlptUrlApi {
    /**
     * NWWL01 获取.
     *
     * @param customerId 网银客户号
     * @return 响应
     * <!DOCTYPE html>
     * success::MER01##MER01##
     */
    @RequestLine("POST /NCCB/MER01B2BMainPlat"
            + "?CCB_IBSVersion=V6"
            + "&PT_LANGUAGE=CN"
            + "&PT_STYLE=M"
            + "&resType=jsp"
            + "&colorCSS="
            + "&TXCODE=NWWL01"
            + "&USERID="
            + "&CUSTOMERID={customerId}")
    String getUrl(@Param("customerId") String customerId);
}
