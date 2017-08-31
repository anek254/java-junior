//package com.acme.edu.iteration02;
//
//import com.acme.edu.FacadeLogger;
//import com.acme.edu.SysoutCaptureAndAssertionAbility;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import java.io.IOException;
//
//import static java.lang.System.lineSeparator;
//
//public class LoggerTest implements SysoutCaptureAndAssertionAbility {
//    //region given
//    @Before
//    public void setUpSystemOut() throws IOException {
//        resetOut();
//        captureSysout();
//    }
//
//    @After
//    public void tearDown() {
//        resetOut();
//    }
//    //endregion
//
//    @Test @Ignore
//    public void shouldLogSequentIntegersAsSum() throws IOException {
//        //region when
//        FacadeLogger.log("str 1");
//        FacadeLogger.log(1);
//        FacadeLogger.log(2);
//        FacadeLogger.log("str 2");
//        FacadeLogger.log(0);
//        FacadeLogger.cachePrint();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "string: str 1" + lineSeparator() +
//            "primitive: 3" + lineSeparator() +
//            "string: str 2" + lineSeparator() +
//            "primitive: 0" + lineSeparator()
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
//        //region when
//        FacadeLogger.log("str 1");
//        FacadeLogger.log(10);
//        FacadeLogger.log(Integer.MAX_VALUE);
//        FacadeLogger.log(2);
//        FacadeLogger.log("str 2");
//        FacadeLogger.log(0);
//        FacadeLogger.cachePrint();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "string: str 1" + lineSeparator() +
//            "primitive: " + Integer.MAX_VALUE + lineSeparator() +
//            "primitive: 12" + lineSeparator() +
//            "string: str 2" + lineSeparator() +
//            "primitive: 0" + lineSeparator()
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
//        //region when
//        FacadeLogger.log("str 1");
//        FacadeLogger.log((byte)10);
//        FacadeLogger.log((byte)Byte.MAX_VALUE);
//        FacadeLogger.log((byte)2);
//        FacadeLogger.log("str 2");
//        FacadeLogger.log(0);
//        FacadeLogger.cachePrint();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "string: str 1" + lineSeparator() +
//            "primitive: " + Byte.MAX_VALUE + lineSeparator() +
//            "primitive: 12" + lineSeparator() +
//            "string: str 2" + lineSeparator() +
//            "primitive: 0" + lineSeparator()
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
//        //region when
//        FacadeLogger.log("str 1");
//        FacadeLogger.log("str 2");
//        FacadeLogger.log("str 2");
//        FacadeLogger.log(0);
//        FacadeLogger.log("str 2");
//        FacadeLogger.log("str 3");
//        FacadeLogger.log("str 3");
//        FacadeLogger.log("str 3");
//        FacadeLogger.cachePrint();
//        //endregion
//
//        //region then
//        assertSysoutContains(
//            "string: str 1" + lineSeparator() +
//            "string: str 2 (x2)" + lineSeparator() +
//            "primitive: 0" + lineSeparator() +
//            "string: str 2" + lineSeparator() +
//            "string: str 3 (x3)" + lineSeparator()
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldIgnoreEmptyStringsAndNullObjects() throws IOException {
//        //region when
//        final Object nullObject = null;
//        FacadeLogger.log("str 1");
//        FacadeLogger.log("str 1");
//        FacadeLogger.log("");
//        FacadeLogger.log("");
//        FacadeLogger.log("");
//        FacadeLogger.log("str 1");
//        FacadeLogger.log(nullObject);
//        FacadeLogger.log("str 2");
//        FacadeLogger.log(6);
//        FacadeLogger.log("");
//        FacadeLogger.log(nullObject);
//        FacadeLogger.log(8);
//        FacadeLogger.cachePrint();
//        //endregion
//
//        //region then
//        assertSysoutContains(
//                "string: str 1 (x3)" + lineSeparator() +
//                "string: str 2" + lineSeparator() +
//                "primitive: 14" + lineSeparator()
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogCorrectlyNegativeIntegerOverflowWhenSequentIntegers() throws IOException {
//        //region when
//        FacadeLogger.log(-5);
//        FacadeLogger.log(Integer.MIN_VALUE);
//        FacadeLogger.log(-8);
//        FacadeLogger.cachePrint();
//        //endregion
//
//        //region then
//        assertSysoutContains(
//            "primitive: " + Integer.MIN_VALUE + lineSeparator() +
//            "primitive: -13" + lineSeparator()
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogCorrectlyNegativeByteOverflowWhenSequentIntegers() throws IOException {
//        //region when
//        FacadeLogger.log((byte)-5);
//        FacadeLogger.log(Byte.MIN_VALUE);
//        FacadeLogger.log((byte)-8);
//        FacadeLogger.cachePrint();
//        //endregion
//
//        //region then
//        assertSysoutContains(
//            "primitive: " + Byte.MIN_VALUE + lineSeparator() +
//            "primitive: -13" + lineSeparator()
//        );
//        //endregion
//    }
//}