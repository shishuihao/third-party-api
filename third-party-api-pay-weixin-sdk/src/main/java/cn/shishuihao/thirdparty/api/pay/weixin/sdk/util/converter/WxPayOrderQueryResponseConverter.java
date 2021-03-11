package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayOrderQueryResponse;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WxPayOrderQueryResponseConverter extends WxPayConverter {
    /**
     * new WxPayResultNoticeConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WxPayOrderQueryResponseConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WxPayOrderQueryResponse.class);
    }
}
