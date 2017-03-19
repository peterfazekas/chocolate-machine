package hu.chocolate.machine.view;

import hu.chocolate.machine.data.log.DataLogger;
import hu.chocolate.machine.data.log.FileDataLogger;
import hu.chocolate.machine.data.parse.DataParser;
import hu.chocolate.machine.data.read.DataReader;
import hu.chocolate.machine.data.read.FileDataReader;
import hu.chocolate.machine.model.Chocolate;
import hu.chocolate.machine.model.Purchase;
import hu.chocolate.machine.service.ChocolateMachine;
import hu.chocolate.machine.service.Console;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public class App {

    private static final int COMPARTMENT_NUMBER = 7;

    private final Console console;
    private final DataReader file;
    private final DataLogger log;
    private final DataParser data;
    private final ChocolateMachine machine;

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    public App() {
        console = new Console();
        file = new FileDataReader();
        data = new DataParser();
        log = FileDataLogger.createInstance(Sources.OUTPUT.getSource());
        List<Chocolate> chocolates = data.parse(file.read(Sources.CHOCOLATE.getSource()));
        List<Purchase> purchases = data.parse(file.read(Sources.PURCHASE.getSource()));
        machine = new ChocolateMachine(chocolates, purchases);
    }

    private void println() {
        System.out.println("2. feladat: Az automatában " + machine.getTotalValue() + " fabatka értékű csokoládé van.");
        System.out.println("3. feladat: A következő rekeszekből próbáltak meg vásárolni: " + machine.getCompartments());
        System.out.print("4. feladat: Kérje adja meg a 7 csokoládéra szánt pénzösszeget: ");
        System.out.println("   A megadott keretből az alábbi rekeszekből választhat: "
                + machine.getAvailableCompartments(console.readInt()));
        System.out.print("5. feladat: Adjon meg egy rekesz sorszámot és a darabszámot [x y]: ");
        Chocolate chocolate = data.createChocolate(console.read());
        System.out.println(machine.getPunctualAmountOfChanges(chocolate));
        log.println(machine.compartmentSeven(COMPARTMENT_NUMBER));
    }
}
