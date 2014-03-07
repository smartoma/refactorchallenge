package no.kantega.refactor.oppgave10;

public class PullMembersUpMammal {

    protected String yell() {
        return "Mammal yelling!";
    }
}

class Horse extends PullMembersUpMammal {

    // 3. Dette skal bli 'safe deleted'. Etter at du har protected felt i parent-klasse.
    private int numberOfLegs = 4;

    // 4. Dette skal bli 'safe deleted'. Etter at du har run-metode i parent-klasse.
    public String run() {
        return "I am running with " + numberOfLegs + " legs!";
    }

    @Override
    protected String yell() {
        return "Iii-haahh-haa!";
    }
}

class Cat extends PullMembersUpMammal {

    // 1. Refaktorer dette til protected scope i parent-klasse.
    // Tips: bruk 'pull memebers up'.
    private int numberOfLegs = 4;

    // 2. Refaktorer dette til parent-klasse.
    public String run() {
        return "I am running with " + numberOfLegs + " legs!";
    }

    @Override
    protected String yell() {
        return "Mi-aauuu.";
    }
}