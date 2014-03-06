package no.kantega.refactor.oppgave8;

public class ExtractFieldParameterAndVariable {

    public String doFineThings() {
        // 1. Dette skal bli private medlemsfelt av type String som heter: 'messageField'.
        // Pass på at den er også intialisert i felt-deklarasjon, og ikke her!
        String makeMeField = "Fine things";

        // 2. Dette skal bli metod-parameter i metoden doFineThings som heter 'message'.
        // Pass på at extractor sender inn String ' happening' i Collaborator klasse.
        String makeMeMethodParameter = " happening";

        // 3. Collaborator.getExtraMessage() skal bli en lokal variabel 'extraMessage'
        return makeMeField +
               makeMeMethodParameter +
               Collaborator.getExtraMessage();
    }
}

// Don't touch me!
class Collaborator {

    public void runFineThings() {
        ExtractFieldParameterAndVariable extractor = new ExtractFieldParameterAndVariable();
        extractor.doFineThings();
    }

    public static String getExtraMessage() {
        return "here.";
    }
}
