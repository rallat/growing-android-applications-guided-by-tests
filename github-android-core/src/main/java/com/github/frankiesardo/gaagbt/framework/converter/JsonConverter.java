package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;

import java.io.IOException;
import java.io.Reader;

public class JsonConverter {

    private final ObjectMapper objectMapper;

    public JsonConverter(ObjectMapper objectMapper, SimpleModule module) {
        this.objectMapper = objectMapper;
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configureModule(module);
        objectMapper.registerModule(module);
    }

    private void configureModule(SimpleModule module) {
        module.addDeserializer(Repositories.class, new RepositoriesConverter());
        module.addDeserializer(Repository.class, new RepositoryConverter());
    }

    public <T> T readValue(Reader reader, Class<T> valueType) {
        try {
            return objectMapper.readValue(reader, valueType);
        } catch (IOException e) {
            throw new JsonConverterException(e);
        }
    }

    public static class JsonConverterException extends RuntimeException {
        public JsonConverterException(Exception cause) {
            super(cause);
        }
    }
}
