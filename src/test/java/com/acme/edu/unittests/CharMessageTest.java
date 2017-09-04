package com.acme.edu.unittests;

import com.acme.ooad.messages.BooleanMessage;
import com.acme.ooad.messages.CharMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CharMessageTest {
    @Test
    public void shouldLogAndUpdateCurrentMessageWhenUpdateCharMessage(){
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        CharMessage sut = new CharMessage('q');
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInCharMessageWhenChar() {
        CharMessage arrayMessage = new CharMessage('q');
        Assert.assertEquals("char: q", arrayMessage.messageToString());
    }
}
