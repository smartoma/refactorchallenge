package no.kantega.refactor.oppgave3;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.powermock.reflect.Whitebox.getInternalState;

public class ConstantsTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() {
        assertThat((Integer) getInternalState(Constants.class, "SECONDS_IN_MINUTE"), is(60));
        assertThat((Integer) getInternalState(Constants.class, "MINUTES_IN_HOUR"), is(60));
        assertThat((Integer) getInternalState(Constants.class, "HOURS_IN_DAY"), is(24));
        assertThat((Integer) getInternalState(Constants.class, "DAYS_IN_YEAR"), is(365));

    }
}
