
/**
 * Terminkalender
 *
 * @author Dr. Christian Herzog
 * @version: 1.0 (2019)
 * @see http://home.in.tum.de/~herzog/grprog/ws19/Terminkalender.java
 */

import java.util.Vector;

public class Terminkalender {

    private Vector<Termin> kalender = new Vector<Termin>(10, 5);

    public Terminkalender() {
        kalender.clear();
    }

    public void neuerTermin(Termin t) {
        kalender.add(t);
        Datum dat = t.getDatum();
        Uhrzeit beg = t.getBeginn();
        // Minuten zweistellig ausgeben
        String min = beg.getMinute() < 10 ? "0" + beg.getMinute() : "" + beg.getMinute();
        System.out.println("Der Termin am " + dat.getTag() + "." + dat.getMonat() + "." + dat.getJahr() + " um "
                + t.getBeginn().getStunde() + ":" + min + " Uhr wurde eingetragen");
        System.out.println();
    }

    private int sucheIndex(Termin t) {
        int i = 0, groesse = kalender.size();
        Termin ht;
        for (i = 0; i < groesse; i++) {
            ht = kalender.get(i);
            if ((ht.getDatum().getTag() == t.getDatum().getTag())
                    && (ht.getDatum().getMonat() == t.getDatum().getMonat())
                    && (ht.getDatum().getJahr() == t.getDatum().getJahr())
                    && (ht.getBeginn().getStunde() == t.getBeginn().getStunde())
                    && (ht.getBeginn().getMinute() == t.getBeginn().getMinute()))
                return i;
        }
        return -1;
    }

    public void loescheTermin(Termin t) {
        int i = sucheIndex(t);
        if (i >= 0)
            kalender.remove(i);
        else
            System.out.println("Termin nicht in Kalender enthalten");
    }

    public void terminueberblick(Datum d) {
        int i = 0, groesse = kalender.size();
        boolean gefunden = false;
        Termin ht;
        String min;
        System.out.println("Ihre Termine am " + d.getTag() + "." + d.getMonat() + "." + d.getJahr() + ":");
        for (i = 0; i < groesse; i++) {
            ht = kalender.get(i);
            if ((ht.getDatum().getTag() == d.getTag()) && (ht.getDatum().getMonat() == d.getMonat())
                    && (ht.getDatum().getJahr() == d.getJahr())) {
                // Minuten zweistellig ausgeben
                min = ht.getBeginn().getMinute() < 10 ? "0" + Integer.toString(ht.getBeginn().getMinute())
                        : Integer.toString(ht.getBeginn().getMinute());
                System.out.println("Uhrzeit: " + ht.getBeginn().getStunde() + ":" + min);
                System.out.println("Ort: " + ht.getAdresse());
                System.out.println("Bemerkung: " + ht.getBemerkung());
                System.out.println();
                gefunden = true;
            }
        }
        if (!gefunden)
            System.out.println("Fuer diesen Tag sind keine Termine eingetragen!");
    }
}
