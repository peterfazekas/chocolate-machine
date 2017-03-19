package hu.chocolate.machine.model;

/**
 * @author Peter_Fazekas on 2017.03.18..
 */
public enum Change {
    ONE(0, 1),
    TWO(1, 2),
    FIVE(2, 5),
    TEN(3, 10),
    TWENTY(4, 20),
    FIFTY(5, 50),
    HUNDRED(6, 100);

    private final int index;
    private final int value;

    Change(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public static Change fromIndex(int index) {
        Change change = ONE;
        for (Change thisChange : Change.values()) {
            if (index == thisChange.index) {
                change = thisChange;
            }
        }
        return change;
    }

    public int getValue() {
        return value;
    }
}
