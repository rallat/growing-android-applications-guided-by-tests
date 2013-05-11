package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.frankiesardo.gaagbt.entity.Repository;

import java.io.IOException;

public class RepositoryConverter extends JsonDeserializer<Repository> {

    @Override
    public Repository deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return jp.readValueAs(RepositoryBuilder.class).build();
    }

    static class RepositoryBuilder {
        public String description;

        Repository build() {
            return new Repository(description);
        }
    }
}
