package cn.shishuihao.thirdparty.api.pay.alipay.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账单类型，商户通过接口或商户经开放平台授权后其所属服务商通过接口可以获取以下账单类型.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public enum AlipayBillType {
    /**
     * 商户基于支付宝交易收单的业务账单.
     */
    TRADE("trade"),
    /**
     * 基于商户支付宝余额收入及支出等资金变动的帐务账单.
     */
    SIGN_CUSTOMER("signcustomer");
    /**
     * 值.
     */
    private final String value;
}
