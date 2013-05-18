package com.github.frankiesardo.gaagbt.presentation.android.controller;

import android.app.ActionBar;
import android.widget.ListView;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;
import com.github.frankiesardo.gaagbt.presentation.CachedPresentation;
import com.github.frankiesardo.gaagbt.presentation.android.adapter.RepositoriesAdapter;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;
import com.github.frankiesardo.gaagbt.scenario.ScenarioDispatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SearchRepositoriesControllerTest {

    static final String QUERY = "android";

    @Mock
    ScenarioDispatcher dispatcher;
    @Mock
    CachedPresentation<SearchRepositoriesResponse> cachedPresentation;
    @Mock
    RepositoriesAdapter adapter;
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
        verify(listView).setAdapter(adapter);
    }

    @Test
    public void enableCachingOnInit() throws Exception {
        verify(cachedPresentation).enableCaching();
    }

    @Test
    public void displayQueryInTheActionBar() throws Exception {
        controller.startNewSearch(QUERY);

        verify(actionBar).setTitle(contains(QUERY));
    }

    @Test
    public void startSearchForQuery() throws Exception {
        controller.startNewSearch(QUERY);

        verify(dispatcher).searchRepositories(same(cachedPresentation), eq(new SearchRepositoriesRequest(QUERY)));
    }

    @Test
    public void updateAdapterWithRepositories() throws Exception {
        SearchRepositoriesResponse response = mock(SearchRepositoriesResponse.class);
        Repositories result = new Repositories(Collections.<Repository>emptyList());
        when(response.getResult()).thenReturn(result);

        controller.onResponse(response);

        verify(adapter).setItems(result);
    }

    @Test
    public void disableCachingOnDispose() throws Exception {
        controller.dispose();

        verify(cachedPresentation).disableCaching();
    }
}
