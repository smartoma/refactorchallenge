package no.kantega.refactor.oppgave2;

import no.kantega.refactor.SuccessAwareTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.powermock.reflect.exceptions.FieldNotFoundException;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.reflect.internal.WhiteboxImpl.getInternalState;

public class InliningTest extends SuccessAwareTest {

    @Mock
    private Inlining mockedCollaborator;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void checkCorrectnessOf_LocalScopeVariable_AndQueryInlining() {
        Inlining inlining = new Inlining();
        try {
            getInternalState(inlining, "reduceMyScopeAndInline");
            fail("Field reduceMyScopeAndInline should be in a local scope.");
        } catch (FieldNotFoundException e) {}

        InOrder order = inOrder(mockedCollaborator);
        when(mockedCollaborator.priceQuery()).thenReturn("100");
        inlining.getPriceAsString(mockedCollaborator);

        order.verify(mockedCollaborator).dontTouchMe();
        order.verify(mockedCollaborator).priceQuery();
    }


}
