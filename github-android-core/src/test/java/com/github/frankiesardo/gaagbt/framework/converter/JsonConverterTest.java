package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;

import java.io.Reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JsonConverterTest {

    @Mock
    ObjectMapper objectMapper;
    @Mock
    SimpleModule module;
    @InjectMocks
    JsonConverter jsonConverter;

    @Test
    public void ignoreUnknownFields() throws Exception {
        verify(objectMapper).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    public void addCustomDeserializersToModule() throws Exception {
        verify(module).addDeserializer(eq(Repository.class), Matchers.<JsonDeserializer<Repository>>any());
        verify(module).addDeserializer(eq(Repositories.class), Matchers.<JsonDeserializer<Repositories>>any());
    }

    @Test
    public void addModuleToMapper() throws Exception {
        verify(objectMapper).registerModule(module);
    }

    @Test
    public void delegateReadToObjectMapper() throws Exception {
        Object expected = new Object();
        when(objectMapper.readValue(any(Reader.class), eq(Object.class))).thenReturn(expected);

        Object actual = jsonConverter.readValue(mock(Reader.class), Object.class);

        assertThat(actual).isSameAs(expected);
    }
}
