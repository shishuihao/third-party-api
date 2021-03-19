package cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation;

import java.lang.annotation.*;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface WxParameters {
    /**
     * 多环境.
     *
     * @return WxParameter[]
     */
    WxParameter[] value();
}
