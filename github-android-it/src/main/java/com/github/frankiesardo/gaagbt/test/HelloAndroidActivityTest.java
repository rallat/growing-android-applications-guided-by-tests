package com.github.frankiesardo.gaagbt.test;

import android.test.ActivityInstrumentationTestCase2;

import com.github.frankiesardo.gaagbt.HelloAndroidActivity;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super(HelloAndroidActivity.class);
    }

    public void testActivity() {
        HelloAndroidActivity activity = getActivity();
        assertNotNull(activity);
    }
}

