package com.github.frankiesardo.gaagbt.scenario;

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
public class BackgroundThreadScenarioTest {

    @Mock
    Scenario wrappedScenario;
    @Mock
    Executor backgroundThreadExecutor;
    @InjectMocks
    BackgroundThreadScenario backgroundThreadScenario;

    @SuppressWarnings("unchecked")
    @Test
    public void runScenarioOnBackgroundExecutor() throws Exception {
        ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);

        backgroundThreadScenario.run();

        verify(backgroundThreadExecutor).execute(captor.capture());
        verifyZeroInteractions(wrappedScenario);

        captor.getValue().run();
        verify(wrappedScenario).run();
    }
}
