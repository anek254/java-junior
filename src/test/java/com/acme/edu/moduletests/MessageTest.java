//package com.acme.edu.moduletests;
//
//import com.acme.edu.SysoutCaptureAndAssertionAbility;
//import com.acme.ooad.messages.FormattingSavingHandler;
//import com.acme.ooad.messageformatters.ByteStandardMessageFormatter;
//import com.acme.ooad.messageformatters.IntStandardMessageFormatter;
//import com.acme.ooad.messageformatters.StringStandardMessageFormatter;
//import com.acme.ooad.messages.ByteMessage;
//import com.acme.ooad.messages.IntMessage;
//import com.acme.ooad.messages.StringMessage;
//import org.junit.Assert;
//import org.junit.Test;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//public class MessageTest implements SysoutCaptureAndAssertionAbility {
//    @Test
//    public void shouldSumIntegersWhenSequenceOfIntegers() {
//        //region given
//        IntStandardMessageFormatter messageFormatterDummy = mock(IntStandardMessageFormatter.class);
//        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
//        IntMessage sut = new IntMessage(5, messageFormatterDummy);
//        //endregion
//
//        //region when
//        sut.updateMessage(10, loggerDummy);
//        //endregion
//
//        //region then
//        Assert.assertEquals(15, sut.getValue());
//        //endregion
//    }
//
//    @Test
//    public void shouldSumIntegersWithOverflowWhenSequenceOfIntegers() {
//        //region given
//        IntStandardMessageFormatter messageFormatterDummy = mock(IntStandardMessageFormatter.class);
//        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
//        IntMessage sut = new IntMessage(5, messageFormatterDummy);
//        //endregion
//
//        //region when
//        sut.updateMessage(Integer.MAX_VALUE, loggerMock);
//        //endregion
//
//        //region then
//
//        verify(loggerMock).log(any());
//        Assert.assertEquals(5, sut.getValue());
//        //endregion
//    }
//
//    @Test
//    public void shouldSumIntegersWithNegativeOverflowWhenSequenceOfIntegers() {
//        //region given
//        IntStandardMessageFormatter messageFormatterDummy = mock(IntStandardMessageFormatter.class);
//        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
//        IntMessage sut = new IntMessage(-5, messageFormatterDummy);
//        //endregion
//
//        //region when
//        sut.updateMessage(Integer.MIN_VALUE, loggerMock);
//        //endregion
//
//        //region then
//
//        verify(loggerMock).log(any(IntMessage.class));
//        Assert.assertEquals(-5, sut.getValue());
//        //endregion
//    }
//
//    @Test
//    public void shouldSumByteWhenSequenceOfBytes() {
//        //region given
//        ByteStandardMessageFormatter messageFormatterDummy = mock(ByteStandardMessageFormatter.class);
//        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
//        ByteMessage sut = new ByteMessage((byte)5, messageFormatterDummy);
//        //endregion
//
//        //region when
//        sut.updateMessage((byte)10, loggerDummy);
//        //endregion
//
//        //region then
//        Assert.assertEquals((byte)15, sut.getValue());
//        //endregion
//    }
//
//    @Test
//    public void shouldSumBytesWithOverflowWhenSequenceOfBytes() {
//        //region given
//        ByteStandardMessageFormatter messageFormatterDummy = mock(ByteStandardMessageFormatter.class);
//        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
//        ByteMessage sut = new ByteMessage((byte)5, messageFormatterDummy);
//        //endregion
//
//        //region when
//        sut.updateMessage(Byte.MAX_VALUE, loggerMock);
//        //endregion
//
//        //region then
//
//        verify(loggerMock).log(any(ByteMessage.class));
//        Assert.assertEquals((byte)5, sut.getValue());
//        //endregion
//    }
//
//    @Test
//    public void shouldSumBytesWithNegativeOverflowWhenSequenceOfBytes() {
//        //region given
//        ByteStandardMessageFormatter messageFormatterDummy = mock(ByteStandardMessageFormatter.class);
//        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
//        ByteMessage sut = new ByteMessage((byte)-5, messageFormatterDummy);
//        //endregion
//
//        //region when
//        sut.updateMessage(Byte.MIN_VALUE, loggerMock);
//        //endregion
//
//        //region then
//
//        verify(loggerMock).log(any());
//        Assert.assertEquals((byte)-5, sut.getValue());
//        //endregion
//    }
//
//    @Test
//    public void shouldCountEqualStringsWhenSequenceOfStrings() {
//        //region given
//        StringStandardMessageFormatter messageFormatterDummy = mock(StringStandardMessageFormatter.class);
//        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
//        StringMessage sut = new StringMessage("str 1", messageFormatterDummy);
//        //endregion
//
//        //region when
////        sut.updateMessage("str 2", loggerDummy);
//        sut.updateMessage("str 1", loggerDummy);
//        sut.updateMessage("str 1", loggerDummy);
//        //endregion
//
//        //region then
//        Assert.assertEquals(" (x3)", sut.getPostfix());
//        //endregion
//    }
//
//    @Test
//    public void shouldCreateNewStringMessageWhenSequenceOfDifferentStrings() {
//        //region given
//        StringStandardMessageFormatter messageFormatterDummy = mock(StringStandardMessageFormatter.class);
//        FormattingSavingHandler loggerMock = mock(FormattingSavingHandler.class);
//        StringMessage sut = new StringMessage("str 1", messageFormatterDummy);
//        //endregion
//
//        //region when
//        sut.updateMessage("str 1", loggerMock);
//        sut.updateMessage("str 2", loggerMock);
//        //endregion
//
//        //region then
//        verify(loggerMock).setCurrentMessage(any(StringMessage.class));
//        //endregion
//    }
//}
