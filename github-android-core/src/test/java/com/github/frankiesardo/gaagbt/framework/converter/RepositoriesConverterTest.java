package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.entity.Repositories;

import org.junit.Test;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.*;
import static org.fest.assertions.Assertions.assertThat;

public class RepositoriesConverterTest {

    JsonConverter converter = new JsonConverter(new ObjectMapper(), new SimpleModule());

    @Test
    public void parseDataCorrectly() throws Exception {
        Repositories repositories = converter.readValue(new ResourceReader("repositories.json"), Repositories.class);

        assertThat(repositories).containsExactly(GITHUB, NOVODA, FACEBOOK);
    }
}
