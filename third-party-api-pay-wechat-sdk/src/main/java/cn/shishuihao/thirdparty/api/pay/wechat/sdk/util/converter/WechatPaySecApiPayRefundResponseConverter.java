package cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPaySecApiPayRefundResponse;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WechatPaySecApiPayRefundResponseConverter
        extends WechatPayConverter {
    /**
     * new WechatPaySecApiPayRefundResponseConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WechatPaySecApiPayRefundResponseConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider,
                WechatPaySecApiPayRefundResponse.class);
    }
}
