package com.github.frankiesardo.gaagbt.presentation.android.controller;

import android.app.ActionBar;
import android.widget.ListView;
import com.github.frankiesardo.gaagbt.R;
import com.github.frankiesardo.gaagbt.presentation.CachedPresentation;
import com.github.frankiesardo.gaagbt.presentation.android.adapter.RepositoriesAdapter;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;
import com.github.frankiesardo.gaagbt.scenario.ScenarioDispatcher;
import com.squareup.otto.Subscribe;

public class SearchRepositoriesController extends BaseController {

    private final ScenarioDispatcher dispatcher;
    private final CachedPresentation<SearchRepositoriesResponse> cachedPresentation;
    private final RepositoriesAdapter adapter;

    private ActionBar actionBar;

    public SearchRepositoriesController(ScenarioDispatcher dispatcher,
                                        CachedPresentation<SearchRepositoriesResponse> cachedPresentation,
                                        RepositoriesAdapter adapter) {
        this.dispatcher = dispatcher;
        this.cachedPresentation = cachedPresentation;
        this.adapter = adapter;
    }

    public void init(ListView listView, ActionBar actionBar) {
        this.actionBar = actionBar;
        listView.setAdapter(adapter);
        cachedPresentation.enableCaching();
    }

    public void startNewSearch(String query) {
        updateTitle(query);
        clearCurrentItems();
        dispatchSearch(query);
    }

    public void restorePreviousSearch(String query) {
        updateTitle(query);
        if (!cachedPresentation.hasCachedValue()) {
            dispatchSearch(query);
        }
    }

    private void updateTitle(String query) {
        actionBar.setTitle("\"" + query + "\"");
        actionBar.setSubtitle(R.string.search_results);
    }

    private void clearCurrentItems() {
        adapter.clearItems();
        cachedPresentation.clearCache();
    }

    private void dispatchSearch(String query) {
        dispatcher.searchRepositories(cachedPresentation, new SearchRepositoriesRequest(query));
    }

    @Subscribe
    public void onResponse(SearchRepositoriesResponse response) {
        adapter.setItems(response.getResult());
    }

    public void dispose() {
        cachedPresentation.disableCaching();
    }
}