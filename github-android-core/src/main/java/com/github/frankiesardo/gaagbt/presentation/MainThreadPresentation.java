package com.github.frankiesardo.gaagbt.presentation;

import java.util.concurrent.Executor;

public class MainThreadPresentation<T> implements Presentation<T> {

    private final Executor mainThreadExecutor;
    private final Presentation<T> wrappedPresentation;

    public MainThreadPresentation(Executor mainThreadExecutor, Presentation<T> wrappedPresentation) {
        this.mainThreadExecutor = mainThreadExecutor;
        this.wrappedPresentation = wrappedPresentation;
    }

    @Override
    public final void present(final T response) {
        mainThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                wrappedPresentation.present(response);
            }
        });
    }
}
