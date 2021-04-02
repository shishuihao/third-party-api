package cn.shishuihao.thirdparty.api.pay.domain.transaction;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public enum TradeType {
    /**
     * APP支付.
     */
    APP,
    /**
     * 小程序支付.
     */
    APPLET,
    /**
     * 付款码支付.
     */
    CODE,
    /**
     * H5支付.
     */
    H5,
    /**
     * JSAPI支付.
     */
    JSAPI,
    /**
     * Native支付.
     */
    NATIVE;
}
