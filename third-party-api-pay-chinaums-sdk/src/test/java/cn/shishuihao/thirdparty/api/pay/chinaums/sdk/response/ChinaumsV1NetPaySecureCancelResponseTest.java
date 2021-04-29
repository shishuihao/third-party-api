package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPaySecureCancelResponseTest {
    final String json = "{\n" +
            " \"responseTimestamp\": \"2018-09-21 17:30:01\",\n" +
            " \"errCode\": \"HAS_CANCELLED\",\n" +
            " \"errMsg\": \"该笔担保交易已撤销\"" +
            "}";

    @Test
    void fromJson() {
        ChinaumsV1NetPaySecureCancelResponse response = JacksonUtils.fromJson(json, ChinaumsV1NetPaySecureCancelResponse.class);
        Assertions.assertEquals(JacksonUtils.fromJson(json, HashMap.class), JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}