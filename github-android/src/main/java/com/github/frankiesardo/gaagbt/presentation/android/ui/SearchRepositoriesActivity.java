package com.github.frankiesardo.gaagbt.presentation.android.ui;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SearchView;

import com.github.frankiesardo.gaagbt.R;
import com.github.frankiesardo.gaagbt.presentation.android.controller.BaseController;
import com.github.frankiesardo.gaagbt.presentation.android.controller.SearchRepositoriesController;
import com.github.frankiesardo.gaagbt.presentation.android.ui.base.BaseActivity;

import javax.inject.Inject;

public class SearchRepositoriesActivity extends BaseActivity {

    @Inject
    SearchRepositoriesController controller;

    @Override
    protected BaseController getController() {
        return controller;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        controller.init((ListView) findViewById(R.id.list), getActionBar());

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            controller.startSearch(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            controller.dispose();
        }
    }
}

