package com.github.frankiesardo.gaagbt.framework.injection;

import android.os.Handler;
import android.os.Looper;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.scenario.ScenarioDispatcher;
import com.github.frankiesardo.gaagbt.scenario.ScenarioFactory;

import javax.inject.Singleton;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import dagger.Module;
import dagger.Provides;

import static android.os.Process.THREAD_PRIORITY_BACKGROUND;

@Module(complete = false)
public class ScenarioModule {

    @Provides
    @Singleton
    ScenarioDispatcher provideScenarioDispatcher(ScenarioFactory factory) {
        return new ScenarioDispatcher(factory);
    }

    @Provides
    @Singleton
    ScenarioFactory provideScenarioFactory(GithubApi githubApi) {
        return new ScenarioFactory(makeCallbackExecutor(), makeBackgroundExecutor(), githubApi);
    }

    private Executor makeCallbackExecutor() {
        return new Executor() {
            private final Handler handler = new Handler(Looper.getMainLooper());

            @Override
            public void execute(Runnable r) {
                handler.post(r);
            }
        };
    }

    private Executor makeBackgroundExecutor() {
        return Executors.newCachedThreadPool(new ThreadFactory() {
            private final AtomicInteger threadCounter = new AtomicInteger();

            @Override
            public Thread newThread(final Runnable r) {
                return new Thread(new Runnable() {
                    @Override
                    public void run() {
                        android.os.Process.setThreadPriority(THREAD_PRIORITY_BACKGROUND);
                        r.run();
                    }
                }, "Scenario-" + threadCounter.getAndIncrement());
            }
        });
    }
}
