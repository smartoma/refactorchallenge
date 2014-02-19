package no.kantega.refactor;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public abstract class SuccessAwareTest {

    @Rule
    public TestRule rule = new TestWatcher() {
        @Override
        protected void succeeded(final Description description) {
            System.err.println("This was big success... " + description.getClassName());
        }
    };
}
