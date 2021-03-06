package cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * 应用ID
 * 直连商户申请的公众号或移动应用id。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@XStreamAlias("appid")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = {"id"})
public class AppId {
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 32;
    /**
     * 应用ID
     */
    private final String id;

    public AppId(String appId) {
        if (appId == null) {
            throw new IllegalArgumentException("appId不能为空");
        }
        if (appId.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("appId长度最小" + MIN_LENGTH);
        }
        if (appId.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("appId长度最大" + MAX_LENGTH);
        }
        this.id = appId;
    }

    public static AppId of(String id) {
        return new AppId(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
