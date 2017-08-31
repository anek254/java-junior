package com.acme.edu.iteration01;

import com.acme.edu.FacadeLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.ooad.messages.FlushMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        FacadeLogger.log(1);
        FacadeLogger.log(0);
        FacadeLogger.log(-1);
        FacadeLogger.log(new FlushMessage());
        //endregion

        //region then
        assertSysoutEquals("primitive: 0" + lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        FacadeLogger.log((byte)1);
        FacadeLogger.log((byte)0);
        FacadeLogger.log((byte)-1);
        FacadeLogger.log(new FlushMessage());
        //endregion

        //region then
        assertSysoutEquals("primitive: 0" + lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        FacadeLogger.log('a');
        FacadeLogger.log('b');
        FacadeLogger.log(new FlushMessage());
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        FacadeLogger.log("test string 1");
        FacadeLogger.log("other str");
        FacadeLogger.log(new FlushMessage());
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        FacadeLogger.log(true);
        FacadeLogger.log(false);
        FacadeLogger.log(new FlushMessage());
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        FacadeLogger.log(new Object());
        FacadeLogger.log(new FlushMessage());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}