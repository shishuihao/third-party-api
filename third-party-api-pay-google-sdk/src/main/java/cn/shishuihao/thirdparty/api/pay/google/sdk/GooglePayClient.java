package cn.shishuihao.thirdparty.api.pay.google.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.google.sdk.api.GoogleAndroidPublisherV3Api;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class GooglePayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT
            = "https://androidpublisher.googleapis.com";

    /**
     * new GooglePayClient.
     */
    public GooglePayClient() {
        super(ENDPOINT);
    }

    /**
     * GooglePayClient.
     *
     * @param pUrl url
     */
    public GooglePayClient(final String pUrl) {
        super(pUrl);
    }

    /**
     * androidPublisherV3Api.
     *
     * @param properties properties
     * @return GoogleAndroidPublisherApi
     */
    public GoogleAndroidPublisherV3Api androidPublisherV3Api(
            final GoogleProperties properties) {
        return this.jsonApi(properties, GoogleAndroidPublisherV3Api.class);
    }
}
