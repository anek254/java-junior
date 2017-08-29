package com.acme.edu.moduletests;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.ooad.messageformatters.ArrayStandardMessageFormatter;
import com.acme.ooad.messageformatters.BooleanStandardMessageFormatter;
import com.acme.ooad.messageformatters.ByteStandardMessageFormatter;
import com.acme.ooad.messageformatters.CharStandardMessageFormatter;
import com.acme.ooad.messages.ArrayMessage;
import com.acme.ooad.messages.BooleanMessage;
import com.acme.ooad.messages.ByteMessage;
import com.acme.ooad.messages.CharMessage;
import org.junit.*;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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
        //
    }
}
