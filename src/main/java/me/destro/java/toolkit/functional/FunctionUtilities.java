package me.destro.java.toolkit.functional;

import java.util.Objects;

public final class FunctionUtilities {

    public <V, T, R> Function<V, R> compose(final Function<? super T, ? extends R> f, final Function<? super V, ? extends T> g) {
        Objects.requireNonNull(g);
        Objects.requireNonNull(f);

        return new Function<V, R>() {
            @Override
            public R apply(V var1) {
                return f.apply(g.apply(var1));
            }
        };
    }

    static <T> Function<T, T> identity() {
        return new Function<T, T>() {
            @Override
            public T apply(T var1) {
                return var1;
            }
        };
    }
}