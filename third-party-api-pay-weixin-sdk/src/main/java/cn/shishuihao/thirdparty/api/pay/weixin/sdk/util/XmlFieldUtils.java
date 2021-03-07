package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
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
        return FieldUtils.getFieldsListWithAnnotation(cls, XStreamAlias.class);
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
            XStreamAlias xmlField = field.getAnnotation(XStreamAlias.class);
            try {
                Object value = FieldUtils.readField(field, object, true);
                map.put(xmlField.value(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
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
            XStreamAlias xmlField = field.getAnnotation(XStreamAlias.class);
            map.put(xmlField.value(), field);
        });
        return map;
    }
}
