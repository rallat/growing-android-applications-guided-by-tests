package com.github.frankiesardo.gaagbt.presentation.android.adapter;

import android.app.ActionBar;

import com.github.frankiesardo.gaagbt.R;

public class ActionBarTitleAdapter {

    private ActionBar actionBar;

    public void setActionBar(ActionBar actionBar) {
        this.actionBar = actionBar;
    }

    public void setSearchQuery(String query) {
        if (actionBar == null) {
            return;
        }
        actionBar.setTitle("\"" + query + "\"");
        actionBar.setSubtitle(R.string.search_results);
    }
}
