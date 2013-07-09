package com.github.frankiesardo.gaagbt.framework.retrofit;

import com.github.frankiesardo.gaagbt.framework.converter.JsonConverter;

import java.io.Reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RetrofitConverterTest {

    @Mock
    JsonConverter jsonConverter;
    @InjectMocks
    RetrofitConverter retrofitConverter;

    @Test
    public void delegateReadToJsonConverter() throws Exception {
        TypedInput body = mock(TypedInput.class, RETURNS_DEEP_STUBS);
        when(body.mimeType()).thenReturn("anyString");
        Object expected = new Object();
        when(jsonConverter.readValue(any(Reader.class), eq(Object.class))).thenReturn(expected);

        Object actual = retrofitConverter.fromBody(body, Object.class);

        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void delegateWriteToJsonConverter() throws Exception {
        String outcome = "anyString";
        when(jsonConverter.writeValueAsString(anyObject())).thenReturn(outcome);

        TypedOutput output = retrofitConverter.toBody(new Object());

        assertThat(output.length()).isEqualTo(outcome.getBytes().length);
    }
}
