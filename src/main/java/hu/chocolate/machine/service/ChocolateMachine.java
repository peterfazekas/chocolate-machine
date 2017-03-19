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
    public static final String TAB = "\t";
    private final List<Chocolate> chocolates;
    private final List<Purchase> purchases;

    public ChocolateMachine(List<Chocolate> chocolates, List<Purchase> purchases) {
        this.chocolates = chocolates;
        this.purchases = purchases;
    }

    /**
     * 2. feladat: Milyen értékben van csokoládé az automatában? Írja képernyőre a választ!
     *
     * @return az automatában lévő árú ellenértéke
     */
    public int getTotalValue() {
        return chocolates.stream()
                .mapToInt(i -> i.getCount() * i.getPrice())
                .sum();
    }

    /**
     * 3. feladat: Írja a képernyőre, hogy mely rekeszekből próbáltak csokoládét vásárolni!
     * Minden rekesz sorszámát csak egyszer jelenítse meg!
     * A számokat egymástól szóközzel elválasztva tüntesse fel!
     *
     * @return String - a megfelelő válasz.
     */
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

    /**
     * 4. feladat: Anna magának és barátainak összesen 7 egyforma csokoládét szeretne vásárolni.
     * Kérje be a csokoládéra szánt pénzösszeget! Írja a képernyőre azon rekeszek sorszámát,
     * amelyek közül választhat! A rekeszek sorszámát szóközökkel válassza el egymástól!
     *
     * @param value - a csokoládéra szánt pénzösszeg.
     * @return String - a megfelelő válasz.
     */
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

    /**
     * 5. feladat: Okos Péter szeret mindenütt pontosan annyi pénzt átadni, amennyi a fizetendő összeg.
     * Ezen túl szeret úgy fizetni, hogy a lehető legkevesebb pénzérmét, bankjegyet kelljen átadnia.
     * Kérje be egy rekesz sorszámát és a darabszámot, majd írja ki, hogy a felhasznált pénzérmékből
     * címletenként hány darabot kell bedobnia Péternek! Csak a felhasznált címleteket adja meg!
     * Egy sorba egy címlet kerüljön; először a címlet értéke, majd mögötte a darabszám jelenjen meg!
     * Nem kell vizsgálnia, hogy van-e elég csokoládé a rekeszben!
     *
     * @param find - {@link Chocolate} - rekesz sorszáma és darabszám
     * @return String - a megfelelő válasz.
     */
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
        List<Integer> changes = createBankNoteList();
        int total = value;
        StringBuilder sb = new StringBuilder("   A fizetendő összeg: " + value + " fabatka, címletekben:");
        for (int change : changes) {
            int div = total / change;
            total -= div * change;
            if (div > 0) {
                sb.append(NEW_LINE + "   " + change + ": " + div);
            }
        }
        return sb.toString();
    }

    private List<Integer> createBankNoteList() {
        List<Integer> changes = new ArrayList<>();
        Arrays.stream(Change.values())
                .mapToInt(i -> i.getValue())
                .forEach(changes::add);
        changes.sort(Comparator.reverseOrder());
        return changes;
    }

    /**
     * 6. feladat: Írja a rekesz7.txt állományba, hogy hányas sorszámú vásárlások során hány darabot vettek a
     * 7-es rekeszből! Vegye figyelembe, hogy minden sikeres vásárlással csökken a rekeszben lévő csokoládék száma!
     * Soronként egy vásárlási próbálkozást tüntessen fel! A sor elején a vásárlási próbálkozás sorszáma jelenjen meg,
     * tőle tabulátorral (ASCII kódja a 9-es) elválasztva pedig a vásárlás eredménye legyen olvasható!
     * Az eredmény sikeres vásárlás esetén a darabszám. Ha nem volt megadott mennyiségnek megfelelő csokoládé,
     * akkor a sorszám mögé a „kevés a csoki” üzenet kerüljön! Ha a vásárló által bedobott pénzösszeg kevés,
     * akkor a „nem volt elég pénz” szöveget írja a fájlba! Amennyiben a vásárlás több okból is meghiúsulhat,
     * elegendő csak az egyik okot megjeleníteni.
     */
    public String compartmentSeven(final int compartment) {
        Chocolate chocolate = getChocolate(compartment);
        StringBuilder sb = new StringBuilder();
        purchases.stream()
                .filter(i -> i.getCompartment() == compartment)
                .forEach(i -> {
                    sb.append(i.getId() + TAB);
                    if (chocolate.getCount() < i.getCount() && chocolate.getPrice() * i.getCount() > i.getPrice()) {
                        sb.append("kevés a csoki és nem volt elég pénz!" + NEW_LINE);
                    } else if (chocolate.getCount() < i.getCount()) {
                        sb.append("kevés a csoki!" + NEW_LINE);
                    } else if (chocolate.getPrice() * i.getCount() > i.getPrice()) {
                        sb.append("nem volt elég pénz!" + NEW_LINE);
                    } else {
                        chocolate.setCount(chocolate.getCount() - i.getCount());
                        sb.append(i.getCount() + NEW_LINE);
                    }
                });
        return sb.toString();
    }
}
