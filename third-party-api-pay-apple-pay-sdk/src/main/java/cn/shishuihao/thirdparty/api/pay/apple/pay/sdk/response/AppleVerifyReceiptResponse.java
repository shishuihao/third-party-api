package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.response;

import cn.shishuihao.thirdparty.api.commons.http.response.HttpResponse;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.domain.LatestReceiptInfo;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.domain.PendingRenewalInfo;
import cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.domain.Receipt;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AppleVerifyReceiptResponse
        implements HttpResponse {
    /**
     * The environment for which the receipt was generated.
     * Possible values: Sandbox,
     * Production.
     */
    @JsonProperty("environment")
    private final String environment;
    /**
     * An indicator that an error occurred during the request.
     * A value of 1 indicates a temporary issue;
     * retry validation for this receipt at a later time.
     * A value of 0 indicates an unresolvable issue;
     * do not retry validation for this receipt.
     * Only applicable to status codes 21100-21199..
     */
    @JsonProperty("is-retryable")
    private final Boolean isRetryable;
    /**
     * The latest Base64 encoded app receipt.
     * Only returned for receipts that contain auto-renewable subscriptions.
     */
    @JsonProperty("latest_receipt")
    private final String latestReceipt;
    /**
     * An array that contains all in-app purchase transactions.
     * This excludes transactions for consumable products
     * that have been marked as finished by your app.
     * Only returned for receipts that contain auto-renewable subscriptions.
     */
    @JsonProperty("latest_receipt_info")
    private final LatestReceiptInfo[] latestReceiptInfo;
    /**
     * In the JSON file,
     * an array where each element contains the pending
     * renewal information for each auto-renewable subscription identified
     * by the product_id.
     * Only returned for app receipts that contain auto-renewable subscriptions.
     */
    @JsonProperty("pending_renewal_info")
    private final PendingRenewalInfo[] pendingRenewalInfo;
    /**
     * A JSON representation of the receipt that was sent for verification.
     */
    @JsonProperty("receipt")
    private final Receipt receipt;
    /**
     * Either 0 if the receipt is valid,
     * or a status code if there is an error.
     * The status code reflects the status of the app receipt as a whole.
     * See status for possible status codes and descriptions.
     * 21000
     * The request to the App Store was not made
     * using the HTTP POST request method.
     * 21001
     * This status code is no longer sent by the App Store.
     * 21002
     * The data in the receipt-data property was malformed
     * or the service experienced a temporary issue.
     * Try again.
     * 21003
     * The receipt could not be authenticated.
     * 21004
     * The shared secret you provided does not match the shared secret
     * on file for your account.
     * 21005
     * The receipt server was temporarily unable to provide the receipt.
     * Try again.
     * 21006
     * This receipt is valid but the subscription has expired.
     * When this status code is returned to your server,
     * the receipt data is also decoded and returned as part of the response.
     * Only returned for iOS 6-style transaction receipts
     * for auto-renewable subscriptions.
     * 21007
     * This receipt is from the test environment,
     * but it was sent to the production environment for verification.
     * 21008
     * This receipt is from the production environment,
     * but it was sent to the test environment for verification.
     * 21009
     * Internal data access error.
     * Try again later.
     * 21010
     * The user account cannot be found or has been deleted.
     */
    @JsonProperty("status")
    private final Integer status;
}
