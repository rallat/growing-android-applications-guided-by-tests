package com.github.frankiesardo.gaagbt.scenario;

import java.util.concurrent.Executor;

public class BackgroundThreadScenario implements Scenario {

    private final Executor backgroundExecutor;
    private final Scenario scenario;

    public BackgroundThreadScenario(Executor backgroundExecutor, Scenario scenario) {
        this.backgroundExecutor = backgroundExecutor;
        this.scenario = scenario;
    }

    @Override
    public void run() {
        backgroundExecutor.execute(scenario);
    }
}
