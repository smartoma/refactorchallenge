package no.kantega.refactor.oppgave10;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static java.lang.reflect.Modifier.PROTECTED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.powermock.reflect.Whitebox.invokeMethod;

public class PullMembersUpMammalTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws Exception {
        PullMembersUpMammal mammal = new PullMembersUpMammal();
        assertThat("Expecting protected scope for field 'name",
            PullMembersUpMammal.class.getDeclaredField("numberOfLegs").getModifiers(),
            is(PROTECTED));
        assertThat((String) invokeMethod(mammal, "run"), is("I am running with 4 legs!"));

        assertTrue(Cat.class.getMethod("run").getDeclaringClass().equals(PullMembersUpMammal.class));
        assertTrue(Horse.class.getMethod("run").getDeclaringClass().equals(PullMembersUpMammal.class));

    }

}
