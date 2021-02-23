package cn.shishuihao.thirdparty.api.push;

import cn.shishuihao.thirdparty.api.core.Request;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface PushRequest<A extends PushApi<A, T, R>, T extends PushRequest<A, T, R>, R extends PushResponse> extends Request<A, T, R> {
}
