package com.github.frankiesardo.gaagbt.presentation.android.ui;

import android.test.ActivityInstrumentationTestCase2;
import com.github.frankiesardo.gaagbt.R;
import com.github.frankiesardo.gaagbt.entity.Repository;
import com.jayway.android.robotium.solo.Solo;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_KEYWORD;
import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_REPOSITORIES;

public class SearchRepositoriesActivityTest extends ActivityInstrumentationTestCase2<SearchRepositoriesActivity> {

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
        solo.enterText(0, ANDROID_KEYWORD);
        solo.sendKey(Solo.ENTER);
        for (Repository repository : ANDROID_REPOSITORIES) {
            assertTrue(solo.waitForText(repository.getDescription()));
        }
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }
}

