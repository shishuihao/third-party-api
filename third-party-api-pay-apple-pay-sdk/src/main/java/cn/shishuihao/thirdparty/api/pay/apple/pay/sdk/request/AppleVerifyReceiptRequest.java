package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * To receive a decoded receipt for validation, send a request
 * with the encoded receipt data and app password to the App Store.
 * For auto-renewable subscriptions, optionally include an exclusion flag.
 * Send this JSON data using the HTTP POST request method.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class AppleVerifyReceiptRequest {
    /**
     * (Required) The Base64-encoded receipt data.
     */
    @JsonProperty("receipt-data")
    private final String receiptData;
    /**
     * (Required) Your app’s shared secret, which is a hexadecimal string.
     */
    @JsonProperty("password")
    private final String password;
    /**
     * Set this value to true for the response to include only
     * the latest renewal transaction for any subscriptions.
     * Use this field only for app receipts
     * that contain auto-renewable subscriptions.
     */
    @JsonProperty("exclude-old-transactions")
    private final boolean excludeOldTransactions;
}
