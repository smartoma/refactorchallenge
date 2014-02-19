package no.kantega.refactor.oppgave4;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Test;

import static no.kantega.refactor.oppgave4.StringManipulation.encodeUrl;
import static no.kantega.refactor.oppgave4.StringManipulation.escapeHtml;
import static no.kantega.refactor.oppgave4.StringManipulation.removeSpaces;
import static no.kantega.refactor.oppgave4.StringManipulation.trimTrailingAndPrefixingSpaces;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class StringManipulationTest extends SuccessAwareTest {

    @Test
    public void checkCorrectness() throws NoSuchFieldException {

        assertThat(escapeHtml, is("&lt;H1&gt;Escape me!&lt;/H1&gt;"));

        assertThat(encodeUrl, is("http%3A%2F%2Fwww.kantega.no%3Fparam%3DI+am+not+encoded"));

        assertThat(trimTrailingAndPrefixingSpaces, is("Trim me!"));

        assertThat(removeSpaces, is("Allspacesshouldberemoved."));

        assertThat(StringManipulation.class.getField("CHANGE_ME_TO_CONSTANT_STYLE"), is(notNullValue()));
    }
}
