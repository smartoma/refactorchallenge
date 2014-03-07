package no.kantega.refactor.oppgave6;

public class EncapsulateFields {

    // Dette skal til private scope med public getter: getName().
    // Collaborator skal bruke den nye metoden getName(), ikke 'fields.name'.
    // Du har ikke lov til å endre manuelt Collaborator-klasse.
    public String name = "make me private and protect with getter";

}

class Collaborator {

    // Don't touch me!
    public String encapsulatedName(EncapsulateFields fields) {
        // Dette skal bli kall til 'getName()' istedenfor public felt.
        // Men du har ikke lov til å endre manuelt dette!
        return fields.name;
    }
}

