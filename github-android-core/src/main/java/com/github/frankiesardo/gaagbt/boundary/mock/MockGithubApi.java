package com.github.frankiesardo.gaagbt.boundary.mock;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.framework.converter.JsonConverter;
import com.github.frankiesardo.gaagbt.framework.converter.ResourceReader;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.*;

public class MockGithubApi implements GithubApi {

    private final JsonConverter jsonConverter;

    public MockGithubApi(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Override
    public Repositories searchRepositories(String keyword) {
        if (ANDROID_KEYWORD.equalsIgnoreCase(keyword)) {
            return ANDROID_REPOSITORIES;
        }
        return jsonConverter.readValue(new ResourceReader(SEARCH_REPOSITORIES_FILE_NAME), Repositories.class);
    }
}
