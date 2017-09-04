package com.acme.edu.unittests;

import com.acme.ooad.messages.FormattingSavingHandler;
import com.acme.ooad.messages.StringMessage;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StringMessageTest {
    @Test
    public void shouldLogAndUpdateMessageWhenAnotherString() {
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        StringMessage sut = new StringMessage("str");
        String anotherString = "str 2";

        sut.updateMessage(anotherString, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(anotherString);
    }

    @Test
    public void shouldLogAndUpdateMessageWhenObject() {
        Object testObject = new Object();
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        StringMessage sut = new StringMessage("str");

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInStringMessageWhenString() {
        StringMessage stringMessage = new StringMessage("str");
        Assert.assertEquals("string: str", stringMessage.messageToString());
    }

    @Test
    public void shouldFormatInStringMessageWhenSequenceOfStrings() {
        StringMessage sut = new StringMessage("str");
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);

        sut.updateMessage("str", loggerDummy);

        Assert.assertEquals("string: str (x2)", sut.messageToString());
    }
}
