package com.github.frankiesardo.gaagbt.presentation;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;

public class CachedPresentation<T> implements Presentation<T> {

    private final Bus bus;
    private T cachedValue;
    private boolean isEnabled;

    public CachedPresentation(Bus bus) {
        this.bus = bus;
        bus.register(this);
    }

    @Override
    public void present(T response) {
        if (!isEnabled) {
            return;
        }
        cachedValue = response;
        bus.post(getCachedValue());
    }

    @Produce
    public T getCachedValue() {
        return cachedValue;
    }

    public void clearCache() {
        cachedValue = null;
    }

    public void disableCaching() {
        isEnabled = false;
        clearCache();
    }

    public void enableCaching() {
        isEnabled = true;
    }

    public boolean hasCachedValue() {
        return cachedValue != null;
    }
}
