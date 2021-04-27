package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.api.FuiouPayApi;
import cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.codec.FuiouXmlEncoder;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FuiouPayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://pay.fuioupay.com";

    /**
     * new FuiouPayClient.
     */
    public FuiouPayClient() {
        this(ENDPOINT);
    }

    /**
     * new FuiouPayClient.
     *
     * @param pUrl url
     */
    public FuiouPayClient(final String pUrl) {
        super(pUrl);
        this.setXmlEncoder(FuiouXmlEncoder.INSTANCE);
    }

    /**
     * payApi.
     *
     * @return FuiouPayApi
     */
    public FuiouPayApi
    payApi() {
        return this.xmlApi(null, FuiouPayApi.class);
    }
}
