package gg.nextforge.bytestorm.common.functional;

import java.util.function.Supplier;

public record Try<T>(T value, Throwable error) {
    public static <T> Try<T> of(Supplier<T> s) {
        try {
            return new Try<>(s.get(), null);
        } catch (Throwable t) {
            return new Try<>(null, t);
        }
    }

    public boolean isSuccess() {
        return error == null && value != null;
    }

    public boolean isFailure() {
        return error != null;
    }

    public T getOrThrow() throws Throwable {
        if (isFailure()) {
            throw error;
        }
        return value;
    }

    public T getOrElse(T other) {
        return isSuccess() ? value : other;
    }

    public T getOrElseGet(Supplier<T> other) {
        return isSuccess() ? value : other.get();
    }
}
