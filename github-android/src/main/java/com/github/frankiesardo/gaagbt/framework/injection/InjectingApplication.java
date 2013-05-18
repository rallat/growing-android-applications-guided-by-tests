package com.github.frankiesardo.gaagbt.framework.injection;

import android.app.Application;
import dagger.ObjectGraph;

import java.util.LinkedList;
import java.util.List;

public class InjectingApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules().toArray());
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    protected List<Object> getModules() {
        List<Object> modules = new LinkedList<Object>();
        modules.add(new ActivityModule());
        modules.add(new PresentationModule());
        modules.add(new ControllerModule());
        modules.add(new ScenarioModule());
        modules.add(new MockGithubApiModule());
        return modules;
    }
}
