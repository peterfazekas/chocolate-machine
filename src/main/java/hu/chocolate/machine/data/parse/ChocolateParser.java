package hu.chocolate.machine.data.parse;

import hu.chocolate.machine.model.Chocolate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.08..
 */
public class ChocolateParser implements DataParser {

    private static final String SEPARATOR = " ";

    @Override
    public Object parse(List<String> lines) {
        List<Chocolate> chocolates = new ArrayList<>();
        for (String line : lines) {
            chocolates.add(createChocolate(line));
        }
        return chocolates;
    }

    public Chocolate createChocolate(String line) {

        String[] items = line.split(SEPARATOR);
        int compartment = Integer.parseInt(items[0]);
        int count = Integer.parseInt(items[1]);
        int price;
        try {
            price = Integer.parseInt(items[2]);
        } catch (IndexOutOfBoundsException e) {
            price = 0;
        }
        return new Chocolate(compartment, count, price);
    }

}
