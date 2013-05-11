package com.github.frankiesardo.gaagbt.test;

import android.test.ActivityInstrumentationTestCase2;

import com.github.frankiesardo.gaagbt.R;
import com.github.frankiesardo.gaagbt.SearchRepositoriesActivity;
import com.jayway.android.robotium.solo.Solo;

public class SearchRepositoriesActivityTest extends ActivityInstrumentationTestCase2<SearchRepositoriesActivity> {

    private static final String KEYWORD = "android";
    private static final String[] ANDROID_REPOSITORIES = {
            "GitHub Android App",
            "Examples of Android applications",
            "Facebook SDK for Android",
            "Android Action Bar Implementation",
            "A horizontal view scroller library for Android",
            "An Asynchronous HTTP Library for Android"
    };

    Solo solo;

    public SearchRepositoriesActivityTest() {
        super(SearchRepositoriesActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testDisplayRepositoriesDescription() throws Exception {
        solo.clickOnActionBarItem(R.id.menu_search);
        solo.enterText(0, KEYWORD);
        solo.sendKey(Solo.ENTER);
        for (String repository : ANDROID_REPOSITORIES) {
            assertTrue(solo.waitForText(repository));
        }
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }
}

