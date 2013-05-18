package com.github.frankiesardo.gaagbt.framework.injection;

import com.github.frankiesardo.gaagbt.presentation.CachedPresentation;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PresentationModule {

    @Provides
    @Singleton
    CachedPresentation<SearchRepositoriesResponse> provideSearchRepositoriesResponsePresentation(Bus bus) {
        return new CachedPresentation<SearchRepositoriesResponse>(bus) {
            @Produce
            @Override
            public SearchRepositoriesResponse getCachedValue() {
                return super.getCachedValue();
            }
        };
    }

    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }
}
