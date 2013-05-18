package com.github.frankiesardo.gaagbt.presentation;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;

public class Producer<T> implements Presentation<T> {

    private final Bus bus;
    private T cachedValue;
    private boolean enabled;

    public Producer(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void present(T response) {
        cachedValue = response;
        bus.post(getCachedValue());
    }

    @Produce
    public T getCachedValue() {
        return cachedValue;
    }

    public void enableCaching() {
        if (enabled) {
            return;
        }
        bus.register(this);
        enabled = true;
    }

    public void disableCaching() {
        if (!enabled) {
            return;
        }
        bus.unregister(this);
        clearCache();
        enabled = false;
    }

    public void clearCache() {
        cachedValue = null;
    }

    public boolean hasCachedValue() {
        return cachedValue != null;
    }
}
