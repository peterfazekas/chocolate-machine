package hu.chocolate.machine.service;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.03.19..
 */
public class Console {

    public int readInt() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String read() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
