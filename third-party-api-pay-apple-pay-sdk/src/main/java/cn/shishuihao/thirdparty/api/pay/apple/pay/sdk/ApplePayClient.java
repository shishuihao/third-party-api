package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.api.AppleReceiptApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApplePayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT
            = "https://buy.itunes.apple.com";
    /**
     * Sandbox ENDPOINT.
     */
    public static final String SANDBOX_ENDPOINT
            = "https://sandbox.itunes.apple.com";

    /**
     * new AppletPayClient.
     */
    public ApplePayClient() {
        super(ENDPOINT);
    }

    /**
     * receiptApi.
     *
     * @param properties properties
     * @return AppleReceiptApi
     */
    public AppleReceiptApi receiptApi(
            final AppleProperties properties) {
        return this.jsonApi(properties, AppleReceiptApi.class);
    }
}
