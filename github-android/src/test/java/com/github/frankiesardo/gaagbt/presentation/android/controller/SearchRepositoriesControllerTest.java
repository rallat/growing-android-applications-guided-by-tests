package com.github.frankiesardo.gaagbt.presentation.android.controller;

import android.app.ActionBar;
import android.widget.ListView;

import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;
import com.github.frankiesardo.gaagbt.presentation.Producer;
import com.github.frankiesardo.gaagbt.presentation.android.adapter.ActionBarTitleAdapter;
import com.github.frankiesardo.gaagbt.presentation.android.adapter.RepositoriesAdapter;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;
import com.github.frankiesardo.gaagbt.scenario.ScenarioDispatcher;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SearchRepositoriesControllerTest {

    static final String QUERY = "android";

    @Mock
    ScenarioDispatcher dispatcher;
    @Mock
    Producer<SearchRepositoriesResponse> producer;
    @Mock
    RepositoriesAdapter repositoriesAdapter;
    @Mock
    ActionBarTitleAdapter actionBarTitleAdapter;
    @InjectMocks
    SearchRepositoriesController controller;

    @Mock
    ActionBar actionBar;
    @Mock
    ListView listView;

    @Before
    public void setUp() throws Exception {
        controller.init(listView, actionBar);
    }

    @Test
    public void bindAdapterToListOnInit() throws Exception {
        verify(listView).setAdapter(repositoriesAdapter);
    }

    @Test
    public void enableCachingOnInit() throws Exception {
        verify(producer).enableCaching();
    }

    @Test
    public void displayQueryInTheActionBar() throws Exception {
        controller.startSearch(QUERY);

        verify(actionBarTitleAdapter).setSearchQuery(actionBar, QUERY);
    }

    @Test
    public void startSearchForQuery() throws Exception {
        controller.startSearch(QUERY);

        verify(dispatcher).searchRepositories(same(producer), eq(new SearchRepositoriesRequest(QUERY)));
    }

    @Test
    public void updateAdapterWithRepositories() throws Exception {
        SearchRepositoriesResponse response = mock(SearchRepositoriesResponse.class);
        Repositories result = new Repositories(Collections.<Repository>emptyList());
        when(response.getResult()).thenReturn(result);

        controller.onResponse(response);

        verify(repositoriesAdapter).setItems(result);
    }

    @Test
    public void disableCachingOnDispose() throws Exception {
        controller.dispose();

        verify(producer).disableCaching();
    }
}
