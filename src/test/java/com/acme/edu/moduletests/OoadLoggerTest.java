//package com.acme.edu.moduletests;
//
//import com.acme.ooad.messages.FormattingSavingHandler;
//import com.acme.ooad.formatters.Formatter;
//import com.acme.ooad.messages.Message;
//import com.acme.ooad.savers.Saver;
//import org.junit.Test;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//public class OoadLoggerTest {
//    @Test
//    public void shouldDoNothingWhenCurrentMessageIsNull() {
//        Message message = null;
//        Saver saverMock = mock(Saver.class);
//        Formatter formatterMock = mock(Formatter.class);
//        FormattingSavingHandler logger = new FormattingSavingHandler(saverMock, formatterMock);
//
//        logger.setCurrentMessage(message);
//        logger.log();
//
//        verify(saverMock, times(0)).save(anyString());
//        verify(formatterMock, times(0)).format(anyString());
//    }
//
//    @Test
//    public void shouldDoNothingWhenMessageIsNull() {
//        Message message = null;
//        Saver saverMock = mock(Saver.class);
//        Formatter formatterMock = mock(Formatter.class);
//        FormattingSavingHandler logger = new FormattingSavingHandler(saverMock, formatterMock);
//
//        logger.log(message);
//
//        verify(saverMock, times(0)).save(anyString());
//        verify(formatterMock, times(0)).format(anyString());
//    }
//
//    @Test
//    public void shouldSaveWhenMessageIsNotNull() {
//        Message message = mock(Message.class);
//        Saver saverMock = mock(Saver.class);
//        Formatter formatterMock = mock(Formatter.class);
//        FormattingSavingHandler logger = new FormattingSavingHandler(saverMock, formatterMock);
//
//        logger.setCurrentMessage(message);
//        logger.log();
//        logger.log(message);
//
//        verify(saverMock, times(2)).save(anyString());
//        verify(formatterMock, times(2)).format(anyString());
//    }
//}
