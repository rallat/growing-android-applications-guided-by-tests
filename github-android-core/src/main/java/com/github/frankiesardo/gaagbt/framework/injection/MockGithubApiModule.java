package com.github.frankiesardo.gaagbt.framework.injection;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.boundary.mock.MockGithubApi;
import com.github.frankiesardo.gaagbt.framework.converter.JsonConverter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ConverterModule.class)
public class MockGithubApiModule {
    @Provides
    @Singleton
    GithubApi provideGithubApi(JsonConverter converter) {
        return new MockGithubApi(converter);
    }
}
