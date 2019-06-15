package net.notjustanna.libs.resources;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static net.notjustanna.libs.resources.ResourceUtils.requireNonNullElse;

class AvailableResource<T> implements Resource<T> {
    private boolean closed = false;
    private T value;

    AvailableResource(T value) {
        this.value = value;
    }

    @Nonnull
    @Override
    public State getState() {
        return closed ? State.UNAVAILABLE : State.AVAILABLE;
    }

    @Nullable
    @Override
    public T getValue() throws IllegalStateException {
        if (closed) throw new IllegalStateException("Resource is unavailable");
        return value;
    }

    @Nullable
    @Override
    public T getOrNull() {
        return value;
    }

    @Nonnull
    @Override
    public T getOrDefault(@Nonnull T defValue) {
        return requireNonNullElse(value, defValue);
    }

    @Nullable
    @Override
    public Exception getLoadException() {
        return null;
    }

    @Override
    public boolean load() {
        return !closed;
    }

    @Override
    public void close() {
        closed = true;
        value = null;
    }
}
