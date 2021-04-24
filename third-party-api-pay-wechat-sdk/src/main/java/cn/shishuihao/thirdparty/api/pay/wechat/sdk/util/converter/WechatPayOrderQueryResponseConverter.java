package cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayOrderQueryResponse;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WechatPayOrderQueryResponseConverter
        extends WechatPayConverter {
    /**
     * new WechatPayOrderQueryResponseConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WechatPayOrderQueryResponseConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider,
                WechatPayOrderQueryResponse.class);
    }
}
