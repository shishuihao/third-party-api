package cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain.transaction;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeType;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@Table(name = TransactionJpaEntity.TABLE_NAME)
@Entity
public class TransactionJpaEntity extends BaseJpaEntity {
    /**
     * table name api_pay_transaction.
     */
    public static final String TABLE_NAME = "`api_pay_transaction`";
    /**
     * transaction id.
     */
    @Column(nullable = false, unique = true)
    private String transactionId;
    /**
     * out trade no.
     */
    @Column(nullable = false, unique = true)
    private String outTradeNo;
    /**
     * app id.
     */
    @Column(nullable = false)
    private String appId;
    /**
     * channel id.
     */
    @Column(nullable = false)
    private String channelId;
    /**
     * trade type.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeType tradeType;
    /**
     * auth code.
     * such as qrcode.
     */
    @Column
    private String payerId;
    /**
     * auth code.
     * such as qrcode.
     */
    @Column
    private String authCode;
    /**
     * subject.
     */
    @Column(nullable = false)
    private String subject;
    /**
     * currency.
     */
    @Column(nullable = false)
    private String currency;
    /**
     * total amount.
     */
    @Column(nullable = false)
    private int totalAmount;
    /**
     * trade status.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeStatus tradeStatus;
    /**
     * channel transaction id.
     */
    @Column
    private String channelTransactionId;
    /**
     * 付款银行.
     */
    @Column
    private String bankType;
    /**
     * 支付币种.
     */
    @Column
    private String payCurrency;
    /**
     * 支付总金额.
     */
    @Column
    private Integer payTotalAmount;
    /**
     * 结算币种.
     */
    @Column
    private String settleCurrency;
    /**
     * 结算总金额.
     */
    @Column
    private Integer settleTotalAmount;
}
