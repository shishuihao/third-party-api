package cn.shishuihao.thirdparty.api.pay.response;

import cn.shishuihao.thirdparty.api.pay.PayApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class JsApiPayApiResponse
        implements PayApiResponse {
    /**
     * body.
     */
    private final String body;
}