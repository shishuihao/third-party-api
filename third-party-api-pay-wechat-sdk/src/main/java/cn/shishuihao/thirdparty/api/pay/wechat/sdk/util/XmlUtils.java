package cn.shishuihao.thirdparty.api.pay.wechat.sdk.util;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.notice.WechatPayResultNoticeRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayRefundQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPaySecApiPayRefundResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter.MapEntryConverter;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter.WechatPayOrderQueryResponseConverter;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter.WechatPayRefundQueryResponseConverter;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter.WechatPayResultNoticeRequestConverter;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter.WechatPaySecApiPayRefundResponseConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class XmlUtils {
    /**
     * XStream线程安全.
     */
    private static final Map<Class<?>, XStream> X_STREAM_MAP
            = new ConcurrentHashMap<>();
    /**
     * INTERFACE_INSTANCE_MAP.
     */
    private static final Map<Class<?>, Class<?>> INTERFACE_INSTANCE_MAP
            = new ConcurrentHashMap<>();

    static {
        INTERFACE_INSTANCE_MAP.put(java.util.Collection.class,
                java.util.ArrayList.class);
        INTERFACE_INSTANCE_MAP.put(java.util.List.class,
                java.util.ArrayList.class);
        INTERFACE_INSTANCE_MAP.put(Map.class,
                java.util.HashMap.class);
        INTERFACE_INSTANCE_MAP.put(java.util.Set.class,
                java.util.HashSet.class);
        INTERFACE_INSTANCE_MAP.put(java.util.SortedMap.class,
                java.util.TreeMap.class);
        INTERFACE_INSTANCE_MAP.put(java.util.SortedSet.class,
                java.util.TreeSet.class);
    }

    private XmlUtils() {
    }

    /**
     * from xml to object.
     *
     * @param xml  xml
     * @param type object type
     * @param <T>  object
     * @return object
     * @throws NoSuchMethodException     NoSuchMethodException
     * @throws IllegalAccessException    IllegalAccessException
     * @throws InvocationTargetException InvocationTargetException
     * @throws InstantiationException    InstantiationException
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromXml(final String xml, final Class<T> type)
            throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        return (T) getXmlStream(type).fromXML(xml, getInstanceType(type)
                .getDeclaredConstructor()
                .newInstance());
    }

    /**
     * target to xml.
     *
     * @param target target
     * @return xml
     */
    public static String toXml(final Object target) {
        return getXmlStream(target.getClass()).toXML(target);
    }

    private static XStream getXmlStream(final Class<?> cls) {
        return X_STREAM_MAP.computeIfAbsent(cls, k -> {
            XStream xStream = new CustomizedStream();
            xStream.alias("xml", cls);
            if (Map.class.isAssignableFrom(cls)) {
                xStream.registerConverter(new MapEntryConverter());
            }
            registerConverter(cls, xStream);
            // 使用注解
            xStream.processAnnotations(cls);
            // 去掉 class 属性
            xStream.aliasSystemAttribute(null, "class");
            // 设置默认安全防护
            com.thoughtworks.xstream.XStream.setupDefaultSecurity(xStream);
            // 设置允许的类
            xStream.allowTypes(new Class[]{cls});
            return xStream;
        });
    }

    private static void registerConverter(final Class<?> cls,
                                          final XStream xStream) {
        if (WechatPayResultNoticeRequest.class.isAssignableFrom(cls)) {
            xStream.registerConverter(new WechatPayResultNoticeRequestConverter(
                    xStream.getMapper(),
                    xStream.getReflectionProvider()));
        }
        if (WechatPayOrderQueryResponse.class.isAssignableFrom(cls)) {
            xStream.registerConverter(new WechatPayOrderQueryResponseConverter(
                    xStream.getMapper(),
                    xStream.getReflectionProvider()));
        }
        if (WechatPaySecApiPayRefundResponse.class.isAssignableFrom(cls)) {
            xStream.registerConverter(
                    new WechatPaySecApiPayRefundResponseConverter(
                            xStream.getMapper(),
                            xStream.getReflectionProvider()));
        }
        if (WechatPayRefundQueryResponse.class.isAssignableFrom(cls)) {
            xStream.registerConverter(new WechatPayRefundQueryResponseConverter(
                    xStream.getMapper(),
                    xStream.getReflectionProvider()));
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> Class<?> getInstanceType(final Class<T> type) {
        if (!type.isInterface()) {
            return type;
        }
        Class<T> elementType = (Class<T>) INTERFACE_INSTANCE_MAP.get(type);
        if (null != elementType) {
            return elementType;
        }
        return type;
    }

    private static class CustomizedStream extends XStream {
        CustomizedStream() {
            super(new Xpp3Driver(new NoNameCoder()));
        }

        @Override
        protected MapperWrapper wrapMapper(final MapperWrapper next) {
            return new CustomizedMapperWrapper(next);
        }
    }

    private static class CustomizedMapperWrapper extends MapperWrapper {
        CustomizedMapperWrapper(final Mapper wrapped) {
            super(wrapped);
        }

        @Override
        public boolean shouldSerializeMember(final Class definedIn,
                                             final String fieldName) {
            if (definedIn == Object.class) {
                try {
                    return this.realClass(fieldName) != null;
                } catch (CannotResolveClassException e) {
                    return false;
                }
            }
            return super.shouldSerializeMember(definedIn, fieldName);
        }
    }
}
