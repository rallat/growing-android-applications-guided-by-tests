package com.github.frankiesardo.gaagbt.scenario;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.presentation.Presentation;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;

public class SearchRepositoriesScenario implements Scenario {

    private final Presentation<SearchRepositoriesResponse> presentation;
    private final GithubApi githubApi;
    private final SearchRepositoriesRequest request;

    public SearchRepositoriesScenario(Presentation<SearchRepositoriesResponse> presentation, GithubApi githubApi, SearchRepositoriesRequest request) {
        this.presentation = presentation;
        this.githubApi = githubApi;
        this.request = request;
    }

    @Override
    public void run() {
        String keyword = request.getKeyword();
        Repositories repositories = githubApi.searchRepositories(keyword);
        SearchRepositoriesResponse response = new SearchRepositoriesResponse(repositories, request);
        presentation.present(response);
    }
}
