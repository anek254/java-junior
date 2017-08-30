package com.acme.edu.moduletests;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.ooad.messageformatters.*;
import com.acme.ooad.messages.*;
import org.junit.*;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageFormatterTest implements SysoutCaptureAndAssertionAbility {
    @Test
    public void shouldFormatInPrimitivesArrayMessageWhenArray(){
        //region given
        ArrayMessage stub = mock(ArrayMessage.class);
        ArrayStandardMessageFormatter arrayStandardMessageFormatter = new ArrayStandardMessageFormatter();
        when(stub.getValue()).thenReturn(new int[]{1, 2});
        //endregion

        //region when
        arrayStandardMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("primitives array: {1, 2}", arrayStandardMessageFormatter.formatMessage(stub));
        //endregion
    }

    @Test
    public void shouldFormatInPrimitivesArrayMessageWhenEmptyArray(){
        //region given
        ArrayMessage stub = mock(ArrayMessage.class);
        ArrayStandardMessageFormatter arrayStandardMessageFormatter = new ArrayStandardMessageFormatter();
        when(stub.getValue()).thenReturn(new int[]{});
        //endregion

        //region when
        arrayStandardMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("primitives array: {}", arrayStandardMessageFormatter.formatMessage(stub));
        //endregion
    }

    @Test
    public void shouldFormatInPrimitiveMessageWhenBoolean(){
        //region given
        BooleanMessage stub = mock(BooleanMessage.class);
        BooleanStandardMessageFormatter arrayStandardMessageFormatter = new BooleanStandardMessageFormatter();
        when(stub.getValue()).thenReturn(false);
        //endregion

        //region when
        arrayStandardMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("primitive: false", arrayStandardMessageFormatter.formatMessage(stub));
        //endregion
    }

    @Test
    public void shouldFormatInPrimitiveMessageWhenByte(){
        //region given
        ByteMessage stub = mock(ByteMessage.class);
        ByteStandardMessageFormatter byteMessageFormatter = new ByteStandardMessageFormatter();
        when(stub.getValue()).thenReturn((byte)6);
        //endregion

        //region when
        byteMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("primitive: 6", byteMessageFormatter.formatMessage(stub));
        //endregion
    }

    @Test
    public void shouldFormatInCharMessageWhenChar() {
        //region given
        CharMessage stub = mock(CharMessage.class);
        CharStandardMessageFormatter charMessageFormatter = new CharStandardMessageFormatter();
        when(stub.getValue()).thenReturn('d');
        //endregion

        //region when
        charMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("char: d", charMessageFormatter.formatMessage(stub));
        //endregion
    }

    @Test
    public void shouldFormatInPrimitiveMessageWhenInt() {
        //region given
        IntMessage stub = mock(IntMessage.class);
        IntStandardMessageFormatter intMessageFormatter = new IntStandardMessageFormatter();
        when(stub.getValue()).thenReturn(4);
        //endregion

        //region when
        intMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("primitive: 4", intMessageFormatter.formatMessage(stub));
        //endregion
    }

    @Test
    public void shouldFormatInReferenceMessageWhenObject() {
        //region given
        Object testObject = new Object();
        ObjectMessage stub = mock(ObjectMessage.class);
        ObjectStandardMessageFormatter objectMessageFormatter = new ObjectStandardMessageFormatter();
        when(stub.getValue()).thenReturn(testObject);
        //endregion

        //region when
        objectMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("reference: " + testObject.toString(), objectMessageFormatter.formatMessage(stub));
        //endregion
    }

    @Test
    public void shouldFormatInStringMessageWhenString() {
        //region given
        StringMessage stub = mock(StringMessage.class);
        StringStandardMessageFormatter objectMessageFormatter = new StringStandardMessageFormatter();
        when(stub.getValue()).thenReturn("str 1");
        when(stub.getPostfix()).thenReturn("");
        //endregion

        //region when
        objectMessageFormatter.formatMessage(stub);
        //endregion

        //region then
        Assert.assertEquals("string: str 1", objectMessageFormatter.formatMessage(stub));
        //endregion
    }
}
