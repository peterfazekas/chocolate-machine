package hu.chocolate.machine.view;

import hu.chocolate.machine.data.log.DataLogger;
import hu.chocolate.machine.data.log.FileDataLogger;
import hu.chocolate.machine.service.ChocolateMachine;
import hu.chocolate.machine.service.Console;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
class App {

    private static final String OUTPUT = "rekesz7.txt";
    private static final int COMPARTMENT_NUMBER = 7;

    private final Console console;
    private final DataLogger log;
    private final ChocolateMachine machine;

    private App() {
        console = new Console();
        log = FileDataLogger.createInstance(OUTPUT);
        machine = new ChocolateMachine();
    }

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    private void println() {
        System.out.println("2. feladat: Az automatában " + machine.getTotalValue() + " fabatka értékű csokoládé van.");
        System.out.println("3. feladat: A következő rekeszekből próbáltak meg vásárolni: " + machine.getCompartments());
        System.out.print("4. feladat: Kérje adja meg a 7 csokoládéra szánt pénzösszeget: ");
        System.out.println("   A megadott keretből az alábbi rekeszekből választhat: "
                + machine.getAvailableCompartments(console.readInt()));
        System.out.print("5. feladat: Adjon meg egy rekesz sorszámot és a darabszámot [x y]: ");
        System.out.println(machine.getPunctualAmountOfChanges(console.read()));
        log.println(machine.compartmentSeven(COMPARTMENT_NUMBER));
    }
}
