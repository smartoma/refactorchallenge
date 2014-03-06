package no.kantega.refactor.oppgave6;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static java.lang.reflect.Modifier.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.powermock.reflect.internal.WhiteboxImpl.invokeMethod;

public class EncapsulateFieldsTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws Exception {
        assertThat((String) invokeMethod(new EncapsulateFields(), "getName"),
            is("make me private and protect with getter"));

        assertThat("Expecting private scope for field 'name",
            EncapsulateFields.class.getDeclaredField("name").getModifiers(),
            is(PRIVATE));
    }
}
