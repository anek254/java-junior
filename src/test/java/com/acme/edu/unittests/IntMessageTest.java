package com.acme.edu.unittests;

import com.acme.ooad.messages.ByteMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import com.acme.ooad.messages.IntMessage;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IntMessageTest {
    @Test
    public void shouldUpdateIntSumWhenIntWithoutOverflow(){
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        IntMessage sut = new IntMessage(1);

        sut.updateMessage(2, loggerDummy);

        Assert.assertEquals(3, sut.getValue());
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
