package cn.shishuihao.thirdparty.api.pay.google.sdk.api;

import cn.shishuihao.thirdparty.api.pay.google.sdk.domain.ProductPurchase;
import cn.shishuihao.thirdparty.api.pay.google.sdk.request.GoogleResourceResponse;
import feign.Param;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface GoogleAndroidPublisherV3Api {
    /**
     * Checks the purchase and consumption status of an inapp item.
     * {@link "https://developers.google.com/android-publisher/api-ref
     * /purchases/products/get"}
     * {@link "https://developers.google.cn/android-publisher/api-ref
     * /purchases/products/get"}
     *
     * @param packageName The package name of the application the inapp product
     *                    was sold in (for example, 'com.some.thing').
     * @param productId   The inapp product SKU
     *                    (for example, 'com.some.thing.inapp1')
     * @param token       The token provided to the user's device
     *                    when the inapp product was purchased
     * @param accessToken accessToken
     * @return response
     */
    @RequestLine("GET /androidpublisher/v3/applications/{packageName}"
            + "/purchases/products/{productId}/tokens/{token}"
            + "?access_token={accessToken}")
    GoogleResourceResponse<ProductPurchase>
    getPurchasesProducts(@Param("packageName") String packageName,
                         @Param("productId") String productId,
                         @Param("token") String token,
                         @Param("accessToken") String accessToken);
}
