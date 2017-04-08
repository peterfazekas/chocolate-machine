package hu.chocolate.machine.data.parse;

import hu.chocolate.machine.model.Purchase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.08..
 */
public class PurchaseParser implements DataParser {

    private static final String SEPARATOR = " ";

    @Override
    public Object parse(final List<String> lines) {
        List<Purchase> purchases = new ArrayList<>();
        int id = 1;
        for (String line : lines) {
            purchases.add(createPurchase(line, id++));
        }
        return purchases;
    }

    private Purchase createPurchase(final String line, final int id) {
        String[] items = line.split(SEPARATOR);
        int compartment = Integer.parseInt(items[0]);
        int count = Integer.parseInt(items[1]);
        List<Integer> changes = new ArrayList<>();
        for (int i = 2; i < items.length; i++) {
            changes.add(Integer.parseInt(items[i]));
        }
        return new Purchase(id, compartment, count, changes);
    }
}
