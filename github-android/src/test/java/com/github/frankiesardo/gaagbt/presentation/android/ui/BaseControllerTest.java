package com.github.frankiesardo.gaagbt.presentation.android.ui;

import com.github.frankiesardo.gaagbt.presentation.android.controller.BaseController;
import com.squareup.otto.Bus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BaseControllerTest {

    @Mock
    Bus bus;

    BaseController controller = new BaseController();

    @Test
    public void registerToBus() throws Exception {
        controller.startWatchingBus(bus);

        verify(bus).register(controller);
    }

    @Test
    public void unregisterToBus() throws Exception {
        controller.stopWatchingBus(bus);

        verify(bus).unregister(controller);
    }
}
