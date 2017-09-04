package com.acme.edu.unittests;

import com.acme.ooad.messages.ByteMessage;
import com.acme.ooad.messages.FormattingSavingHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ByteMessageTest {
    @Before
    public void setUpSystemOut() {
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
    }

    @Test
    public void shouldSumMaxBoundaryValueWhenByteMaxValue() {
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        ByteMessage sut = new ByteMessage((byte) 0);

        sut.updateMessage(Byte.MAX_VALUE, loggerDummy);

        Assert.assertEquals(Byte.MAX_VALUE, sut.getValue());
    }

    @Test
    public void shouldSumMinBoundaryValueWhenByteMinValue() {
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        ByteMessage sut = new ByteMessage((byte) 0);

        sut.updateMessage(Byte.MIN_VALUE, loggerDummy);

        Assert.assertEquals(Byte.MIN_VALUE, sut.getValue());
    }

    @Test
    public void shouldUpdateByteSumWhenByteWithMaxOverflow() {
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        ByteMessage sut = new ByteMessage((byte) 2);

        sut.updateMessage((byte) (Byte.MAX_VALUE - 1), loggerDummy);

        Assert.assertEquals((byte) 1, sut.getValue());
        verify(loggerDummy).log(any(ByteMessage.class));
    }

    @Test
    public void shouldUpdateByteSumWhenByteWithMinOverflow() {
        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
        ByteMessage sut = new ByteMessage((byte) -2);

        sut.updateMessage((byte) (Byte.MIN_VALUE + 1), loggerDummy);

        Assert.assertEquals((byte) -1, sut.getValue());
        verify(loggerDummy).log(any(ByteMessage.class));
    }

    @Test
    public void shouldLogAndUpdateCurrentMessageWhenUpdateByteMessage() {
        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
        ByteMessage sut = new ByteMessage((byte) 1);
        Object testObject = new Object();

        sut.updateMessage(testObject, loggerMock);

        verify(loggerMock).log();
        verify(loggerMock).setCurrentMessage(testObject);
    }

    @Test
    public void shouldFormatInPrimitiveWithSpecificationMessageWhenByte() {
        ByteMessage byteMessage = new ByteMessage((byte) 1);
        Assert.assertEquals("primitive: 1", byteMessage.messageToString());
    }
}
