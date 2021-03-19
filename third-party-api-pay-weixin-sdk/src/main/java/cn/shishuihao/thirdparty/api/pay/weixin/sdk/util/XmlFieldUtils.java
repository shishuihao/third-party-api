package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class XmlFieldUtils {
    private XmlFieldUtils() {
    }

    /**
     * get fields.
     *
     * @param cls class
     * @return field list
     */
    public static List<Field> getFields(final Class<?> cls) {
        List<Field> list = new ArrayList<>();
        list.addAll(FieldUtils.getFieldsListWithAnnotation(cls, XStreamAlias.class));
        list.addAll(FieldUtils.getFieldsListWithAnnotation(cls, JacksonXmlProperty.class));
        return list;
    }

    /**
     * get name value map.
     *
     * @param object object
     * @return name value map
     */
    public static Map<String, Object> getNameValueMap(final Object object) {
        List<Field> fieldList = getFields(object.getClass());
        Map<String, Object> map = new HashMap<>(fieldList.size());
        fieldList.forEach(field -> {
            handleXStreamAlias(object, map, field);
            handleJacksonXmlProperty(object, map, field);
        });
        return map;
    }

    /**
     * get name field map.
     *
     * @param cls cls
     * @return name field map
     */
    public static Map<String, Field> getNameFieldMap(final Class<?> cls) {
        List<Field> fieldList = getFields(cls);
        Map<String, Field> map = new HashMap<>(fieldList.size());
        fieldList.forEach(field -> {
            XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);
            if (xStreamAlias != null) {
                map.put(xStreamAlias.value(), field);
            }
            JacksonXmlProperty jacksonXmlProperty = field.getAnnotation(JacksonXmlProperty.class);
            if (jacksonXmlProperty != null) {
                map.put(jacksonXmlProperty.localName(), field);
            }
        });
        return map;
    }

    private static void handleJacksonXmlProperty(Object object, Map<String, Object> map, Field field) {
        JacksonXmlProperty jacksonXmlProperty = field.getAnnotation(JacksonXmlProperty.class);
        if (jacksonXmlProperty != null) {
            try {
                Object value = FieldUtils.readField(field, object, true);
                map.put(jacksonXmlProperty.localName(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleXStreamAlias(Object object, Map<String, Object> map, Field field) {
        XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);
        if (xStreamAlias != null) {
            try {
                Object value = FieldUtils.readField(field, object, true);
                map.put(xStreamAlias.value(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
