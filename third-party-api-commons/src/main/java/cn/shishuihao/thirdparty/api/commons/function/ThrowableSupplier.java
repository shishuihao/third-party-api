package cn.shishuihao.thirdparty.api.commons.function;

/**
 * Represents a supplier of results.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 * {@link java.util.function.Supplier}.
 *
 * @param <T> the type of results supplied by this supplier
 * @param <E> the function throwable
 * @author shishuihao
 */
@FunctionalInterface
public interface ThrowableSupplier<T, E extends Throwable> {
    /**
     * Gets a result.
     *
     * @return a result
     * @throws E the throwable
     */
    T get() throws E;
}
