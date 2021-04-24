package cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.notice.WechatPayResultNoticeRequest;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WechatPayResultNoticeRequestConverter
        extends WechatPayConverter {
    /**
     * new WechatPayResultNoticeRequestConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WechatPayResultNoticeRequestConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider,
                WechatPayResultNoticeRequest.class);
    }
}
