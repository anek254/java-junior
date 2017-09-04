package com.acme.edu.unittests;

import com.acme.ooad.messages.BooleanMessage;
import com.acme.ooad.messages.FlushMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlushMessageTest {
    private FlushMessage sut;

    @Before
    public void setUpSystemOut() {
        sut = new FlushMessage();
    }

    @Test
    public void shouldLogCurrentMessageWhenUpdateFlushMessage() {
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInNullMessageWhenFlush() {
        Assert.assertEquals(null, sut.messageToString());
    }

    @Test
    public void shouldFormatInEmptyStringMessageWhenFlushToString() {
        Assert.assertEquals("", sut.toString());
    }
}
