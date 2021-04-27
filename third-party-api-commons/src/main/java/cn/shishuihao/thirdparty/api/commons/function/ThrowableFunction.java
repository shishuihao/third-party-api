package cn.shishuihao.thirdparty.api.commons.function;

/**
 * Represents a function that accepts one argument and produces a result.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object)}.
 * {@link java.util.function.Function}.
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 * @param <E> the throwable
 * @author shishuihao
 */
@FunctionalInterface
public interface ThrowableFunction<T, R, E extends Throwable> {
    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     * @throws E the throwable
     */
    R apply(T t) throws E;
}
