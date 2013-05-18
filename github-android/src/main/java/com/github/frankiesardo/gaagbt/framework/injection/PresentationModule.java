package com.github.frankiesardo.gaagbt.framework.injection;

import com.github.frankiesardo.gaagbt.presentation.Producer;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    @Singleton
    Producer<SearchRepositoriesResponse> provideSearchRepositoriesResponseProducer(Bus bus) {
        return new Producer<SearchRepositoriesResponse>(bus) {
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
