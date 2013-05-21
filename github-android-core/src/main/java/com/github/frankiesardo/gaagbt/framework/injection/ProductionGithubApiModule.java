package com.github.frankiesardo.gaagbt.framework.injection;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.boundary.retrofit.RetrofitGithubApi;
import com.github.frankiesardo.gaagbt.framework.converter.JsonConverter;
import com.github.frankiesardo.gaagbt.framework.retrofit.RetrofitConverter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module(includes = ConverterModule.class)
public class ProductionGithubApiModule {

    @Provides
    @Singleton
    GithubApi provideGithubApi(JsonConverter converter) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setServer(RetrofitGithubApi.ENDPOINT_URL)
                .setConverter(new RetrofitConverter(converter))
                .build();
        return restAdapter.create(RetrofitGithubApi.class);
    }
}
