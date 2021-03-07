package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <P> api properties
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractApiChannelProperties<
        P extends ApiProperties>
        implements ApiChannelProperties<P> {

    /**
     * channel id.
     */
    private String channelId;
    /**
     * properties list.
     */
    private List<P> propertiesList = new ArrayList<>();

    /**
     * get channel id.
     *
     * @return channel id
     */
    @Override
    public String channelId() {
        return channelId;
    }

    /**
     * get channel id.
     *
     * @return channel id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * set channel id.
     *
     * @param sChannelId channel id
     */
    public void setChannelId(final String sChannelId) {
        this.channelId = sChannelId;
    }

    /**
     * get properties list.
     *
     * @return properties list
     */
    @Override
    public List<P> getPropertiesList() {
        return propertiesList;
    }

    /**
     * set properties list.
     *
     * @param sPropertiesList properties list
     */
    public void setPropertiesList(final List<P> sPropertiesList) {
        this.propertiesList = sPropertiesList;
    }
}
