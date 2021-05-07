package cn.shishuihao.thirdparty.api.pay.google.sdk.api;

import cn.shishuihao.thirdparty.api.pay.google.sdk.GooglePayClient;
import cn.shishuihao.thirdparty.api.pay.google.sdk.domain.ProductPurchase;
import cn.shishuihao.thirdparty.api.pay.google.sdk.request.GoogleResourceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class GoogleAndroidPublisherV3ApiTest {
    final GooglePayClient client = new GooglePayClient(GooglePayClient.ENDPOINT);

    @Test
    void getPurchasesProducts() {
        Assertions.assertTrue(Assertions.assertThrows(Exception.class, () -> {
            GoogleResourceResponse<ProductPurchase> purchase = client
                    .androidPublisherV3Api(null)
                    .getPurchasesProducts("", "", "", "");
            Assertions.assertNotNull(purchase.getResource());
        }).getMessage().contains("connect timed out"));
    }
}