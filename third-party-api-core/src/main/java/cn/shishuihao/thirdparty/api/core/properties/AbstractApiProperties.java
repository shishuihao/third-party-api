package cn.shishuihao.thirdparty.api.core.properties;

import java.util.Objects;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractApiProperties implements ApiProperties {
    /**
     * channel id
     */
    private String channelId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractApiProperties that = (AbstractApiProperties) o;
        return Objects.equals(channelId, that.channelId) && Objects.equals(id(), that.id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, id());
    }
}
