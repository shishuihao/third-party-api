package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <P> api properties
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
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
}
