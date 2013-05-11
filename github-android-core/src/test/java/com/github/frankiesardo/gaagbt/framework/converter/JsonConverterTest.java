package com.github.frankiesardo.gaagbt.framework.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;

import java.io.Reader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JsonConverterTest {

    @Mock
    ObjectMapper objectMapper;
    @Mock
    SimpleModule module;

    JsonConverter jsonConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        jsonConverter = new JsonConverter(objectMapper, module);
    }

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
        Class<?> targetClass = JsonConverterTest.class;
        Reader chosenReader = mock(Reader.class);
        jsonConverter.readValue(chosenReader, targetClass);

        verify(objectMapper).readValue(same(chosenReader), same(targetClass));
    }
}
