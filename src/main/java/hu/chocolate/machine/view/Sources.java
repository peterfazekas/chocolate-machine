package hu.chocolate.machine.view;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public enum Sources {
    CHOCOLATE("csoki.txt"),
    PURCHASE("vasarlas.txt"),
    OUTPUT("rekesz7.txt");

    private final String source;

    Sources(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
