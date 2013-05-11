package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RepositoriesConverterTest {

    static final Repository GITHUB = new Repository("GitHub Android App");
    static final Repository NOVODA = new Repository("Examples of Android applications");
    static final Repository FACEBOOK = new Repository("Facebook SDK for Android");

    final JsonConverter converter = new JsonConverter(new ObjectMapper(), new SimpleModule());

    @Test
    public void parseDataCorrectly() throws Exception {
        Repositories repositories = converter.readValue(new ResourceReader("repositories.json"), Repositories.class);

        assertThat(repositories).containsExactly(GITHUB, NOVODA, FACEBOOK);
    }
}
