package cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain.transaction;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.Transaction;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class TransactionJpaEntityConverter
        implements AggregateRootConverter<
        String,
        Transaction,
        TransactionJpaEntity> {
    /**
     * aggregate root to entity.
     *
     * @param aggregateRoot aggregate root
     * @return entity
     */
    @Override
    public TransactionJpaEntity convert(
            final Transaction aggregateRoot) {
        TransactionJpaEntity newEntity = new TransactionJpaEntity();
        newEntity.setTransactionId(aggregateRoot.id());
        newEntity.setOutTradeNo(aggregateRoot.getOutTradeNo());
        newEntity.setAppId(aggregateRoot.getAppId());
        newEntity.setChannelId(aggregateRoot.getChannelId());
        newEntity.setTradeType(aggregateRoot.getTradeType());
        newEntity.setPayerId(aggregateRoot.getPayerId());
        newEntity.setAuthCode(aggregateRoot.getAuthCode());
        newEntity.setSubject(aggregateRoot.getSubject());
        newEntity.setCurrency(aggregateRoot.getCurrency());
        newEntity.setTotalAmount(aggregateRoot.getTotalAmount());
        return convert(newEntity, aggregateRoot);
    }

    /**
     * aggregate root to entity.
     *
     * @param entity        entity
     * @param aggregateRoot aggregate root
     * @return entity
     */
    @Override
    public TransactionJpaEntity convert(
            final TransactionJpaEntity entity,
            final Transaction aggregateRoot) {
        entity.setTradeStatus(aggregateRoot.getTradeStatus());
        entity.setChannelTransactionId(aggregateRoot
                .getChannelTransactionId());
        entity.setBankType(aggregateRoot.getBankType());
        entity.setPayCurrency(aggregateRoot.getPayCurrency());
        entity.setPayTotalAmount(aggregateRoot.getPayTotalAmount());
        entity.setSettleCurrency(aggregateRoot.getSettleCurrency());
        entity.setSettleTotalAmount(aggregateRoot.getSettleTotalAmount());
        entity.setGmtModified(LocalDateTime.now());
        return entity;
    }

    /**
     * entity to aggregate root.
     *
     * @param entity entity
     * @return aggregate root
     */
    @Override
    public Transaction convert(
            final TransactionJpaEntity entity) {
        return Transaction.builder()
                .transactionId(entity.getTransactionId())
                .outTradeNo(entity.getOutTradeNo())
                .appId(entity.getAppId())
                .channelId(entity.getChannelId())
                .tradeType(entity.getTradeType())
                .payerId(entity.getPayerId())
                .authCode(entity.getAuthCode())
                .subject(entity.getSubject())
                .currency(entity.getCurrency())
                .totalAmount(entity.getTotalAmount())
                .tradeStatus(entity.getTradeStatus())
                .channelTransactionId(entity.getChannelTransactionId())
                .bankType(entity.getBankType())
                .payCurrency(entity.getPayCurrency())
                .payTotalAmount(entity.getPayTotalAmount())
                .settleCurrency(entity.getSettleCurrency())
                .settleTotalAmount(entity.getSettleTotalAmount())
                .build();
    }
}
