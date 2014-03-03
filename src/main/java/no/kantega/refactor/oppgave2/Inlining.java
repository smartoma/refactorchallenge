package no.kantega.refactor.oppgave2;

public class Inlining {

    // 1. Dette skal være en lokal variabel i metod.
    private String reduceMyScopeAndInline;

    public int getPriceAsString(final Inlining collaborator) {
        reduceMyScopeAndInline = collaborator.priceQuery();

        collaborator.dontTouchMe();

        // 2. Dette skal bruke priceQuery-metod kall istedenfor temp variabel.
        return Integer.valueOf(reduceMyScopeAndInline);
    }

    public String priceQuery() {
        return "100";
    }

    public void dontTouchMe() {
    }
}
