
/**
 * IntSequenz
 *
 * Die Klasse IntSequenz ist gedacht, um in Java eine rein funktionale,
 * rekursive Datenstruktur vorzutaeuschen. Dafuer sind viele unschoene
 * Kompromisse eingegangen worden. Deshalb am besten die Klasse nicht naeher
 * anschauen! - C. Herzog im November 2019
 *
 * @author Dr. Christian Herzog
 * @version 1.0 (November 2019)
 * @see http://home.in.tum.de/~herzog/grprog/ws19/IntSequenz.java
 */

public class IntSequenz {

    // Sequenz ueber lineare Liste implementiert
    // Leere Liste ist durch leeren next-Verweis gekennzeichnet

    private int item;
    private IntSequenz next;

    // Konstruktoren
    public IntSequenz() {
        next = null;
    }

    private IntSequenz(int i, IntSequenz s) {
        s.item = i;
        next = s;
    }

    // Behandlung undefinierter Werte
    public int bottomInt() {
        throw new RuntimeException("Undefinierter Wert fuer Integer!");
    }

    public IntSequenz bottomIntSequenz() {
        throw new RuntimeException("Undefinierter Wert fuer IntSequenz!");
    }

    // Operationen zur "funktionalen" Erzeugung von Sequenzen
    public IntSequenz create() {
        return new IntSequenz();
    }

    public IntSequenz stock(int i, IntSequenz s) {
        return new IntSequenz(i, s);
    }

    // Testet, ob eine Zeichenfolge leer ist
    public boolean isEmpty(IntSequenz s) {
        return (s.next == null);
    }

    // Gibt das erste Element der IntSequenz s zurueck
    public int first(IntSequenz s) {
        return (isEmpty(s)) ? bottomInt() : s.next.item;
    }

    // Gibt die um das erste Element verkuerzte Zeichenfolge zurueck
    public IntSequenz rest(IntSequenz s) {
        return (isEmpty(s)) ? bottomIntSequenz() : s.next;
    }

    // rekursive Hilfsmethode fuer toString:
    private String content(IntSequenz s) {
        return isEmpty(s) ? "" : isEmpty(rest(s)) ? "" + first(s) : "" + first(s) + ", " + content(rest(s));
    }

    // Die Methode toString:
    public String toString() {
        return "(" + content(this) + ")";
    }

    // Und hier die Erweiterungen aus der Vorlesung:
    public int laenge(IntSequenz s) {
        return isEmpty(s) ? 0 : laenge(rest(s)) + 1;
    }

    public boolean istAnfang(IntSequenz a, IntSequenz s) {
        return isEmpty(a) ? true : isEmpty(s) ? false : first(a) != first(s) ? false : istAnfang(rest(a), rest(s));
    }

    public boolean istTeilsequenz(IntSequenz t, IntSequenz s) {
        return isEmpty(t) ? true : isEmpty(s) ? false : istAnfang(t, s) ? true : istTeilsequenz(t, rest(s));
    }

    private int minimumBett(IntSequenz s, int altesMin) {
        return isEmpty(s) ? altesMin
                : first(s) < altesMin ? minimumBett(rest(s), first(s)) : minimumBett(rest(s), altesMin);
    }

    public int minimum(IntSequenz s) { // Voraussetzung: s nicht leer!
        return minimumBett(rest(s), first(s));
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public int minimum2(IntSequenz s) { // Voraussetzung: s nicht leer!
        return isEmpty(rest(s)) ? first(s) : min(first(s), minimum2(rest(s)));
    }

}
