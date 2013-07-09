package com.github.frankiesardo.gaagbt.presentation.android.adapter;

import android.app.ActionBar;

import com.github.frankiesardo.gaagbt.R;

public class ActionBarTitleAdapter {

    public void setSearchQuery(ActionBar actionBar, String query) {
        actionBar.setTitle("\"" + query + "\"");
        actionBar.setSubtitle(R.string.search_results);
    }
}
