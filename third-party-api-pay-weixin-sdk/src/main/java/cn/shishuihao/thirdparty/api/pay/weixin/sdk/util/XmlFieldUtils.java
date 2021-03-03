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

public class XmlFieldUtils {
    private XmlFieldUtils() {
    }

    public static List<Field> getApiFields(final Class<?> cls) {
        return FieldUtils.getFieldsListWithAnnotation(cls, XStreamAlias.class);
    }

    public static Map<String, Object> getNameValueMap(final Object object) {
        List<Field> fieldList = getApiFields(object.getClass());
        Map<String, Object> map = new HashMap<>(fieldList.size());
        fieldList.forEach(field -> {
            XStreamAlias xmlField = field.getAnnotation(XStreamAlias.class);
            try {
                map.put(xmlField.value(), FieldUtils.readField(field, object, true));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return map;
    }

    public static Map<String, Field> getNameFieldMap(final Class<?> cls) {
        List<Field> fieldList = getApiFields(cls);
        Map<String, Field> map = new HashMap<>(fieldList.size());
        fieldList.forEach(field -> {
            XStreamAlias xmlField = field.getAnnotation(XStreamAlias.class);
            map.put(xmlField.value(), field);
        });
        return map;
    }
}
