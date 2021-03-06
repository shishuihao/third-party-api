package cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * 商户号
 * 直连商户的商户号，由微信支付生成并下发。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@XStreamAlias("mch_id")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = {"id"})
public class MchId {
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 32;

    private final String id;

    public MchId(String mchId) {
        if (mchId == null) {
            throw new IllegalArgumentException("mchId不能为空");
        }
        if (mchId.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("mchId长度最小" + MIN_LENGTH);
        }
        if (mchId.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("mchId长度最大" + MAX_LENGTH);
        }
        this.id = mchId;
    }

    public static MchId of(String id) {
        return new MchId(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
