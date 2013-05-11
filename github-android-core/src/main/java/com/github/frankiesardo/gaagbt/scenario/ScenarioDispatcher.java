package com.github.frankiesardo.gaagbt.scenario;

import com.github.frankiesardo.gaagbt.presentation.Presentation;
import com.github.frankiesardo.gaagbt.request.SearchRepositoriesRequest;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;

public class ScenarioDispatcher {

    private final ScenarioFactory scenarioFactory;

    public ScenarioDispatcher(ScenarioFactory scenarioFactory) {
        this.scenarioFactory = scenarioFactory;
    }

    public void searchRepositories(Presentation<SearchRepositoriesResponse> presentation, SearchRepositoriesRequest request) {
        scenarioFactory.searchRepositories(presentation, request).run();
    }
}
