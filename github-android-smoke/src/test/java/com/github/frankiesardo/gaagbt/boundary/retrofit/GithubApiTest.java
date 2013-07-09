package com.github.frankiesardo.gaagbt.boundary.retrofit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.framework.converter.JsonConverter;
import com.github.frankiesardo.gaagbt.framework.retrofit.RetrofitConverter;

import org.junit.Test;

import retrofit.RestAdapter;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_KEYWORD;
import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_REPOSITORIES;
import static org.fest.assertions.Assertions.assertThat;

public class GithubApiTest {

    @Test
    public void searchRepositories() throws Exception {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setServer(RetrofitGithubApi.ENDPOINT_URL)
                .setConverter(new RetrofitConverter(new JsonConverter(new ObjectMapper(), new SimpleModule())))
                .setDebug(true)
                .build();
        GithubApi apiService = restAdapter.create(RetrofitGithubApi.class);
        Repositories repositories = apiService.searchRepositories(ANDROID_KEYWORD);
        assertThat(repositories).contains(ANDROID_REPOSITORIES.toArray());
    }
}
