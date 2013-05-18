package com.github.frankiesardo.gaagbt.presentation.android.ui.base;

import android.app.Activity;
import android.os.Bundle;

import com.github.frankiesardo.gaagbt.framework.injection.InjectingApplication;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((InjectingApplication) getApplication()).inject(this);
    }
}
