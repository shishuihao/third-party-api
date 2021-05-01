package cn.shishuihao.thirdparty.api.pay.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.sdk.api.AppPayApi;
import cn.shishuihao.thirdparty.api.pay.sdk.api.AppletPayApi;
import cn.shishuihao.thirdparty.api.pay.sdk.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.sdk.api.CommonPayApi;
import cn.shishuihao.thirdparty.api.pay.sdk.api.H5PayApi;
import cn.shishuihao.thirdparty.api.pay.sdk.api.JsApiPayApi;
import cn.shishuihao.thirdparty.api.pay.sdk.api.NativeApiPayApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PayClient extends HttpClient {
    /**
     * new PayClient.
     *
     * @param endpoint endpoint
     */
    public PayClient(final String endpoint) {
        super(endpoint);
    }

    /**
     * commonApi.
     *
     * @param properties properties
     * @return CommonPayApi
     */
    public CommonPayApi commonApi(
            final PayProperties properties) {
        return this.jsonApi(properties, CommonPayApi.class);
    }

    /**
     * codeApi.
     *
     * @param properties properties
     * @return WechatPayCodeApi
     */
    public CodePayApi codeApi(
            final PayProperties properties) {
        return this.jsonApi(properties, CodePayApi.class);
    }

    /**
     * jsApi.
     *
     * @param properties properties
     * @return JsApiPayApi
     */
    public JsApiPayApi jsApi(
            final PayProperties properties) {
        return this.jsonApi(properties, JsApiPayApi.class);
    }

    /**
     * nativeApi.
     *
     * @param properties properties
     * @return NativeApiPayApi
     */
    public NativeApiPayApi nativeApi(
            final PayProperties properties) {
        return this.jsonApi(properties, NativeApiPayApi.class);
    }

    /**
     * appApi.
     *
     * @param properties properties
     * @return AppPayApi
     */
    public AppPayApi appApi(
            final PayProperties properties) {
        return this.jsonApi(properties, AppPayApi.class);
    }

    /**
     * h5Api.
     *
     * @param properties properties
     * @return H5PayApi
     */
    public H5PayApi h5Api(
            final PayProperties properties) {
        return this.jsonApi(properties, H5PayApi.class);
    }

    /**
     * appletApi.
     *
     * @param properties properties
     * @return AppletPayApi
     */

    public AppletPayApi appletApi(
            final PayProperties properties) {
        return this.jsonApi(properties, AppletPayApi.class);
    }
}
