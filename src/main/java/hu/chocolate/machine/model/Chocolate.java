package hu.chocolate.machine.model;

/**
 * @author Peter_Fazekas on 2017.03.18..
 */
public class Chocolate {

    private final int compartment;
    private final int price;
    private int count;

    public Chocolate(int compartment, int count) {
        this(compartment, count, 0);
    }

    public Chocolate(int compartment, int count, int price) {
        this.compartment = compartment;
        this.count = count;
        this.price = price;
    }

    public int getCompartment() {
        return compartment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }
}
