package com.github.frankiesardo.gaagbt.framework.injection;

import dagger.ObjectGraph;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class InjectionTestRunner extends BlockJUnit4ClassRunner {

    private static final ObjectGraph OBJECT_GRAPH = ObjectGraph.create(new TestModule(), new ConverterModule());

    public InjectionTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        Object test = super.createTest();
        OBJECT_GRAPH.inject(test);
        return test;
    }
}
