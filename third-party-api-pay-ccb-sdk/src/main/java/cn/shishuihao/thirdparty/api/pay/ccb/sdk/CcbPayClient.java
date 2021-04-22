package cn.shishuihao.thirdparty.api.pay.ccb.sdk;

import cn.shishuihao.thirdparty.api.pay.ccb.sdk.api.ScannedPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.codec.CcbJsonEncoder;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbPayClient extends CcbWlptPayClient {
    /**
     * new CcbPayClient.
     */
    public CcbPayClient() {
        this.setJsonEncoder(CcbJsonEncoder.INSTANCE);
    }

    /**
     * onlineMerchantApi.
     *
     * @param properties properties
     * @return CcbOnlineMerchantApi
     */
    public ScannedPayApi
    scannedPayApi(final CcbProperties properties) {
        return this.jsonApi(properties, ScannedPayApi.class);
    }
}
