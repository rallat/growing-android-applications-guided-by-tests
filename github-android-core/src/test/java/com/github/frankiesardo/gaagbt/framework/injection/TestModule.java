package com.github.frankiesardo.gaagbt.framework.injection;

import com.github.frankiesardo.gaagbt.framework.converter.RepositoriesConverterTest;
import com.github.frankiesardo.gaagbt.framework.converter.RepositoryConverterTest;

import dagger.Module;

@Module(entryPoints = {
        RepositoryConverterTest.class,
        RepositoriesConverterTest.class
})
public class TestModule {
}
