package cn.shishuihao.thirdparty.api.core.impl;

import cn.shishuihao.thirdparty.api.core.Api;
import cn.shishuihao.thirdparty.api.core.Channel;
import cn.shishuihao.thirdparty.api.core.Request;
import cn.shishuihao.thirdparty.api.core.Response;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractChannel extends RepositoryMemoryImpl<Class<?>, Api<?, ?, ?>> implements Channel {
    @SuppressWarnings("unchecked")
    @Override
    public <A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> Optional<A> getApi(Class<A> apiType) {
        return Optional.ofNullable((A) this.getById(apiType).orElse(null));
    }
}
