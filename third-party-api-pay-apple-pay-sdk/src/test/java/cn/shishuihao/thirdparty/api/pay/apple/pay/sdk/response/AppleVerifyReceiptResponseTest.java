package cn.shishuihao.thirdparty.api.pay.apple.pay.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AppleVerifyReceiptResponseTest {
    final String json = "{\n" +
            "    \"status\": 0,\n" +
            "    \"environment\": \"Production\",\n" +
            "    \"receipt\": {\n" +
            "        \"receipt_type\": \"Production\",\n" +
            "        \"adam_id\": 2341443613,\n" +
            "        \"app_item_id\": 2234443613,\n" +
            "        \"bundle_id\": \"com.xxxxx.xxxxx\",\n" +
            "        \"application_version\": \"1\",\n" +
            "        \"download_id\": 23456572706673,\n" +
            "        \"version_external_identifier\": 821223402,\n" +
            "        \"receipt_creation_date\": \"2017-01-25 00:52:37 Etc/GMT\",\n" +
            "        \"receipt_creation_date_ms\": \"3333897657000\",\n" +
            "        \"receipt_creation_date_pst\": \"2017-01-25 17:57:37 America/Los_Angeles\",\n" +
            "        \"request_date\": \"2017-01-26 00:57:38 Etc/GMT\",\n" +
            "        \"request_date_ms\": \"1445897657000\",\n" +
            "        \"request_date_pst\": \"2017-05-29 17:57:38 America/Los_Angeles\",\n" +
            "        \"original_purchase_date\": \"2016-01-25 15:37:18 Etc/GMT\",\n" +
            "        \"original_purchase_date_ms\": \"145234568000\",\n" +
            "        \"original_purchase_date_pst\": \"2016-01-25 07:37:18 America/Los_Angeles\",\n" +
            "        \"original_application_version\": \"12\",\n" +
            "        \"in_app\": [\n" +
            "             {\n" +
            "                 \"quantity\": \"1\",\n" +
            "                 \"product_id\": \"xxxxxxxxx\",\n" +
            "                 \"transaction_id\": \"110000290198443\",\n" +
            "                 \"original_transaction_id\": \"110000290198443\",\n" +
            "                 \"purchase_date\": \"2017-01-26 00:23:36 Etc/GMT\",\n" +
            "                 \"purchase_date_ms\": \"1496105856000\",\n" +
            "                 \"purchase_date_pst\": \"2017-01-26 00:35:30 America/Los_Angeles\",\n" +
            "                 \"original_purchase_date\": \"2017-01-26 00:57:36 Etc/GMT\",\n" +
            "                 \"original_purchase_date_ms\": \"14347896000\",\n" +
            "                 \"original_purchase_date_pst\": \"2017-01-25 17:57:36 America/Los_Angeles\",\n" +
            "                 \"is_trial_period\": \"false\"\n" +
            "             }\n" +
            "         ]\n" +
            "     }\n" +
            "}\n";

    @Test
    void fromJson() {
        final AppleVerifyReceiptResponse response = JacksonUtils
                .fromJson(json, AppleVerifyReceiptResponse.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}