package cn.shishuihao.thirdparty.api.push.huawei.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.AndroidConfig;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Message;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Notification;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.android.AndroidNotification;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.android.ClickAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class HuaweiSendMessageRequestTest {
    String json = "{\n" +
            "    \"validate_only\": false,\n" +
            "    \"message\": {\n" +
            "        \"notification\": {\n" +
            "            \"title\": \"title\",\n" +
            "            \"body\": \"body\"\n" +
            "        },\n" +
            "        \"android\": {\n" +
            "            \"notification\": {\n" +
            "                \"title\": \"android title\",\n" +
            "                \"body\": \"android body\",\n" +
            "                \"click_action\": {\n" +
            "                    \"type\": 1,\n" +
            "                    \"intent\": \"#Intent;compo=com.rvr/.Activity;S.W=U;end\"\n" +
            "                }\n" +
            "            }\n" +
            "        },\n" +
            "        \"token\": [\n" +
            "            \"pushtoken1\",\n" +
            "            \"pushtoken2\"\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    @Test
    void toJson() {
        HuaweiSendMessageRequest request = HuaweiSendMessageRequest.builder()
                .validateOnly(false)
                .message(Message.builder()
                        .notification(Notification.builder()
                                .title("title")
                                .body("body")
                                .build())
                        .androidConfig(AndroidConfig.builder()
                                .notification(AndroidNotification.builder()
                                        .title("android title")
                                        .body("android body")
                                        .clickAction(ClickAction.builder()
                                                .type(1)
                                                .intent("#Intent;compo=com.rvr/.Activity;S.W=U;end")
                                                .build())
                                        .build())
                                .build())
                        .token(Arrays.asList("pushtoken1", "pushtoken2"))
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, Map.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), Map.class));
    }
}