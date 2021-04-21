package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W3000RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt6W0111RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W3000Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt6W0111Response;
import feign.Headers;
import feign.RequestLine;

/**
 * 文件传输.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Headers({
        "User-Agent: " + HttpClient.USER_AGENT,
        "Content-Type: application/x-www-form-urlencoded;charset=UTF-8"
})
public interface CcbWlptFileApi {
    /**
     * 6W0111 大文件下载交易.
     *
     * @param request 请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/MER01B2BMainPlat")
    CcbWlpt6W0111Response download(
            CcbWlptRequest<CcbWlpt6W0111RequestTxInfo> request);

    /**
     * 5W3000 文件上传.
     *
     * @param request 请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/MER01B2BMainPlat")
    CcbWlpt5W3000Response upload(
            CcbWlptRequest<CcbWlpt5W3000RequestTxInfo> request);
}
