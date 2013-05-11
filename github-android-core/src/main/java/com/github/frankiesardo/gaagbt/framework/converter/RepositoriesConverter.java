package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;

import java.io.IOException;
import java.util.List;

class RepositoriesConverter extends JsonDeserializer<Repositories> {

    @Override
    public Repositories deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return jp.readValueAs(RepositoriesBuilder.class).build();
    }

    static class RepositoriesBuilder {
        public List<Repository> repositories;

        Repositories build() {
            return new Repositories(repositories);
        }
    }
}
