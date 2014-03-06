package no.kantega.refactor.oppgave7;

public class ChangeSignature {

    // Endre signaturen til metoden slik at den får et nytt
    // String parameter 'firstName'. Pass på at kallende objekt
    // på linje 22 (changeSignature.getName) endres også
    // slik at den bruker lokal variabel 'firstName' som en
    // argument. Men du har ikke lov til å endre Collaborator manuelt!!
    // Tips: 'default value' i dialogboksen 'change signature' er din venn...
    public String addParameterToMe(String lastName) {
        return "Hello " + lastName;
    }
}

class Collaborator {

    public void printName() {
        final ChangeSignature changeSignature = new ChangeSignature();
        final String lastName = "lastname";
        final String firstName = "firstname";

        changeSignature.addParameterToMe(lastName); // Don't touch me!
    }
}