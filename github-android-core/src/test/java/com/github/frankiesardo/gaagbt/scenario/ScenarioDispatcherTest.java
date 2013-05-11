package com.github.frankiesardo.gaagbt.scenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScenarioDispatcherTest {

    @Mock
    Scenario scenario;
    @Mock
    ScenarioFactory scenarioFactory;
    @InjectMocks
    ScenarioDispatcher scenarioDispatcher;

    @Test
    public void runSearchRepositories() throws Exception {
        when(scenarioFactory.searchRepositories(null, null)).thenReturn(scenario);

        scenarioDispatcher.searchRepositories(null, null);

        verify(scenario).run();
    }
}
