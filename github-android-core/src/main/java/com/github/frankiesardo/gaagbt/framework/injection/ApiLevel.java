package com.github.frankiesardo.gaagbt.framework.injection;

public enum ApiLevel {
    MOCK(new MockGithubApiModule()),
    DEBUG(new DebugGithubApiModule()),
    PRODUCTION(new ProductionGithubApiModule());

    private final Object module;

    ApiLevel(Object module) {
        this.module = module;
    }

    public Object module() {
        return module;
    }
}
