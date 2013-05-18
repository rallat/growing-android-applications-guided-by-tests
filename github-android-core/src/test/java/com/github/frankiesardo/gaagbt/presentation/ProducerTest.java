package com.github.frankiesardo.gaagbt.presentation;

import com.squareup.otto.Bus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProducerTest {

    @Mock
    Bus bus;
    @InjectMocks
    Producer<Object> producer;

    Object response = new Object();

    @Test
    public void notHaveCachedValueUponCreation() throws Exception {
        assertThat(producer.hasCachedValue()).isFalse();
    }

    @Test
    public void haveCachedValueAfterPresentation() throws Exception {
        producer.present(response);

        assertThat(producer.hasCachedValue()).isTrue();
    }

    @Test
    public void broadcastTheValueReceivedAfterPresentation() throws Exception {
        producer.present(response);

        verify(bus).post(response);
    }

    @Test
    public void activateProducingWhenEnabled() throws Exception {
        producer.enableCaching();

        verify(bus).register(producer);
    }

    @Test
    public void notActivateTwice() throws Exception {
        producer.enableCaching();
        reset(bus);

        producer.enableCaching();

        verifyZeroInteractions(bus);
    }

    @Test
    public void deactivateProducingWhenDisabled() throws Exception {
        producer.enableCaching();
        reset(bus);

        producer.disableCaching();

        verify(bus).unregister(producer);
    }

    @Test
    public void notDeactivateTwice() throws Exception {
        producer.enableCaching();
        producer.disableCaching();
        reset(bus);

        producer.disableCaching();

        verifyZeroInteractions(bus);
    }

    @Test
    public void clearValueWhenDisabled() throws Exception {
        producer.enableCaching();
        producer.present(response);

        producer.disableCaching();

        assertThat(producer.hasCachedValue()).isFalse();
    }
}
