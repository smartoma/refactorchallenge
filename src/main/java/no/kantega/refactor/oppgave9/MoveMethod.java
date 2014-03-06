package no.kantega.refactor.oppgave9;

public class MoveMethod {

    private int unitPrice;

    private int totalAmount;

    private int discount;

    public int envyMethodForTotalPrice(Collaborator collaborator) {

        // Disse 4 linjene skal bli en metod 'totalPrice()' i Collaborator klasse,
        // og her skal man bare kalle: collaborator.totalPrice()
        // Du har ikke lov til å endre Collaborator manuelt !
        // Tips: Prøv å gjennomføre dette i 3 steg:
        // 1. refaktorer til en ny metode
        // 2. flytt instansvariabler (unitPrice, totalAmount, discount) til lokal scope.
        // 3. flytt den nye metoden (totalPrice) til riktig klasse.
        unitPrice = collaborator.getUnitPrice();
        totalAmount = collaborator.getTotalAmount();
        discount = collaborator.getDiscount();
        return unitPrice * totalAmount - discount;
    }
}

// Don't touch me!
class Collaborator {

    private int unitPrice = 5;

    private int totalAmount = 100;

    private int discount = 25;

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getDiscount() {
        return discount;
    }
}
