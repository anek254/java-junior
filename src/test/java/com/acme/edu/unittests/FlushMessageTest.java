package com.acme.edu.unittests;

import com.acme.ooad.messages.CharMessage;
import com.acme.ooad.messages.FlushMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlushMessageTest {
    @Test
    public void shouldLogCurrentMessageWhenUpdateFlushMessage(){
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        FlushMessage sut = new FlushMessage();
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInNullMessageWhenFlush() {
        FlushMessage arrayMessage = new FlushMessage();
        Assert.assertEquals(null, arrayMessage.messageToString());
    }

    @Test
    public void shouldFormatInEmptyStringMessageWhenFlushToString() {
        FlushMessage arrayMessage = new FlushMessage();
        Assert.assertEquals("", arrayMessage.toString());
    }
}
