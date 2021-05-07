package cn.shishuihao.thirdparty.api.pay.google.sdk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class ProductPurchase {
    /**
     * This kind represents an inappPurchase object in the androidpublisher
     * service.
     * The value may be {@code null}.
     */
    private final String kind;
    /**
     * The time the product was purchased,
     * in milliseconds since the epoch (Jan 1, 1970).
     * The value may be {@code null}.
     */
    private final Long purchaseTimeMillis;
    /**
     * The purchase state of the order.
     * Possible values are:
     * - Purchased
     * - Canceled
     * - Pending
     * The value may be {@code null}.
     */
    private final Integer purchaseState;
    /**
     * The consumption state of the inapp product.
     * Possible values are: - Yet to be consumed  -
     * Consumed
     * The value may be {@code null}.
     */
    private final Integer consumptionState;
    /**
     * A developer-specified string that contains supplemental information
     * about an order.
     * The value may be {@code null}.
     */
    private final String developerPayload;
    /**
     * The order id associated with the purchase of the inapp product.
     * The value may be {@code null}.
     */
    private final String orderId;
    /**
     * The type of purchase of the inapp product.
     * This field is only set if this purchase was not made
     * using the standard in-app billing flow.
     * Possible values are:
     * - Test (i.e. purchased from a license testing account)
     * - Promo (i.e. purchased using a promo code)
     * - Rewarded (i.e. from watching a video ad instead of paying)
     * The value may be {@code null}.
     */
    private final Integer purchaseType;
    /**
     * The acknowledgement state of the inapp product.
     * Possible values are:
     * - Yet to be acknowledged
     * - Acknowledged
     * The value may be {@code null}.
     */
    private final Integer acknowledgementState;
    /**
     * The purchase token generated to identify this purchase.
     * The value may be {@code null}.
     */
    private final String purchaseToken;
    /**
     * The inapp product SKU.
     * The value may be {@code null}.
     */
    private final String productId;
    /**
     * The quantity associated with the purchase of the inapp product.
     * The value may be {@code null}.
     */
    private final Integer quantity;
    /**
     * An obfuscated version of the id that is uniquely associated with
     * the user's account in your app.
     * Only present if specified using
     * https://developer.android.com/reference/com/android/billingclient/api
     * /BillingFlowParams.Builder#setobfuscatedaccountid
     * when the purchase was made.
     * The value may be {@code null}.
     */
    private final String obfuscatedExternalAccountId;
    /**
     * An obfuscated version of the id that is uniquely associated with
     * the user's profile in your app.
     * Only present if specified using
     * https://developer.android.com/reference/com/android/billingclient/api
     * /BillingFlowParams.Builder#setobfuscatedprofileid
     * when the purchase was made.
     * The value may be {@code null}.
     */
    private final String obfuscatedExternalProfileId;
    /**
     * ISO 3166-1 alpha-2 billing region code of the user
     * at the time the product was granted.
     * The value may be {@code null}.
     */
    private final String regionCode;
}
