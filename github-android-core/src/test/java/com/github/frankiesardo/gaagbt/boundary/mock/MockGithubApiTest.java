package com.github.frankiesardo.gaagbt.boundary.mock;

import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.framework.converter.JsonConverter;
import com.github.frankiesardo.gaagbt.framework.converter.ResourceReader;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockGithubApiTest {

    @Mock
    JsonConverter jsonConverter;
    @InjectMocks
    MockGithubApi mockGithubApi;

    @Test
    public void returnAndroidMockSearchRepositoriesForAndroidKeyword() throws Exception {
        Repositories repositoriesForAndroidKeyword = mockGithubApi.searchRepositories(ANDROID_KEYWORD);

        assertThat(repositoriesForAndroidKeyword).isEqualTo(ANDROID_REPOSITORIES);
    }

    @Test
    public void returnJsonMockSearchRepositoriesForAnyOtherKeyword() throws Exception {
        ResourceReader mockedResourceReader = new ResourceReader(SEARCH_REPOSITORIES_FILE_NAME);
        Repositories mockedJson = new Repositories(Arrays.asList(NOVODA));
        when(jsonConverter.readValue(eq(mockedResourceReader), eq(Repositories.class))).thenReturn(mockedJson);

        Repositories repositoriesForAnyKeyword = mockGithubApi.searchRepositories("any keyword");

        assertThat(repositoriesForAnyKeyword).isEqualTo(mockedJson);
    }
}
