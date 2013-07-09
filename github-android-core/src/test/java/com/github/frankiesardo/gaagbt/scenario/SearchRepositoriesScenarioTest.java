package com.github.frankiesardo.gaagbt.scenario;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.presentation.Presentation;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_KEYWORD;
import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_REPOSITORIES;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchRepositoriesScenarioTest {

    @Mock
    Presentation<SearchRepositoriesResponse> presentation;
    @Mock
    GithubApi githubApi;

    @Test
    public void notifyThePresentationWIthTheRetrievedRepositories() throws Exception {
        SearchRepositoriesRequest request = new SearchRepositoriesRequest(ANDROID_KEYWORD);
        SearchRepositoriesScenario scenario = new SearchRepositoriesScenario(presentation, githubApi, request);
        SearchRepositoriesResponse response = new SearchRepositoriesResponse(ANDROID_REPOSITORIES, request);
        when(githubApi.searchRepositories(ANDROID_KEYWORD)).thenReturn(ANDROID_REPOSITORIES);

        scenario.run();

        verify(presentation).present(eq(response));
    }
}
