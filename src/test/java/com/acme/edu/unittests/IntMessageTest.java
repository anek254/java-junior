package com.acme.edu.unittests;

import com.acme.ooad.messages.FormattingSavingHandler;
import com.acme.ooad.messages.IntMessage;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IntMessageTest {
    @Test
    public void shouldSumMaxBoundaryValueWhenByteMaxValue(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(0);

        sut.updateMessage(Integer.MAX_VALUE, loggerDummy);

        Assert.assertEquals(Integer.MAX_VALUE, sut.getValue());
    }

    @Test
    public void shouldSumMinBoundaryValueWhenByteMinValue(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(0);

        sut.updateMessage(Integer.MIN_VALUE, loggerDummy);

        Assert.assertEquals(Integer.MIN_VALUE, sut.getValue());
    }

    @Test
    public void shouldUpdateIntSumWhenIntWithMaxOverflow(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(2);
        IntMessage maxValueIntMessage = new IntMessage(Integer.MAX_VALUE);

        sut.updateMessage((Integer.MAX_VALUE - 1), loggerDummy);

        Assert.assertEquals(1, sut.getValue());
        verify(loggerDummy).log(any(IntMessage.class));
    }

    @Test
    public void shouldUpdateIntSumWhenIntWithMinOverflow(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(-2);

        sut.updateMessage(Integer.MIN_VALUE + 1, loggerDummy);

        Assert.assertEquals(-1, sut.getValue());
        verify(loggerDummy).log(any(IntMessage.class));
    }

    @Test
    public void shouldLogAndUpdateCurrentMessageWhenUpdateIntMessage(){
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(1);
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInPrimitiveWithSpecificationMessageWhenInt() {
        IntMessage intMessage = new IntMessage(1);
        Assert.assertEquals("primitive: 1", intMessage.messageToString());
    }
}
