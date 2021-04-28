package cn.shishuihao.thirdparty.api.pay.chinaums.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api.ChinaumsAppPayApi;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api.ChinaumsAppletPayApi;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api.ChinaumsH5PayApi;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api.ChinaumsNetPayApi;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api.ChinaumsPosLinkTransactionApi;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api.ChinaumsPosLinkTransactionPreAuthorizationApi;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.codec.ChinaumsJacksonEncoder;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ChinaumsPayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://api-mop.chinaums.com";

    /**
     * new ChinaumsPayClient.
     */
    public ChinaumsPayClient() {
        this(ENDPOINT);
    }

    /**
     * new ChinaumsPayClient.
     *
     * @param pUrl url
     */
    public ChinaumsPayClient(final String pUrl) {
        super(pUrl);
        this.setJsonEncoder(ChinaumsJacksonEncoder.INSTANCE);
    }

    /**
     * netPayApi.
     *
     * @param properties properties
     * @return ChinaumsNetPayApi
     */
    public ChinaumsNetPayApi netPayApi(
            final ChinaumnProperties properties) {
        return this.jsonApi(properties, ChinaumsNetPayApi.class);
    }

    /**
     * appletPayApi.
     *
     * @param properties properties
     * @return ChinaumsAppletPayApi
     */
    public ChinaumsAppletPayApi appletPayApi(
            final ChinaumnProperties properties) {
        return this.jsonApi(properties, ChinaumsAppletPayApi.class);
    }

    /**
     * appPayApi.
     *
     * @param properties properties
     * @return ChinaumsAppPayApi
     */
    public ChinaumsAppPayApi appPayApi(
            final ChinaumnProperties properties) {
        return this.jsonApi(properties, ChinaumsAppPayApi.class);
    }

    /**
     * h5PayApi.
     *
     * @param properties properties
     * @return ChinaumsH5PayApi
     */
    public ChinaumsH5PayApi h5PayApi(
            final ChinaumnProperties properties) {
        return this.jsonApi(properties, ChinaumsH5PayApi.class);
    }

    /**
     * posLinkTransactionApi.
     *
     * @param properties properties
     * @return ChinaumsPosLinkTransactionApi
     */
    public ChinaumsPosLinkTransactionApi posLinkTransactionApi(
            final ChinaumnProperties properties) {
        return this.jsonApi(properties, ChinaumsPosLinkTransactionApi.class);
    }

    /**
     * posLinkTransactionPreAuthorizationApi.
     *
     * @param properties properties
     * @return ChinaumsPosLinkTransactionPreAuthorizationApi
     */
    public ChinaumsPosLinkTransactionPreAuthorizationApi
    posLinkTransactionPreAuthorizationApi(
            final ChinaumnProperties properties) {
        return this.jsonApi(properties,
                ChinaumsPosLinkTransactionPreAuthorizationApi.class);
    }
}
