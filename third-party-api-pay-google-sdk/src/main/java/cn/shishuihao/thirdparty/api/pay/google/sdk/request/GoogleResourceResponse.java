package cn.shishuihao.thirdparty.api.pay.google.sdk.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * @param <T> resource
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class GoogleResourceResponse<T> {
    /**
     * resource.
     */
    private final T resource;
}
