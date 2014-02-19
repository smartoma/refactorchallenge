package no.kantega.refactor.oppgave1;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.powermock.reflect.internal.WhiteboxImpl.getInternalState;
import static org.powermock.reflect.internal.WhiteboxImpl.invokeMethod;

public class RenameTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws Exception {
        final Rename classToRename = new Rename();

        assertThat((String) getInternalState(classToRename, "companyName"), is("Kantega"));
        assertThat((String) invokeMethod(classToRename, "upCaseCompanyName"), is("KANTEGA"));
    }
}
