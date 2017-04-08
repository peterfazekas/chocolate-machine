package hu.chocolate.machine.data.api;

import hu.chocolate.machine.data.parse.ChocolateParser;
import hu.chocolate.machine.data.parse.DataParser;
import hu.chocolate.machine.data.parse.PurchaseParser;
import hu.chocolate.machine.data.read.DataReader;
import hu.chocolate.machine.data.read.FileDataReader;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.08..
 */
public enum Source {

    CHOCOLATE_MACHINE("csoki.txt", ChocolateParser.class),
    PURCHASE("vasarlas.txt", PurchaseParser.class);

    private final String fileName;
    private final Class<? extends DataParser> parserType;

    Source(final String fileName, final Class<? extends DataParser> parserType) {
        this.fileName = fileName;
        this.parserType = parserType;
    }

    private static DataParser newInstance(final Source source) {
        DataParser instance = null;
        try {
            instance = source.parserType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getData(final Source source) {
        DataReader file = new FileDataReader();
        List<String> lines = file.read(source.fileName);
        DataParser data = newInstance(source);
        return (List<T>) data.parse(lines);
    }

}
