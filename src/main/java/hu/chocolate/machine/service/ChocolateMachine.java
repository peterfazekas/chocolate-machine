package hu.chocolate.machine.service;

import hu.chocolate.machine.model.Change;
import hu.chocolate.machine.model.Chocolate;
import hu.chocolate.machine.model.Purchase;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public class ChocolateMachine {
    public static final int NUMBER_OF_FRIENDS = 7;
    public static final String NEW_LINE = "\r\n";
    private final List<Chocolate> chocolates;
    private final List<Purchase> purchases;

    public ChocolateMachine(List<Chocolate> chocolates, List<Purchase> purchases) {
        this.chocolates = chocolates;
        this.purchases = purchases;
    }

    public int getTotalValue() {
        return chocolates.stream()
                .mapToInt(i -> i.getCount() * i.getPrice())
                .sum();
    }

    public String getCompartments() {
        StringBuilder sb = new StringBuilder();
        getCompartmentSet().stream()
                .map(i -> i + " ")
                .forEach(sb::append);
        return sb.toString();
    }

    private Set<Integer> getCompartmentSet() {
        return purchases.stream()
                .map(i -> i.getCompartment())
                .collect(Collectors.toSet());
    }

    public String getAvailableCompartments(final int value) {
        StringBuilder sb = new StringBuilder();
        getAvailableCompartmentList(value).stream()
                .map(i -> i + " ")
                .forEach(sb::append);
        return sb.toString();

    }

    private List<Integer> getAvailableCompartmentList(final int value) {
        return chocolates.stream()
                .filter(i -> i.getPrice() * NUMBER_OF_FRIENDS <= value)
                .map(i -> i.getCompartment())
                .collect(Collectors.toList());
    }

    public String getPunctualAmountOfChanges(Chocolate find) {
        final Chocolate chocolate = getChocolate(find.getCompartment());
        int total = chocolate.getPrice() * find.getCount();
        return getChanges(total);
    }

    private Chocolate getChocolate(int compartment) {
        return chocolates.stream()
                .filter(i -> i.getCompartment() == compartment)
                .findFirst()
                .get();
    }

    private String getChanges(final int value) {
        List<Integer> changes = new ArrayList<>();
        Arrays.stream(Change.values())
                .mapToInt(i -> i.getValue())
                .forEach(changes::add);
        changes.sort(Comparator.reverseOrder());
        int total = value;
        StringBuilder sb = new StringBuilder("   A fizetendő összeg: " + value + " fabatka, címletekben:");
        for (int change : changes) {
            int div = total / change ;
            total -= div * change;
            if(div > 0) {
                sb.append(NEW_LINE + "   " + change + ": " + div);
            }
        }
        return sb.toString();
    }
}
