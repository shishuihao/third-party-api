package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@XStreamAlias("xml")
public class WxPaySecApiPayReverseResponse extends AbstractWxPayXmlResponse {
    /**
     * 是否重调.
     */
    @WxParameter(
            name = "是否重调",
            required = true, type = "String(1)",
            example = "Y",
            desc = "是否需要继续调用撤销，Y-需要，N-不需要")
    @XStreamAlias("recall")
    private String recall;
}
