package cn.shishuihao.thirdparty.api.core.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
public class BaseApiResponse implements ApiResponse {
    /**
     * success.
     */
    private final boolean success;
    /**
     * error code.
     */
    private final String code;
    /**
     * error message.
     */
    private final String message;
    /**
     * request id.
     */
    private final String requestId;
}
