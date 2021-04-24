package cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk.api.WechatPayV3PayTransactionsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatV3PayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";

    /**
     * new WechatV3PayClient.
     */
    public WechatV3PayClient() {
        super(ENDPOINT);
    }

    /**
     * payTransactionsApi.
     *
     * @param properties properties
     * @return WechatPayV3PayTransactionsApi
     */
    public WechatPayV3PayTransactionsApi
    payTransactionsApi(final WechatV3Properties properties) {
        return this.jsonApi(properties, WechatPayV3PayTransactionsApi.class);
    }
}
