package com.acme.edu.iteration03;

import com.acme.edu.FacadeLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.ooad.messages.FlushMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

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


    //TODO: implement FormattingSavingHandler solution to match specification as tests

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        FacadeLogger.log(new int[] {-1, 0, 1});
        FacadeLogger.log(new FlushMessage());
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}" + lineSeparator()
        );
        //endregion
    }

    /*
    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        FormattingSavingHandler.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {\n" +
                "{-1, 0, 1}\n" +
                "{1, 2, 3}\n" +
                "{-1, -2, -3}\n" +
            "}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        FormattingSavingHandler.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {\n" +
                "{\n" + "{\n" + "{\n" +
                    "0\n" +
                "}\n" + "}\n" + "}\n" +
            "}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        FormattingSavingHandler.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1\nstring 2\nstr 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        FormattingSavingHandler.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        FormattingSavingHandler.log(1);
        FormattingSavingHandler.log("str");
        FormattingSavingHandler.log(Integer.MAX_VALUE - 10);
        FormattingSavingHandler.log(11);
        //endregion

        //region then
        assertSysoutContains(1);
        assertSysoutContains("str");
        assertSysoutContains(Integer.MAX_VALUE - 10);
        assertSysoutContains(11);
        //endregion
    }

    */
}