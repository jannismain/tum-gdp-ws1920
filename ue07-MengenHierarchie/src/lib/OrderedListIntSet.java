package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

class OrderedListIntSet extends OrderedIntSet {

    // Attribute (Datenstruktur):

    private OrderedIntList list; // speichert die Elemente der Menge

    // Konstruktor fuer eine leere Menge:

    OrderedListIntSet() {
        list = null;
    }

    // Konstruktor, der die Kopie einer Menge liefert:

    // Zuerst ein Konstruktur speziell fuer OrderedListIntSet:
    public OrderedListIntSet(OrderedListIntSet s) {

        // Testausgabe:
        System.out.println("CopyKonstr. fuer OrderedListIntSet aus OrderedListIntSet");

        list = OrderedIntList.copyList(s.list);
    }

    // Sonst muss sich der Konstruktur wenig effizient auf insertElement
    // abstuetzen:
    public OrderedListIntSet(IntSet s) {

        // Testausgabe:
        System.out.println("CopyKonstr. fuer beliebige Mengen aus OrderedListIntSet");

        list = null;
        IntEnumeration enu = s.getEnumeration();
        while (enu.hasMoreElements()) {
            list = OrderedIntList.insertElement(enu.nextElement(), list);
        }
    }

    // sonstige datenstrukturabhaengige Methoden:

    // effiziente Abfrage, ob Menge leer ist:
    public boolean isEmpty() {

        // Testausgabe:
        System.out.println("isEmpty() aus OrderedListIntSet");

        return list == null;
    }

    // liefert Enumeration ueber die Menge:
    public IntEnumeration getEnumeration() {
        return new OrderedListIntSetEnumeration(list);
    }

    // Einfuegen eines Elementes:
    public void insert(int i) {
        // stuetzt sich auf entsprechende Methode von OrderedIntList:
        list = OrderedIntList.insertElement(i, list);
    }

    // Entfernen eines Elementes:
    public void delete(int i) {
        // stuetzt sich auf entsprechende Methode von OrderedIntList:
        list = OrderedIntList.deleteElement(i, list);
    }
}
