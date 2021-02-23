package cn.shishuihao.thirdparty.api.push;

import cn.shishuihao.thirdparty.api.core.Api;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface PushApi<A extends PushApi<A, T, R>, T extends PushRequest<A, T, R>, R extends PushResponse> extends Api<A, T, R> {
}
