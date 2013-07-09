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

public class SearchRepositoriesController {

    private final ScenarioDispatcher dispatcher;
    private final Producer<SearchRepositoriesResponse> producer;
    private final RepositoriesAdapter repositoriesAdapter;
    private final ActionBarTitleAdapter actionBarTitleAdapter;

    private ActionBar actionBar;

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
        this.actionBar = actionBar;
        listView.setAdapter(repositoriesAdapter);
        producer.enableCaching();
    }

    public void startSearch(String query) {
        updateTitle(query);
        dispatchSearch(query);
    }

    private void updateTitle(String query) {
        actionBarTitleAdapter.setSearchQuery(actionBar, query);
    }

    private void dispatchSearch(String query) {
        dispatcher.searchRepositories(producer, new SearchRepositoriesRequest(query));
    }

    @Subscribe
    public void onResponse(SearchRepositoriesResponse response) {
        repositoriesAdapter.setItems(response.getResult());
    }

    public void dispose() {
        producer.disableCaching();
    }
}