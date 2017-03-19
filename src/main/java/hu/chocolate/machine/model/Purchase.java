package hu.chocolate.machine.model;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.03.18..
 */
public class Purchase {

    private final int compartment;
    private final int count;
    private final List<Integer> changes;

    public Purchase(final int compartment, final int count, final List<Integer> changes) {
        this.compartment = compartment;
        this.count = count;
        this.changes = changes;
    }

    public int getPrice() {
        int price = 0;
        for (int i = 0; i < changes.size(); i++) {
            price += changes.get(i) * Change.fromIndex(i).getValue();
        }
        return price;
    }

    public int getCompartment() {
        return compartment;
    }

    public int getCount() {
        return count;
    }

    public List<Integer> getChanges() {
        return changes;
    }
}
