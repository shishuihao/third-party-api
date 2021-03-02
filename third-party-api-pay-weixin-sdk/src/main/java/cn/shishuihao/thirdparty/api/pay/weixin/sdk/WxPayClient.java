package cn.shishuihao.thirdparty.api.pay.weixin.sdk;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlDecoder;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlEncoder;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxPayClient {
    private final WxPayApi payApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayApi.class, "https://api.mch.weixin.qq.com");

    public WxPayApi getPayApi() {
        return payApi;
    }
}
