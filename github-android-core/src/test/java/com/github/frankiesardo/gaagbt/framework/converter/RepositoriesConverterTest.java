package com.github.frankiesardo.gaagbt.framework.converter;

import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.framework.injection.InjectionTestRunner;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.*;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(InjectionTestRunner.class)
public class RepositoriesConverterTest {

    @Inject
    JsonConverter converter;

    @Test
    public void parseDataCorrectly() throws Exception {
        Repositories repositories = converter.readValue(new ResourceReader("repositories.json"), Repositories.class);

        assertThat(repositories).containsExactly(GITHUB, NOVODA, FACEBOOK);
    }
}
