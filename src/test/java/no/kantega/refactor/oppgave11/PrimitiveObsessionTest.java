package no.kantega.refactor.oppgave11;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.powermock.reflect.Whitebox.invokeMethod;

public class PrimitiveObsessionTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws Exception {
        PrimitiveObsession primitiveObsession = new PrimitiveObsession();
        Class idNumberClass = Class.forName("no.kantega.refactor.oppgave11.IdNumber");

        assertThat(invokeMethod(primitiveObsession, "getId"), instanceOf(idNumberClass));
        assertThat((String) invokeMethod(primitiveObsession, "printId",
            idNumberClass.getConstructor(int.class).newInstance(42)),
            is("IdNumber is 42")) ;
    }
}
