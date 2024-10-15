package com.github.ki3lmigu3l;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTestes {

    @Mock
    List<String> listaMockada;

    @Test
    public void primeiroTesteMockito() {
        Mockito.when(listaMockada.size()).thenReturn(20);
        int size = listaMockada.size();

        Assertions.assertThat(size).isEqualTo(20);
        // Mockito.verify(listaMockada, Mockito.times(1)).size(); -> verifica se o método foi chamado.
    }

    @Test
    public void segundoTesteMockito() {
        listaMockada.size();
        listaMockada.add("");

        InOrder inOrder = Mockito.inOrder(listaMockada);
        inOrder.verify(listaMockada).size();
        inOrder.verify(listaMockada).add("");
    }

    @Test
    public void terceiroTesteMockito () {
        Mockito.when(listaMockada.size()).thenReturn(2);
        int size = 0;

        if (true) {
            size = listaMockada.size();
            size = listaMockada.size();
        }

        Mockito.verify(listaMockada, Mockito.times(2)).size();
    }
}
