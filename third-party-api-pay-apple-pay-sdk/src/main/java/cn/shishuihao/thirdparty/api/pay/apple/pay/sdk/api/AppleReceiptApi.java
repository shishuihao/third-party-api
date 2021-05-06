package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.api;

import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.request.AppleVerifyReceiptRequest;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.response.AppleVerifyReceiptResponse;
import feign.RequestLine;

/**
 * 通过App Store验证应用和应用内购买收据.
 * {@link "https://developer.apple.com/documentation/appstorereceipts"}
 * {@link "https://developer.apple.com/cn/documentation/storekit/in-app_purchase
 * /validating_receipts_with_the_app_store/"}
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface AppleReceiptApi {
    /**
     * verify receipt.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /verifyReceipt")
    AppleVerifyReceiptResponse
    verifyReceipt(AppleVerifyReceiptRequest request);
}
