package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TargetSys {
    /**
     * Alipay 1.0 支付宝1.0协议 比较少用.
     */
    ALIPAY_1_0("Alipay 1.0"),
    /**
     * Alipay 2.0 支付宝2.0协议 主流.
     */
    ALIPAY_2_0("Alipay 2.0"),
    /**
     * WXPay 微信.
     */
    WXPAY("WXPay"),
    /**
     * YQB 壹钱包.
     */
    YQB("YQB"),
    /**
     * QMF 全民付远程快捷.
     */
    QMF("QMF"),
    /**
     * UnionPay 银联钱包.
     */
    UNION_PAY("UnionPay"),
    /**
     * BaiDu 百度钱包.
     */
    BAI_DU("BaiDu"),
    /**
     * JD 京东钱包.
     */
    JD("JD"),
    /**
     * SF   顺丰顺手付.
     */
    SF("SF"),
    /**
     * COMM 交通银行.
     */
    COMM("COMM"),
    /**
     * BestPay 翼支付.
     */
    BEST_PAY("BestPay"),
    /**
     * ACP 银联全渠道立码付.
     */
    ACP("ACP"),
    /**
     * NetPayBills 银商网付平台账单模块.
     */
    NET_PAY_BILLS("NetPayBills"),
    /**
     * NetPayGtwy 银商网付平台网关模块.
     */
    NET_PAY_GTWY("NetPayGtwy"),
    /**
     * QmfWebPay POS通插件WEB版.
     */
    QMF_WEB_PAY("QmfWebPay"),
    /**
     * UAC 银联全渠道.
     */
    UAC("UAC");

    /**
     * code.
     */
    private final String code;
}
