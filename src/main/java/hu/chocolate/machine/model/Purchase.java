package hu.chocolate.machine.model;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.03.18..
 */
public class Purchase {

    private final int id;

    private final int compartment;
    private final int count;
    private final List<Integer> changes;

    public Purchase(int id, int compartment, int count, List<Integer> changes) {
        this.id = id;
        this.compartment = compartment;
        this.count = count;
        this.changes = changes;
    }

    public int getId() {
        return id;
    }

    public int getCompartment() {
        return compartment;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        int price = 0;
        for (int i = 0; i < changes.size(); i++) {
            price += changes.get(i) * Change.fromIndex(i).getValue();
        }
        return price;
    }

    public List<Integer> getChanges() {
        return changes;
    }

}
