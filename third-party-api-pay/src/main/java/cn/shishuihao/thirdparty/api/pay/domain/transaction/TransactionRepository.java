package cn.shishuihao.thirdparty.api.pay.domain.transaction;

import cn.shishuihao.thirdparty.api.core.repository.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface TransactionRepository
        extends Repository<String, Transaction> {
    /**
     * get by outTradeNo.
     *
     * @param outTradeNo outTradeNo
     * @return Optional<Transaction>
     */
    Optional<Transaction> getByOutTradeNo(String outTradeNo);
}
