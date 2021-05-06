package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * An array of elements that refers to open
 * or failed auto-renewable subscription renewals.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class PendingRenewalInfo {
    /**
     * The value for this key corresponds to the productIdentifier property
     * of the product that the customer’s subscription renews.
     */
    @JsonProperty("auto_renew_product_id")
    private final String autoRenewProductId;
    /**
     * The current renewal status for the auto-renewable subscription.
     * See auto_renew_status for more information.
     */
    @JsonProperty("auto_renew_status")
    private final String autoRenewStatus;
    /**
     * The reason a subscription expired.
     * This field is only present for a receipt
     * that contains an expired auto-renewable subscription.
     */
    @JsonProperty("expiration_intent")
    private final String expirationIntent;
    /**
     * The time at which the grace period for subscription renewals expires,
     * in a date-time format similar to the ISO 8601.
     */
    @JsonProperty("grace_period_expires_date")
    private final String gracePeriodExpiresDate;
    /**
     * The time at which the grace period for subscription renewals expires,
     * in UNIX epoch time format,
     * in milliseconds.
     * This key is only present for apps that have Billing Grace Period enabled
     * and when the user experiences a billing error at the time of renewal.
     * Use this time format for processing dates.
     */
    @JsonProperty("grace_period_expires_date_ms")
    private final String gracePeriodExpiresDateMs;
    /**
     * The time at which the grace period for subscription renewals expires,
     * in the Pacific Time zone.
     */
    @JsonProperty("grace_period_expires_date_pst")
    private final String gracePeriodExpiresDatePst;
    /**
     * A flag that indicates Apple is attempting to
     * renew an expired subscription automatically.
     * This field is only present if an auto-renewable subscription
     * is in the billing retry state.
     * See is_in_billing_retry_period for more information.
     */
    @JsonProperty("is_in_billing_retry_period")
    private final String isInBillingRetryPeriod;
    /**
     * The reference name of a subscription offer
     * that you configured in App Store Connect.
     * This field is present when a customer redeemed a subscription offer code.
     * For more information,
     * see offer_code_ref_name.
     */
    @JsonProperty("offer_code_ref_name")
    private final String offerCodeRefName;
    /**
     * The transaction identifier of the original purchase.
     */
    @JsonProperty("original_transaction_id")
    private final String originalTransactionId;
    /**
     * The price consent status for a subscription price increase.
     * This field is only present if the customer was notified of
     * the price increase.
     * The default value is "0" and changes to "1" if the customer consents.
     * Possible values: 1,
     * 0
     */
    @JsonProperty("price_consent_status")
    private final String priceConsentStatus;
    /**
     * The unique identifier of the product purchased.
     * You provide this value when creating the product in App Store Connect,
     * and it corresponds to the productIdentifier property of
     * the SKPayment object stored in the transaction's payment property.
     */
    @JsonProperty("product_id")
    private final String productId;
    /**
     * The identifier of the promotional offer
     * for an auto-renewable subscription that the user redeemed.
     * You provide this value in the Promotional Offer Identifier field
     * when you create the promotional offer in App Store Connect.
     */
    @JsonProperty("promotional_offer_id")
    private final String promotionalOfferId;
}
