package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;

import java.util.List;

/**
 * @param <P> api properties
 * @author shishuihao
 * @version 1.0.0
 */

public interface ApiChannelProperties<
        P extends ApiProperties>
        extends AggregateRoot<String> {
    /**
     * get channel id.
     *
     * @return channel id
     */
    String channelId();

    /**
     * get properties list.
     *
     * @return properties list
     */
    List<P> getPropertiesList();

    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    default String id() {
        return this.channelId();
    }
}
