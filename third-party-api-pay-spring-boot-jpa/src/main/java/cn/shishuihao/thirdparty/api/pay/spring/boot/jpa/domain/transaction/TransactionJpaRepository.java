package cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain.transaction;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.Transaction;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TransactionRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.AbstractJpaRepository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class TransactionJpaRepository
        extends AbstractJpaRepository<
        String,
        Transaction,
        TransactionJpaEntity,
        TransactionEntityJpaRepository>
        implements TransactionRepository {
    /**
     * new TransactionJpaRepository.
     *
     * @param repository repository
     * @param converter  converter
     */
    public TransactionJpaRepository(
            final TransactionEntityJpaRepository repository,
            final TransactionJpaEntityConverter converter) {
        super(repository, converter);
    }

    /**
     * get entity by id.
     *
     * @param id id
     * @return Optional<TransactionJpaEntity>
     */
    @Override
    public Optional<TransactionJpaEntity> getById(final String id) {
        return this.getJpaRepository()
                .findByTransactionId(id);
    }

    /**
     * find by outTradeNo.
     *
     * @param outTradeNo outTradeNo
     * @return Optional<Transaction>
     */
    @Override
    public Optional<Transaction> getByOutTradeNo(final String outTradeNo) {
        return this.getJpaRepository()
                .findByOutTradeNo(outTradeNo)
                .map(this.getConverter()::convert);
    }
}
