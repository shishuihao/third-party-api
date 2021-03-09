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
@Repeatable(value = WxParameters.class)
public @interface WxParameter {
    /**
     * 环境.
     *
     * @return String
     */
    String environment() default "";

    /**
     * 名称.
     *
     * @return String
     */
    String name();

    /**
     * 必填.
     *
     * @return String
     */
    boolean required();

    /**
     * 类型.
     *
     * @return String
     */
    String type();

    /**
     * 示例值.
     *
     * @return String
     */
    String example();

    /**
     * 描述.
     *
     * @return String
     */
    String desc();
}
