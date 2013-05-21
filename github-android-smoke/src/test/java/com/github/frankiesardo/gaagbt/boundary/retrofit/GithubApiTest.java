package com.github.frankiesardo.gaagbt.boundary.retrofit;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.framework.injection.ApiLevel;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import dagger.Module;
import dagger.ObjectGraph;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_KEYWORD;
import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_REPOSITORIES;
import static org.fest.assertions.Assertions.assertThat;

public class GithubApiTest {

    @Inject
    GithubApi githubApi;

    @Module(entryPoints = GithubApiTest.class)
    static class TestModule {
    }

    @Before
    public void setUp() throws Exception {
        ObjectGraph.create(new TestModule(), ApiLevel.DEBUG.module()).inject(this);
    }

    @Test
    public void searchRepositories() throws Exception {
        Repositories repositories = githubApi.searchRepositories(ANDROID_KEYWORD);
        assertThat(repositories).contains(ANDROID_REPOSITORIES.toArray());
    }
}

