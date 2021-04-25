package cn.shishuihao.thirdparty.api.pay.ccb.sdk;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.DefaultCcbWlptProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DefaultCcbProperties
        extends DefaultCcbWlptProperties
        implements CcbProperties {
    /**
     * 商户公钥.
     */
    private String publicKey;
    /**
     * 柜台号 9 Y.
     * 请联系开立商户的分行提供.
     */
    private String posId;
    /**
     * 分行号 9 Y.
     * 请联系开立商户的分行提供（一级分行号）.
     */
    private String branchId;
    /**
     * 集团商户信息 40 N （非集团商户无需上送）.
     * 集团主商户代理发起子商户交易时（验证主商户柜台公钥），需将集团主商户信息填入该字段，
     * 格式为：JTSH:主商户号+主商户柜台+主商户分行号
     * 例如：JTSH:105000000000000123456789441000000
     * 其中：
     * 105000000000000为主商户号，
     * 123456789为主商户柜台号，
     * 441000000 为主商户一级分行号.
     */
    private String groupMch;
    /**
     * 商户类型 1 Y.
     * 1：线上商户
     * 2：线下商户
     * 商户类型请与分行确认.
     */
    private Integer merchantFlag;
    /**
     * 终端编号1 19 N 商户类型为2时上送.
     * 请联系开立商户的分行提供
     */
    private String termNo1;
    /**
     * 终端编号 2 8 N 商户类型为2时上送.
     * 请联系开立商户的分行提供
     */
    private String termNo2;
    /**
     * 商品名称 128 N.
     * 当 RETURN_FIELD 字段第三位上送 1 时，该字段将展示在客户微信/支付宝账单的商品名称字段，
     * 按微信文档要求1个中文算3个字节，1个英文或数字算1个字节，请注意不要超长。
     */
    private String productInfo;
    /**
     * 返回信息位图 20 N.
     * 共20位，位图，0 或空-不返回，1-返回。
     * 第 1 位：是否返回OPENID和SUB_OPENID
     * 第 2 位：是否返回优惠金额相关字段
     * 第 3 位：是否将“商品名称PROINFO”的值上送支付宝/微信，以便展示在客户的支付宝/微信账单中
     * 1：上送
     * 0或空：不上送
     * 第 4 位：是否返回支付详细信息字段
     * 第 5 位：是否返回微信优惠详情字段
     */
    private String returnField;
}
