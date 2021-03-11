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

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class WxPayConverter extends ReflectionConverter {
    /**
     * String.
     */
    private static final Map<String, Field> NAME_FIELD_MAP
            = XmlFieldUtils.getNameFieldMap(WxPayResultNoticeRequest.class);

    /**
     * new WxPayResultNoticeConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     * @param type               the explicit type to handle
     */
    public WxPayConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider,
            final Class type) {
        super(mapper, reflectionProvider, type);
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
        NAME_FIELD_MAP.forEach((name, field) -> {
            try {
                Object fieldValue = FieldUtils.readField(field, source, true);
                if (fieldValue == null) {
                    return;
                }
                String namePrefix = name.replace("_$n", "");
                if (fieldValue instanceof List) {
                    marshalList(writer, (List<Object>) fieldValue, namePrefix);
                } else if (fieldValue.getClass().isArray()) {
                    marshalArray(writer, (Object[]) fieldValue, namePrefix);
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
            Object result = instantiateNewInstance(reader, context);
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                String nodeName = reader.getNodeName().trim();
                Field field = NAME_FIELD_MAP.get(nodeName);
                unmarshalField(reader, context, result, field);
                reader.moveUp();
            }
            return result;
        } catch (Exception e) {
            throw ExceptionUtils.<RuntimeException>rethrow(e);
        }
    }

    /**
     * unmarshal field.
     *
     * @param reader  The stream to read the text from.
     * @param context A context that allows nested objects
     *                to be processed by XStream.
     * @param result  result
     * @param field   field
     * @throws IllegalAccessException IllegalAccessException
     */
    protected void unmarshalField(final HierarchicalStreamReader reader,
                                  final UnmarshallingContext context,
                                  final Object result,
                                  final Field field)
            throws IllegalAccessException {
        if (field != null) {
            Class<?> type = mapper.defaultImplementationOf(field.getType());
            Object value = this.unmarshallField(context, result, type, field);
            FieldUtils.writeField(field, result, value, true);
        }
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

    private void marshalArray(final HierarchicalStreamWriter writer,
                              final Object[] objects,
                              final String namePrefix) {
        for (int i = 0; i < objects.length; i++) {
            writer.startNode(namePrefix + '_' + i);
            writer.setValue(String.valueOf(objects[i]));
            writer.endNode();
        }
    }
}
