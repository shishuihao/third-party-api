package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * the in-app purchase receipt fields for all in-app purchase transactions.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class ReceiptInApp {
    /**
     * The time Apple customer support canceled a transaction,
     * in a date-time format similar to the ISO 8601.
     * This field is only present for refunded transactions.
     */
    @JsonProperty("cancellation_date")
    private final String cancellationDate;
    /**
     * The time Apple customer support canceled a transaction,
     * or the time an auto-renewable subscription plan was upgraded,
     * in UNIX epoch time format, in milliseconds.
     * This field is only present for refunded transactions.
     * Use this time format for processing dates.
     * See cancellation_date_ms for more information.
     */
    @JsonProperty("cancellation_date_ms")
    private final String cancellationDateMs;
    /**
     * The time Apple customer support canceled a transaction,
     * in the Pacific Time zone.
     * This field is only present for refunded transactions.
     */
    @JsonProperty("cancellation_date_pst")
    private final String cancellationDatePst;
    /**
     * The reason for a refunded transaction.
     * When a customer cancels a transaction,
     * the App Store gives them a refund and provides a value for this key.
     * A value of “1” indicates that the customer canceled their transaction
     * due to an actual or perceived issue within your app.
     * A value of “0” indicates that the transaction was canceled
     * for another reason;
     * for example, if the customer made the purchase accidentally.
     * Possible values: 1, 0
     */
    @JsonProperty("cancellation_reason")
    private final String cancellationReason;
    /**
     * The time a subscription expires or when it will renew,
     * in a date-time format similar to the ISO 8601.
     */
    @JsonProperty("expires_date")
    private final String expiresDate;
    /**
     * The time a subscription expires or when it will renew,
     * in UNIX epoch time format, in milliseconds.
     * Use this time format for processing dates.
     * See expires_date_ms for more information.
     */
    @JsonProperty("expires_date_ms")
    private final String expiresDateMs;
    /**
     * The time a subscription expires or when it will renew,
     * in the Pacific Time zone.
     */
    @JsonProperty("expires_date_pst")
    private final String expiresDatePst;
    /**
     * An indicator of whether an auto-renewable subscription
     * is in the introductory price period.
     * See is_in_intro_offer_period for more information.
     * Possible values: true, false
     */
    @JsonProperty("is_in_intro_offer_period")
    private final String isInIntroOfferPeriod;
    /**
     * An indicator of whether a subscription is in the free trial period.
     * See is_trial_period for more information.
     */
    @JsonProperty("is_trial_period")
    private final String isTrialPeriod;
    /**
     * The time of the original app purchase,
     * in a date-time format similar to ISO 8601.
     */
    @JsonProperty("original_purchase_date")
    private final String originalPurchaseDate;
    /**
     * The time of the original app purchase,
     * in UNIX epoch time format,
     * in milliseconds.
     * Use this time format for processing dates.
     */
    @JsonProperty("original_purchase_date_ms")
    private final String originalPurchaseDateMs;
    /**
     * The time of the original app purchase,
     * in the Pacific Time zone.
     */
    @JsonProperty("original_purchase_date_pst")
    private final String originalPurchaseDatePst;
    /**
     * The transaction identifier of the original purchase.
     * See original_transaction_id for more information.
     */
    @JsonProperty("original_transaction_id")
    private final String originalTransactionId;
    /**
     * The unique identifier of the product purchased.
     * You provide this value when creating the product in App Store Connect,
     * and it corresponds to the productIdentifier property of
     * the SKPayment object stored in the transaction’s payment property.
     */
    @JsonProperty("product_id")
    private final String productId;
    /**
     * The identifier of the subscription offer redeemed by the user.
     * See promotional_offer_id for more information.
     */
    @JsonProperty("promotional_offer_id")
    private final String promotionalOfferId;
    /**
     * The time the App Store charged the user’s account for a purchased
     * or restored product,
     * or the time the App Store charged the user’s account for a subscription
     * purchase or renewal after a lapse,
     * in a date-time format similar to ISO 8601.
     */
    @JsonProperty("purchase_date")
    private final String purchaseDate;
    /**
     * For consumable, non-consumable, and non-renewing subscription products,
     * the time the App Store charged the user’s account for a purchased
     * or restored product,
     * in the UNIX epoch time format, in milliseconds.
     * For auto-renewable subscriptions,
     * the time the App Store charged the user’s account for a subscription
     * purchase or renewal after a lapse,
     * in the UNIX epoch time format, in milliseconds.
     * Use this time format for processing dates.
     */
    @JsonProperty("purchase_date_ms")
    private final String purchaseDateMs;
    /**
     * The time the App Store charged the user’s account for a purchased
     * or restored product,
     * or the time the App Store charged the user’s account for a subscription
     * purchase or renewal after a lapse,
     * in the Pacific Time zone.
     */
    @JsonProperty("purchase_date_pst")
    private final String purchaseDatePst;
    /**
     * The number of consumable products purchased.
     * This value corresponds to the quantity property of the SKPayment
     * object stored in the transaction’s payment property.
     * The value is usually “1” unless modified with a mutable payment.
     * The maximum value is 10.
     */
    @JsonProperty("quantity")
    private final String quantity;
    /**
     * A unique identifier for a transaction such as a purchase,
     * restore, or renewal.
     * See transaction_id for more information.
     */
    @JsonProperty("transaction_id")
    private final String transactionId;
    /**
     * A unique identifier for purchase events across devices,
     * including subscription-renewal events.
     * This value is the primary key for identifying subscription purchases.
     */
    @JsonProperty("web_order_line_item_id")
    private final String webOrderLineItemId;
}
