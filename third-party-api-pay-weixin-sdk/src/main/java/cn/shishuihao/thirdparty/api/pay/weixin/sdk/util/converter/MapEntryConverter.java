package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class MapEntryConverter implements Converter {
    @Override
    public boolean canConvert(Class type) {
        return Map.class.isAssignableFrom(type);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Map<String, String> map = (Map<String, String>) value;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            writer.startNode(entry.getKey());
            writer.setValue(entry.getValue());
            writer.endNode();
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Map<String, String> map = new HashMap<>(16);
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            map.put(reader.getNodeName(), reader.getValue());
            reader.moveUp();
        }
        return map;
    }
}
