package com.acme.edu.unittests;

import com.acme.ooad.messages.*;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessageTypesTest {
    @Test
    public void shouldSumIntegersWhenSequenceOfIntegers() {
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(5);

        sut.updateMessage(10, loggerDummy);

        Assert.assertEquals(15, sut.getValue());
    }

    @Test
    public void shouldSumIntegersWithOverflowWhenSequenceOfIntegers() {
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(5);

        sut.updateMessage(Integer.MAX_VALUE, loggerMock);

        verify(loggerMock).log(any());
        Assert.assertEquals(5, sut.getValue());
    }

    @Test
    public void shouldFormatInPrimitiveMessageWhenBoolean(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        BooleanMessage sut = new BooleanMessage(true);

        sut.updateMessage(true, loggerDummy);

        Assert.assertEquals(true, sut.getValue());
    }

    @Test
    public void shouldFormatInPrimitiveMessageWhenByte(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        ByteMessage sut = new ByteMessage((byte) 5);

        sut.updateMessage((byte) 4, loggerDummy);

        Assert.assertEquals((byte) 9, sut.getValue());
    }

    @Test
    public void shouldFormatInCharMessageWhenChar(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        CharMessage sut = new CharMessage('t');

        sut.updateMessage('t', loggerDummy);

        Assert.assertEquals('t', sut.getValue());
    }

    @Test
    public void shouldFormatInReferenceMessageWhenObject(){
        Object testObject = new Object();
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        ObjectMessage sut = new ObjectMessage(testObject);

        sut.updateMessage(testObject, loggerDummy);

        Assert.assertEquals(testObject, sut.getValue());
    }

    @Test
    public void shouldFormatInStringMessageWhenString(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        StringMessage sut = new StringMessage("str");

        sut.updateMessage("str", loggerDummy);

        Assert.assertEquals("str", sut.getValue());
    }
}
