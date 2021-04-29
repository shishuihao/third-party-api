package cn.shishuihao.thirdparty.api.pay.jdpay.sdk.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * 商品信息.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Getter
public class GoodsInfo {
    /**
     * 商品编号 id String(30) 是.
     * 商品编号
     */
    private final String id;
    /**
     * 商品名称 name String(100) 是.
     */
    private final String name;
    /**
     * 商品一级类目 cat1 String(10) 否.
     */
    private final String cat1;
    /**
     * 商品二级类目 cat2 String(10) 否.
     */
    private final String cat2;
    /**
     * 商品三级类目 cat3 String(10) 否.
     */
    private final String cat3;
    /**
     * 商品类型 type String(20) 否.
     * GT01:实物,
     * GT02:虚拟
     */
    private final String type;
    /**
     * 商品单价 price Long 是.
     * 单位：分
     */
    private final Long price;
    /**
     * 商品数量 num Integer 是.
     */
    private final Integer num;
}
