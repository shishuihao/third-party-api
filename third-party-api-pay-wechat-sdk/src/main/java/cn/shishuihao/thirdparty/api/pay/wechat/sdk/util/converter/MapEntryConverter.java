package cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter;

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
    /**
     * Determines whether the converter can marshall a particular type.
     *
     * @param type the Class representing the object type to be converted
     */
    @Override
    public boolean canConvert(final Class type) {
        return Map.class.isAssignableFrom(type);
    }

    /**
     * Convert an object to textual data.
     *
     * @param source  The object to be marshalled.
     * @param writer  A stream to write to.
     * @param context A context that allows nested objects
     *                to be processed by XStream.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void marshal(final Object source,
                        final HierarchicalStreamWriter writer,
                        final MarshallingContext context) {
        Map<String, String> map = (Map<String, String>) source;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            writer.startNode(entry.getKey());
            writer.setValue(entry.getValue());
            writer.endNode();
        }
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
        Map<String, String> map = new HashMap<>(Integer.SIZE);
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            map.put(reader.getNodeName(), reader.getValue());
            reader.moveUp();
        }
        return map;
    }
}
