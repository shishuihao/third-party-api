package cn.shishuihao.thirdparty.api.push.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.push.PushApiResponse;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
public class PushMessageApiResponse
        extends BaseApiResponse
        implements PushApiResponse {
}
