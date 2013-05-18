package com.github.frankiesardo.gaagbt.presentation.android.controller;

import android.app.ActionBar;
import android.widget.ListView;

import com.github.frankiesardo.gaagbt.presentation.Producer;
import com.github.frankiesardo.gaagbt.presentation.android.adapter.ActionBarTitleAdapter;
import com.github.frankiesardo.gaagbt.presentation.android.adapter.RepositoriesAdapter;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;
import com.github.frankiesardo.gaagbt.scenario.ScenarioDispatcher;
import com.squareup.otto.Subscribe;

public class SearchRepositoriesController extends BaseController {

    private final ScenarioDispatcher dispatcher;
    private final Producer<SearchRepositoriesResponse> producer;
    private final RepositoriesAdapter repositoriesAdapter;
    private final ActionBarTitleAdapter actionBarTitleAdapter;

    public SearchRepositoriesController(ScenarioDispatcher dispatcher,
                                        Producer<SearchRepositoriesResponse> producer,
                                        RepositoriesAdapter repositoriesAdapter,
                                        ActionBarTitleAdapter actionBarTitleAdapter) {
        this.dispatcher = dispatcher;
        this.producer = producer;
        this.repositoriesAdapter = repositoriesAdapter;
        this.actionBarTitleAdapter = actionBarTitleAdapter;
    }

    public void init(ListView listView, ActionBar actionBar) {
        listView.setAdapter(repositoriesAdapter);
        actionBarTitleAdapter.setActionBar(actionBar);
        producer.enableCaching();
    }

    public void startSearch(String query) {
        updateTitle(query);
        dispatchSearch(new SearchRepositoriesRequest(query));
    }

    private void updateTitle(String query) {
        actionBarTitleAdapter.setSearchQuery(query);
    }

    private void dispatchSearch(SearchRepositoriesRequest request) {
        if (producer.hasCachedValue() && producer.getCachedValue().isFrom(request)) {
            return;
        }
        clearCurrentItems();
        dispatcher.searchRepositories(producer, request);
    }

    private void clearCurrentItems() {
        repositoriesAdapter.clearItems();
        producer.clearCache();
    }

    @Subscribe
    public void onResponse(SearchRepositoriesResponse response) {
        repositoriesAdapter.setItems(response.getResult());
    }

    public void dispose() {
        producer.disableCaching();
    }
}