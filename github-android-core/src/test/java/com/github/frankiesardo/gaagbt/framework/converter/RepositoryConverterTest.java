package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.entity.Repository;

import org.junit.Test;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.GITHUB;
import static org.fest.assertions.Assertions.assertThat;

public class RepositoryConverterTest {

    JsonConverter converter = new JsonConverter(new ObjectMapper(), new SimpleModule());

    @Test
    public void parseDataCorrectly() throws Exception {
        Repository repository = converter.readValue(new ResourceReader("repository.json"), Repository.class);

        assertThat(repository).isEqualTo(GITHUB);
    }
}
