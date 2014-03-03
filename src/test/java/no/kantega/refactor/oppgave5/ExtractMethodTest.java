package no.kantega.refactor.oppgave5;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.powermock.reflect.internal.WhiteboxImpl.invokeMethod;

public class ExtractMethodTest extends SuccessAwareTest {

    private final String expectedBanner = "***************************\n" +
                                          "***** This is banner ******\n" +
                                          "***************************\n";

    private final String expectedDetails = "name: test\n" +
                                           "amount: 16.0\n";

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void checkCorrectness() throws Exception {
        final ExtractMethod extractMethod = new ExtractMethod("test");
        invokeMethod(extractMethod, "printBanner");
        assertThat(log.getLog(), is(expectedBanner));
        log.clear();

        invokeMethod(extractMethod, "printDetails", invokeMethod(extractMethod, "calculate", 0.0));
        assertThat(log.getLog(), is(expectedDetails));
    }
}
