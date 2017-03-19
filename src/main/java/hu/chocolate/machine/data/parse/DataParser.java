package hu.chocolate.machine.data.parse;

import hu.chocolate.machine.model.Chocolate;
import hu.chocolate.machine.model.Purchase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public class DataParser {

    public static final String SEPARATOR = " ";

    public List parse(final List<String> lines) {
        lines.remove(0);
        List parsedData = new ArrayList<>();
        for (String line : lines) {
            Object obj = dataParse(line);
            parsedData.add(obj);
        }
        return parsedData;
    }

    private Object dataParse(String line) {
        String[] items = line.split(SEPARATOR);
        int compartment = Integer.parseInt(items[0]);
        int count = Integer.parseInt(items[1]);
        if(items.length > 3) {
            List<Integer> changes = new ArrayList<>();
            for (int i = 2; i < items.length; i++) {
                changes.add(Integer.parseInt(items[i]));
            }
            return new Purchase(compartment, count, changes);
        } else {
            int price = Integer.parseInt(items[2]);
            return new Chocolate(compartment, count, price);
        }
    }

    public Chocolate createChocolate(String line) {
        String[] items = line.split(SEPARATOR);
        int compartment = Integer.parseInt(items[0]);
        int count = Integer.parseInt(items[1]);
        return new Chocolate(compartment, count);
    }
}
