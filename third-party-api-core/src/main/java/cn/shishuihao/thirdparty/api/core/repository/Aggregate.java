package cn.shishuihao.thirdparty.api.core.repository;

/**
 * @param <I> id
 * @author shishuihao
 * @version 1.0.0
 */
public interface Aggregate<I> {
    /**
     * get entity id.
     *
     * @return entity id
     */
    I id();
}
