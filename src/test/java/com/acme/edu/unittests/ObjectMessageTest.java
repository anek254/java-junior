package com.acme.edu.unittests;

import com.acme.ooad.messages.CharMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import com.acme.ooad.messages.ObjectMessage;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ObjectMessageTest {
    @Test
    public void shouldLogAndUpdateMessageWhenObject(){
        Object testObject = new Object();
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        ObjectMessage sut = new ObjectMessage(testObject);

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInReferenceMessageWhenObject() {
        Object testObject = new Object();
        ObjectMessage arrayMessage = new ObjectMessage(testObject);
        Assert.assertEquals("reference: " + testObject, arrayMessage.messageToString());
    }
}
