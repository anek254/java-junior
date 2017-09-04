package com.acme.edu.unittests;

import com.acme.ooad.messages.BooleanMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooleanMessageTest {
    private BooleanMessage sut;

    @Before
    public void setUpSystemOut() {
        sut = new BooleanMessage(false);
    }

    @Test
    public void shouldLogAndUpdateCurrentMessageWhenUpdateBooleanMessage() {
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInPrimitiveMessageWhenBoolean() {
        Assert.assertEquals("primitive: false", sut.messageToString());
    }
}
