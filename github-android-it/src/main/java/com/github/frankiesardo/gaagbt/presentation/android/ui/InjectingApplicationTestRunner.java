package com.github.frankiesardo.gaagbt.presentation.android.ui;

import android.app.Application;
import android.content.Context;
import android.test.InstrumentationTestRunner;

import com.github.frankiesardo.gaagbt.framework.injection.ApiLevel;
import com.github.frankiesardo.gaagbt.framework.injection.InjectingApplication;

public class InjectingApplicationTestRunner extends InstrumentationTestRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return new InjectingApplication() {
            @Override
            protected ApiLevel getApiLevel() {
                return ApiLevel.MOCK;
            }
        };
    }
}
