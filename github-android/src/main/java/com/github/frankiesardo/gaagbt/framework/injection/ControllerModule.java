package com.github.frankiesardo.gaagbt.framework.injection;

import com.github.frankiesardo.gaagbt.presentation.CachedPresentation;
import com.github.frankiesardo.gaagbt.presentation.android.adapter.RepositoriesAdapter;
import com.github.frankiesardo.gaagbt.presentation.android.controller.SearchRepositoriesController;
import com.github.frankiesardo.gaagbt.response.SearchRepositoriesResponse;
import com.github.frankiesardo.gaagbt.scenario.ScenarioDispatcher;
import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {

    @Provides
    SearchRepositoriesController provideSearchRepositoriesController(ScenarioDispatcher dispatcher, CachedPresentation<SearchRepositoriesResponse> presentation) {
        return new SearchRepositoriesController(dispatcher, presentation, new RepositoriesAdapter());
    }
}
