package cn.shishuihao.thirdparty.api.push.huawei.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class HuaweiSendMessageResponseTest {
    final String json = "{\n" +
            "    \"code\": \"80100000\",\n" +
            "    \"msg\": \"{\\\"success\\\":3,\\\"failure\\\":1,\\\"illegal_tokens\\\":[\\\"xxx\\\"]}\",\n" +
            "    \"requestId\": \"\"\n" +
            "}";

    @Test
    void toJson() {
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, Map.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json, HuaweiSendMessageResponse.class)), Map.class));
    }
}