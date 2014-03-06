package no.kantega.refactor.oppgave8;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.powermock.reflect.Whitebox.getInternalState;
import static org.powermock.reflect.Whitebox.invokeMethod;

public class ExtractFieldParameterAndVariableTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws Exception {
        ExtractFieldParameterAndVariable extract = new ExtractFieldParameterAndVariable();
        assertThat((String) getInternalState(extract, "messageField"), is("Fine things"));
        assertThat((String) invokeMethod(extract, "doFineThings", " not happening "),
            is("Fine things not happening here."));
    }
}
