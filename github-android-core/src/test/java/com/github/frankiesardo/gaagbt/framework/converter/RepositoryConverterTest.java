package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.entity.Repository;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RepositoryConverterTest {

    static final Repository GITHUB = new Repository("GitHub Android App");

    final JsonConverter converter = new JsonConverter(new ObjectMapper(), new SimpleModule());

    @Test
    public void parseDataCorrectly() throws Exception {
        Repository actual = converter.readValue(new ResourceReader("repository.json"), Repository.class);

        assertThat(actual).isEqualTo(GITHUB);
    }
}
