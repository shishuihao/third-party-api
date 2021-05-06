package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.api;

import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.ApplePayClient;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.request.AppleVerifyReceiptRequest;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.response.AppleVerifyReceiptResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AppleReceiptApiTest {
    final ApplePayClient client = new ApplePayClient();

    @Test
    void verifyReceipt() {
        AppleVerifyReceiptResponse response = client.receiptApi(null)
                .verifyReceipt(AppleVerifyReceiptRequest.builder()
                .build());
        Assertions.assertEquals(21002, response.getStatus());
    }
}