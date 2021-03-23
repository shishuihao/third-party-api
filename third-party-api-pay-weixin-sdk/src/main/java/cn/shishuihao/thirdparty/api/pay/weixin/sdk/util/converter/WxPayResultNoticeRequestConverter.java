package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.notice.WxPayResultNoticeRequest;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WxPayResultNoticeRequestConverter extends WxPayConverter {
    /**
     * new WxPayResultNoticeRequestConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WxPayResultNoticeRequestConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WxPayResultNoticeRequest.class);
    }
}
