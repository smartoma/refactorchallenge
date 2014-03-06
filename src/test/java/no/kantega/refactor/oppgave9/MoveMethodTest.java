package no.kantega.refactor.oppgave9;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.powermock.reflect.Whitebox.getInternalState;
import static org.powermock.reflect.Whitebox.invokeMethod;

public class MoveMethodTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws Exception {
        final MoveMethod moveMethod = new MoveMethod();
        final Collaborator collaborator = new Collaborator();
        assertThat((Integer) invokeMethod(collaborator, "totalPrice"), is(475));

        try {
            getInternalState(moveMethod, "unitPrice");
            fail("unitPrice should have local scope");
        } catch (Exception e) {}

        try {
            getInternalState(moveMethod, "totalAmount");
            fail("totalAmount should have local scope");
        } catch (Exception e) {}

        try {
            getInternalState(moveMethod, "discount");
            fail("discount should have local scope");
        } catch (Exception e) {}
    }

}
