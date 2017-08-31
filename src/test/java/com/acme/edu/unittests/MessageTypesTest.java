//package com.acme.edu.unittests;
//
//import com.acme.ooad.FormattingSavingHandler;
//import com.acme.ooad.messages.IntMessage;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.mockito.Mockito.mock;
//
//public class MessageTypesTest {
//    @Test
//    public void shouldSumIntegersWhenSequenceOfIntegers() {
//        FormattingSavingHandler loggerDummy = mock(FormattingSavingHandler.class);
//        IntMessage sut = new IntMessage(5);
//
//        sut.updateMessage(10, loggerDummy);
//
//        Assert.assertEquals(15, sut.getValue());
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
//}
