package com.github.frankiesardo.gaagbt.presentation.android.controller;

import com.squareup.otto.Bus;

public class BaseController {

    public void startWatchingBus(Bus bus) {
        bus.register(this);
    }

    public void stopWatchingBus(Bus bus) {
        bus.unregister(this);
    }
}
