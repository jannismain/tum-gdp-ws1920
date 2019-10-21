// C. Herzog fuer Grundlagen der Programmierung, 21.11.2018
package lib;

class OrderedIntList {

    // Attribute:

    private int item; // Inhalt des listenelements
    private OrderedIntList next; // Verweis auf naechstes Element

    // Konstruktor:

    // Inhalt und Nachfolgeelement werden als Parameter uebergeben:
    private OrderedIntList(int item, OrderedIntList next) {
        this.item = item;
        this.next = next;
    }

    // Klassenmethoden:

    // length liefert die Laenge einer Liste:
    public static int length(OrderedIntList l) {
        if (l == null)
            return 0;
        return 1 + length(l.next);
    }

    // Test, ob ein Element in sortierter Liste enthalten ist:
    public static boolean isElement(int i, OrderedIntList l) {

        // Falls die Liste leer ist oder nur groessere Elemente enthaelt:
        if (l == null || l.item > i)
            return false;

        // Falls das erste Listenelement i enthaelt:
        if (l.item == i)
            return true;

        // Ansonsten arbeite rekursiv mit der Nachfolger-liste:
        return isElement(i, l.next);
    }

    // Einfuegen eines Elementes in sortierte Liste:
    public static OrderedIntList insertElement(int i, OrderedIntList l) {

        // Falls die Liste leer ist oder nur groessere Elemente enthaelt:
        if (l == null || l.item > i) {
            return new OrderedIntList(i, l);
        }

        // Falls das erste Listenelement i enthaelt:
        if (l.item == i) {
            System.out.println("insertElement: " + i + " schon vorhanden.");
            return l;
        }

        // Ansonsten arbeite rekursiv mit der Nachfolger-liste:
        l.next = insertElement(i, l.next);
        return l;
    }

    // Loeschen eines Elements aus sortierter Liste:
    public static OrderedIntList deleteElement(int i, OrderedIntList l) {

        // Falls die Liste leer ist oder nur groessere Elemente enthaelt:
        if (l == null || l.item > i) {
            System.out.println("deleteElement: " + i + " nicht vorhanden.");
            return l;
        }

        // Falls das erste Listenelement i enthaelt:
        if (l.item == i) {
            return l.next; // Hier wird i durch "Umleitung" geloescht
        }

        // Ansonsten arbeite rekursiv mit der Nachfolger-liste:
        l.next = deleteElement(i, l.next);
        return l;
    }

    // Liefert Kopie einer sortierten Liste:
    public static OrderedIntList copyList(OrderedIntList l) {
        if (l == null)
            return null;
        return new OrderedIntList(l.item, copyList(l.next));
    }

    // Sonstige Methoden:

    // liefert Inhalt des Listenelements
    public int getItem() {
        return item;
    }

    // liefert Verweis auf Nachfolger des Listenelements
    public OrderedIntList getNext() {
        return next;
    }

    // Ausgabefunktion:
    public String toString() {
        if (next == null)
            return "" + item;
        return item + ", " + next;
    }
}
