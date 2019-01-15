package me.destro.java.toolkit.functional;

import java.util.Objects;

public final class PredicateUtilities {
    private PredicateUtilities(){}

    static <T> Predicate<T> and(final Predicate<? super T> p1, final Predicate<? super T> p2) {
        Objects.requireNonNull(p1);

        return new Predicate<T>() {
            @Override
            public boolean test(T var1) {
                return p1.test(var1) && p2.test(var1);
            }
        };
    }

    static <T> Predicate<T> negate(final Predicate<? super T> p1) {
        return new Predicate<T>() {
            @Override
            public boolean test(T var1) {
                return !p1.test(var1);
            }
        };
    }

    static <T> Predicate<T> or(final Predicate<? super T> p1, final Predicate<? super T> p2) {
        Objects.requireNonNull(p1);

        return new Predicate<T>() {
            @Override
            public boolean test(T var1) {
                return p1.test(var1) || p2.test(var1);
            }
        };
    }

    static <T> Predicate<T> isEqual(final Object var0) {
        return null == var0 ? new Predicate<T>() {
            @Override
            public boolean test(T var1) {
                return var1 == null;
            }
        } : new Predicate<T>() {
            @Override
            public boolean test(T var1) {
                return var0.equals(var1);
            }
        };
    }
}
