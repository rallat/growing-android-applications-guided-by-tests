package com.github.frankiesardo.gaagbt.scenario;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.presentation.MainThreadPresentation;
import com.github.frankiesardo.gaagbt.presentation.Presentation;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;

import java.util.concurrent.Executor;

public class ScenarioFactory {

    private final Executor mainThreadExecutor;
    private final Executor backgroundThreadExecutor;
    private final GithubApi githubApi;

    public ScenarioFactory(Executor mainThreadExecutor, Executor backgroundThreadExecutor, GithubApi githubApi) {
        this.mainThreadExecutor = mainThreadExecutor;
        this.backgroundThreadExecutor = backgroundThreadExecutor;
        this.githubApi = githubApi;
    }

    public Scenario searchRepositories(Presentation<SearchRepositoriesResponse> presentation, SearchRepositoriesRequest request) {
        return wrap(new SearchRepositoriesScenario(wrap(presentation), githubApi, request));
    }

    private <T> Presentation<T> wrap(Presentation<T> presentation) {
        return new MainThreadPresentation<T>(mainThreadExecutor, presentation);
    }

    private Scenario wrap(Scenario scenario) {
        return new BackgroundThreadScenario(backgroundThreadExecutor, scenario);
    }
}
