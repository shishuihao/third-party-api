package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.api;

import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.AppletPayClient;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.request.AppleVerifyReceiptRequest;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.response.AppleVerifyReceiptResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AppleReceiptApiTest {
    final AppletPayClient client = new AppletPayClient();

    @Test
    void verifyReceipt() {
        AppleVerifyReceiptResponse response = client.receiptApi(null)
                .verifyReceipt(AppleVerifyReceiptRequest.builder()
                .build());
        Assertions.assertEquals(21002, response.getStatus());
    }
}