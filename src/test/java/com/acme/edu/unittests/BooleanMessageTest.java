package com.acme.edu.unittests;

import com.acme.ooad.messages.ArrayMessage;
import com.acme.ooad.messages.BooleanMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooleanMessageTest {
    @Test
    public void shouldLogAndUpdateCurrentMessageWhenUpdateBooleanMessage(){
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        BooleanMessage sut = new BooleanMessage(false);
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInPrimitiveMessageWhenBoolean() {
        BooleanMessage arrayMessage = new BooleanMessage(true);
        Assert.assertEquals("primitive: true", arrayMessage.messageToString());
    }
}
