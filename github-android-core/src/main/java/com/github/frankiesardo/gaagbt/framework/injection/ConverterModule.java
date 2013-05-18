package com.github.frankiesardo.gaagbt.framework.injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.framework.converter.JsonConverter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ConverterModule {
    @Provides
    @Singleton
    JsonConverter provideJsonConverter() {
        return new JsonConverter(new ObjectMapper(), new SimpleModule());
    }
}
