package com.acme.edu.unittests;

import com.acme.ooad.messages.ArrayMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArrayMessageTest {
    @Test
    public void shouldFormatEmptyArrayWhenEmptyArray() {
        ArrayMessage arrayMessage = new ArrayMessage(new int[]{});
        Assert.assertEquals("primitives array: {}", arrayMessage.messageToString());
    }

    @Test
    public void shouldFormatArrayWhenArrayValues() {
        ArrayMessage arrayMessage = new ArrayMessage(new int[]{1, 2, 3});
        Assert.assertEquals("primitives array: {1, 2, 3}", arrayMessage.messageToString());
    }

    @Test
    public void shouldLogAndUpdateCurrentMessageWhenUpdateArrayMessage() {
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        ArrayMessage sut = new ArrayMessage(new int[]{});
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }
}
