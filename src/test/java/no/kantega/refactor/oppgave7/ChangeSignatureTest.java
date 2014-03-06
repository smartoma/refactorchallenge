package no.kantega.refactor.oppgave7;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static org.powermock.reflect.Whitebox.invokeMethod;

public class ChangeSignatureTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws Exception {
        ChangeSignature changeSignature = new ChangeSignature();
        invokeMethod(changeSignature, "addParameterToMe", "lastName", "firstName");
    }

}
