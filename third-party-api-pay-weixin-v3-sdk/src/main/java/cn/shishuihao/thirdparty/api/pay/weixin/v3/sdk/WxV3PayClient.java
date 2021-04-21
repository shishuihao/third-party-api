package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.api.WxPayV3PayTransactionsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxV3PayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";

    /**
     * new WxV3PayClient.
     */
    public WxV3PayClient() {
        super(ENDPOINT);
    }

    /**
     * payTransactionsApi.
     *
     * @param properties properties
     * @return WxPayV3PayTransactionsApi
     */
    public WxPayV3PayTransactionsApi
    payTransactionsApi(final WxV3Properties properties) {
        return this.jsonApi(properties, WxPayV3PayTransactionsApi.class);
    }
}
