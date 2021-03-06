package no.kantega.refactor.oppgave5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExtractMethod {

    private List<Order> orders = Arrays.asList(new Order(10.0), new Order(5.0), new Order(1.0));

    private String name;

    public ExtractMethod(String name) {
        this.name = name;
    }

    void printOwing() {
        Iterator<Order> iterator = orders.iterator();
        double totalAmount = 0.0;

        // Oppgave 1. Erstatte 3 linjer med metode 'printBanner()'
        System.out.println ("***************************");
        System.out.println ("***** This is banner ******");
        System.out.println ("***************************");

        // Oppgave 3. Erstatte løkke med metode: 'calculate(totalAmount)'
        // Tips: For å bli kvitt av den første metode-parameteren 'iterator'
        // er det lurt å bruke inlining (2 ganger)...
        while (iterator.hasNext()) {
            totalAmount += iterator.next().getAmount();
        }

        // Oppgave 2. Erstatte 2 linjer med metode 'printDetails(totalAmount)'
        System.out.println ("name: " + name);
        System.out.println ("amount: " + totalAmount);
    }

    private class Order {

        private double amount;

        private Order(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }
}
