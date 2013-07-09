package com.github.frankiesardo.gaagbt.boundary.retrofit;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.entity.Repositories;

import retrofit.http.GET;
import retrofit.http.Path;

public interface RetrofitGithubApi extends GithubApi {
    String ENDPOINT_URL = "https://api.github.com";

    @Override
    @GET("/legacy/repos/search/{keyword}")
    Repositories searchRepositories(@Path("keyword") String keyword);
}
