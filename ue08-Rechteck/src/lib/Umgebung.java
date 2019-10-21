package lib;

public class Umgebung {

    public static void main(final String[] args) {
        System.out.println("MeinRechteck(2, 2, 8, 8)");
        MeinRechteck r = new MeinRechteck(2, 2, 8, 8);
        System.out.println(r.toString());
        System.out.println("Breite: " + r.getBreite());
        System.out.println("Hoehe: " + r.getHoehe());
        System.out.println("Flaeche: " + r.berechneFlaeche());
        System.out.println("Verschiebe horizontal um 3...");
        r.verschiebe(3, 0);
        System.out.println(r.toString());
        System.out.println("");
        System.out.println("MeinRechteck()");
        MeinRechteck r2 = new MeinRechteck();
        System.out.println(r2.toString());
    }

}
