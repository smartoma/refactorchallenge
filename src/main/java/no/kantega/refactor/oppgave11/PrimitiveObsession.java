package no.kantega.refactor.oppgave11;

public class PrimitiveObsession {

    //Refaktorer bort 'primitive obsession'-pattern.
    //Istedenfor 'int' skal man bruke wrapper-klasse i
    //begge metodene.

    //1. Erstatte int med en ny klasse i denne pakken som heter IdNumber,
    //og har konstruktor med int parameter.
    //Tips: du må wrappe return verdien til metod...
    public int getId() {
        return 42;
    }
    // 2. Refaktorer dette til å bruke den nye wrapper klassen IdNumber.
    //Tips: Prøv å innføre 'parameter object'.
    public String printId(int id) {
        return "IdNumber is " + id;
    }

}
