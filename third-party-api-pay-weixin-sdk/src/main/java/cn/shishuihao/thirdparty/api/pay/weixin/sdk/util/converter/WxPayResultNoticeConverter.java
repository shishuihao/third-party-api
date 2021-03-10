package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.notice.WxPayResultNoticeRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlFieldUtils;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class WxPayResultNoticeConverter extends ReflectionConverter {
    /**
     * String.
     */
    private static final Map<String, Field> NAME_FIELD_MAP
            = XmlFieldUtils.getNameFieldMap(WxPayResultNoticeRequest.class);
    /**
     * COUPON_TYPE_PATTERN.
     */
    private static final Pattern COUPON_TYPE_PATTERN
            = Pattern.compile("coupon_type_(.*)");
    /**
     * COUPON_FEE_PATTERN.
     */
    private static final Pattern COUPON_FEE_PATTERN
            = Pattern.compile("coupon_fee_(.*)");
    /**
     * COUPON_ID_PATTERN.
     */
    private static final Pattern COUPON_ID_PATTERN
            = Pattern.compile("coupon_id_(.*)");

    /**
     * new WxPayResultNoticeConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WxPayResultNoticeConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WxPayResultNoticeRequest.class);
    }

    /**
     * Convert an object to textual data.
     *
     * @param source  The object to be marshalled.
     * @param writer  A stream to write to.
     * @param context A context that allows nested objects
     *                to be processed by XStream.
     */
    @Override
    public void marshal(final Object source,
                        final HierarchicalStreamWriter writer,
                        final MarshallingContext context) {
        WxPayResultNoticeRequest response = (WxPayResultNoticeRequest) source;
        NAME_FIELD_MAP.forEach((name, field) -> {
            try {
                Object fieldValue = FieldUtils.readField(field, response, true);
                if (fieldValue == null) {
                    return;
                }
                String namePrefix = name.replace("_$n", "");
                if (fieldValue instanceof List) {
                    List<Object> list = (List<Object>) fieldValue;
                    marshalList(writer, list, namePrefix);
                } else {
                    writer.startNode(namePrefix);
                    writer.setValue(String.valueOf(fieldValue));
                    writer.endNode();
                }
            } catch (IllegalAccessException e) {
                throw ExceptionUtils.<RuntimeException>rethrow(e);
            }
        });
    }

    /**
     * Convert textual data back into an object.
     *
     * @param reader  The stream to read the text from.
     * @param context A context that allows nested objects
     *                to be processed by XStream.
     * @return The resulting object.
     */
    @Override
    public Object unmarshal(final HierarchicalStreamReader reader,
                            final UnmarshallingContext context) {
        try {
            WxPayResultNoticeRequest response = new WxPayResultNoticeRequest();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                String nodeName = reader.getNodeName().trim();
                putIfMatchCoupon(reader, response, nodeName);
                Field field = NAME_FIELD_MAP.get(nodeName);
                if (field != null) {
                    writeField(context, response, field);
                }
                reader.moveUp();
            }
            return response;
        } catch (Exception e) {
            throw ExceptionUtils.<RuntimeException>rethrow(e);
        }
    }

    private void writeField(final UnmarshallingContext context,
                            final WxPayResultNoticeRequest response,
                            final Field field) throws IllegalAccessException {
        Class<?> type = mapper.defaultImplementationOf(field.getType());
        Object value = this.unmarshallField(context, response, type, field);
        FieldUtils.writeField(field, response, value, true);
    }


    private void putIfMatchCoupon(final HierarchicalStreamReader reader,
                                  final WxPayResultNoticeRequest response,
                                  final String nodeName) {
        putListIfMatch(COUPON_TYPE_PATTERN, nodeName,
                response::getCouponTypes, reader::getValue);
        putListIfMatch(COUPON_FEE_PATTERN, nodeName,
                response::getCouponFees, () ->
                        Integer.valueOf(reader.getValue()));
        putListIfMatch(COUPON_ID_PATTERN, nodeName,
                response::getCouponIds, reader::getValue);
    }

    private void marshalList(final HierarchicalStreamWriter writer,
                             final List<Object> objects,
                             final String namePrefix) {
        for (int i = 0; i < objects.size(); i++) {
            writer.startNode(namePrefix + '_' + i);
            writer.setValue(String.valueOf(objects.get(i)));
            writer.endNode();
        }
    }

    private <T> void putListIfMatch(
            final Pattern pattern,
            final String nodeName,
            final Supplier<List<T>> map,
            final Supplier<T> valueSupplier) {
        Optional.of(pattern.matcher(nodeName))
                .filter(Matcher::find)
                .ifPresent(it -> map.get()
                        .add(Integer.parseInt(it.group(1)),
                                valueSupplier.get()));
    }
}
