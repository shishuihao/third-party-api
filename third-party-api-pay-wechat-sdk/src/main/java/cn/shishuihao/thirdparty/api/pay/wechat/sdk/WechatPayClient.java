package cn.shishuihao.thirdparty.api.pay.wechat.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayAppApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayAppletApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayCommonApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayFaceApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayH5Api;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayJsApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayNativeApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.codec.WechatXmlDecoder;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatPayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";

    /**
     * new WechatPayClient.
     */
    public WechatPayClient() {
        super(ENDPOINT);
        this.setXmlDecoder(WechatXmlDecoder.INSTANCE);
    }

    /**
     * commonApi.
     *
     * @param properties properties
     * @return WechatPayCommonApi
     */
    public WechatPayCommonApi commonApi(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayCommonApi.class);
    }

    /**
     * codeApi.
     *
     * @param properties properties
     * @return WechatPayCodeApi
     */
    public WechatPayCodeApi codeApi(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayCodeApi.class);
    }

    /**
     * jsApi.
     *
     * @param properties properties
     * @return WechatPayJsApi
     */
    public WechatPayJsApi jsApi(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayJsApi.class);
    }

    /**
     * nativeApi.
     *
     * @param properties properties
     * @return WechatPayNativeApi
     */
    public WechatPayNativeApi nativeApi(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayNativeApi.class);
    }

    /**
     * appApi.
     *
     * @param properties properties
     * @return WechatPayAppApi
     */
    public WechatPayAppApi appApi(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayAppApi.class);
    }

    /**
     * h5Api.
     *
     * @param properties properties
     * @return WechatPayH5Api
     */
    public WechatPayH5Api h5Api(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayH5Api.class);
    }

    /**
     * appletApi.
     *
     * @param properties properties
     * @return WechatPayAppletApi
     */

    public WechatPayAppletApi appletApi(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayAppletApi.class);
    }

    /**
     * faceApi.
     *
     * @param properties properties
     * @return WechatPayFaceApi
     */
    public WechatPayFaceApi faceApi(
            final WechatProperties properties) {
        return this.xmlApi(properties, WechatPayFaceApi.class);
    }
}
