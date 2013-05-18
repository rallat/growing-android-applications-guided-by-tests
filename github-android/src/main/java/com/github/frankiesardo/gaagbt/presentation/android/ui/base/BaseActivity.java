package com.github.frankiesardo.gaagbt.presentation.android.ui.base;

import android.app.Activity;
import android.os.Bundle;

import com.github.frankiesardo.gaagbt.framework.injection.InjectingApplication;
import com.github.frankiesardo.gaagbt.presentation.android.controller.BaseController;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public abstract class BaseActivity extends Activity {

    @Inject
    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((InjectingApplication) getApplication()).inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getController().startWatchingBus(bus);
    }

    @Override
    protected void onPause() {
        super.onResume();
        getController().stopWatchingBus(bus);
    }

    protected abstract BaseController getController();
}
