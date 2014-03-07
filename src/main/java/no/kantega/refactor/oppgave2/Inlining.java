package no.kantega.refactor.oppgave2;

public class Inlining {

    // 1. Dette skal være en lokal variabel i metoden getPriceAsString.
    private String reduceMyScopeAndInline;

    public int getPriceAsString(final Inlining collaborator) {
        reduceMyScopeAndInline = collaborator.priceQuery();

        collaborator.dontTouchMe();

        // 2. Dette skal bruke collaborator.priceQuery() kall som et metode-parameter istedenfor temp variabel.
        // Bruk inlining for å oppnå det.
        return Integer.valueOf(reduceMyScopeAndInline);
    }

    public String priceQuery() {
        return "100";
    }

    public void dontTouchMe() {
    }
}
