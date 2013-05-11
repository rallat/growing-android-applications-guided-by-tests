package com.github.frankiesardo.gaagbt.presentation;

import java.util.concurrent.Executor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class MainThreadPresentationTest {

    @Mock
    Executor mainThreadExecutor;
    @Mock
    Presentation<Object> wrappedPresentation;
    @InjectMocks
    MainThreadPresentation<Object> presentation;

    @Test
    public void runPresentOnMainExecutor() throws Exception {
        ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
        Object response = new Object();

        presentation.present(response);

        verify(mainThreadExecutor).execute(captor.capture());
        verifyZeroInteractions(wrappedPresentation);

        captor.getValue().run();
        verify(wrappedPresentation).present(response);
    }
}
