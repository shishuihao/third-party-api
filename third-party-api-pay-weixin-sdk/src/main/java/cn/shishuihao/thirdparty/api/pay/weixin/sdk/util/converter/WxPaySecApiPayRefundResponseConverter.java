package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPaySecApiPayRefundResponse;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WxPaySecApiPayRefundResponseConverter extends WxPayConverter {
    /**
     * new WxPaySecApiPayRefundResponseConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WxPaySecApiPayRefundResponseConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WxPaySecApiPayRefundResponse.class);
    }
}
