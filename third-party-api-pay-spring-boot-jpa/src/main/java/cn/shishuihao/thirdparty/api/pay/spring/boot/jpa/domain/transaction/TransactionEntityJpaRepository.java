package cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Repository
public interface TransactionEntityJpaRepository
        extends JpaRepository<TransactionJpaEntity, Long> {
    /**
     * find by transactionId.
     *
     * @param transactionId transactionId
     * @return Optional<TransactionJpaEntity>
     */
    Optional<TransactionJpaEntity>
    findByTransactionId(String transactionId);

    /**
     * find by outTradeNo.
     *
     * @param outTradeNo outTradeNo
     * @return Optional<Transaction>
     */
    Optional<TransactionJpaEntity>
    findByOutTradeNo(String outTradeNo);
}
