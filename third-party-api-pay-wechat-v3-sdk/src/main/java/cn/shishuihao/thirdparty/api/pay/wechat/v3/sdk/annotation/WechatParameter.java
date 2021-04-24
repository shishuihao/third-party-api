package cn.shishuihao.thirdparty.api.pay.wechat.v3.sdk.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(value = WechatParameters.class)
public @interface WechatParameter {

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
     * 必选.
     *
     * @return String[]
     */
    String[] requiredIn() default {};

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
