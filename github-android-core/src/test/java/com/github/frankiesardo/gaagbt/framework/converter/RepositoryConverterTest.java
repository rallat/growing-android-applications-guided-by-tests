package com.github.frankiesardo.gaagbt.framework.converter;

import com.github.frankiesardo.gaagbt.entity.Repository;
import com.github.frankiesardo.gaagbt.framework.injection.InjectionTestRunner;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.GITHUB;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(InjectionTestRunner.class)
public class RepositoryConverterTest {

    @Inject
    JsonConverter converter;

    @Test
    public void parseDataCorrectly() throws Exception {
        Repository repository = converter.readValue(new ResourceReader("repository.json"), Repository.class);

        assertThat(repository).isEqualTo(GITHUB);
    }
}
