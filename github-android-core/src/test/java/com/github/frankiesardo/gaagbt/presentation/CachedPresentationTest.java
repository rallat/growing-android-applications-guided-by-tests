package com.github.frankiesardo.gaagbt.presentation;

import com.squareup.otto.Bus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CachedPresentationTest {

    @Mock
    Bus bus;
    @InjectMocks
    CachedPresentation<Object> enabledCachedPresentation;
    @InjectMocks
    CachedPresentation<Object> disabledCachedPresentation;

    Object response = new Object();

    @Before
    public void setUp() throws Exception {
        enabledCachedPresentation.enableCaching();
    }

    @Test
    public void registerItSelfOnTheBusOnCreation() throws Exception {
        verify(bus).register(enabledCachedPresentation);
    }

    @Test
    public void postResponseOnTheBus() throws Exception {
        enabledCachedPresentation.present(response);

        verify(bus).post(response);
    }

    @Test
    public void updateCachedValueWithResponse() throws Exception {
        enabledCachedPresentation.present(response);

        assertThat(enabledCachedPresentation.getCachedValue()).isSameAs(response);
    }

    @Test
    public void clearCachedValue() throws Exception {
        enabledCachedPresentation.present(response);

        enabledCachedPresentation.clearCache();

        assertThat(enabledCachedPresentation.getCachedValue()).isNotSameAs(response);
    }

    @Test
    public void notPostWhenCachingIsDisabled() throws Exception {
        reset(bus);

        disabledCachedPresentation.present(response);

        verifyZeroInteractions(bus);
    }

    @Test
    public void notCacheResponseWhenCachingIsDisabled() throws Exception {
        disabledCachedPresentation.present(response);

        assertThat(enabledCachedPresentation.getCachedValue()).isNotSameAs(response);
    }

    @Test
    public void clearCachedValueWhenCachingIsDisabled() throws Exception {
        enabledCachedPresentation.present(response);

        enabledCachedPresentation.disableCaching();

        assertThat(enabledCachedPresentation.getCachedValue()).isNotSameAs(response);
    }

    @Test
    public void hasNoCachedValueOnCreation() throws Exception {
        assertThat(enabledCachedPresentation.hasCachedValue()).isFalse();
    }

    @Test
    public void hasCachedAfterReceivingAResponseWhenCachingIsEnabled() throws Exception {
        enabledCachedPresentation.present(response);

        assertThat(enabledCachedPresentation.hasCachedValue()).isTrue();
    }
}
