package com.github.frankiesardo.gaagbt.scenario;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.presentation.Presentation;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchRepositoriesScenarioTest {

    static final String KEYWORD = "android";
    static final Repositories ANDROID_REPOSITORIES = new Repositories(Collections.EMPTY_LIST);

    @Mock
    Presentation<SearchRepositoriesResponse> presentation;
    @Mock
    GithubApi githubApi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void notifyThePresentationWIthTheRetrievedRepositories() throws Exception {
        SearchRepositoriesScenario scenario = new SearchRepositoriesScenario(presentation, githubApi, new SearchRepositoriesRequest(KEYWORD));
        SearchRepositoriesResponse response = new SearchRepositoriesResponse(ANDROID_REPOSITORIES);
        when(githubApi.searchRepositories(KEYWORD)).thenReturn(ANDROID_REPOSITORIES);

        scenario.run();

        verify(presentation).present(eq(response));
    }
}
