// C. Herzog fuer Grundlagen der Programmierung, 14.11.2018
package lib;

class OrderedListIntSet {

    // Attribute (Datenstruktur):

    private OrderedIntList list; // speichert die Elemente der Menge

    // Konstruktor fuer eine leere Menge:

    OrderedListIntSet() {
        list = null;
    }

    // Konstruktor, der die Kopie einer Menge liefert:

    public OrderedListIntSet(OrderedListIntSet s) {
        list = OrderedIntList.copyList(s.list);
    }

    // sonstige Methoden:

    // Abfrage, ob Menge leer ist:
    public boolean isEmpty() {
        return size() == 0;
    }

    // Abfrage, ob Element enthalten ist:
    public boolean contains(int i) {
        // stuetzt sich auf entsprechende Methode von OrderedIntList:
        return OrderedIntList.isElement(i, list);
    }

    // Abfrage nach Groesse der Menge:
    public int size() {
        // stuetzt sich auf entsprechende Methode von OrderedIntList:
        return OrderedIntList.length(list);
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

    // Abfrage nach Teilmengeneigenschaft:
    public boolean isSubset(OrderedListIntSet s) {

        OrderedIntList l = list; // Pegel der Menge selbst
        OrderedIntList lS = s.list; // Pegel der anderen Menge s

        while (l != null && lS != null) {
            if (l.getItem() < lS.getItem())
                // Element der Menge kann nicht auch in s sein
                return false;
            if (l.getItem() > lS.getItem())
                // s weiterschalten
                lS = lS.getNext();
            else {
                // Element der Menge ist auch in s; beide Pegel
                // weiterschalten:
                l = l.getNext();
                lS = lS.getNext();
            }
        }

        // Teilmengeneigenschaft ist genau dann erfuellt, wenn l die gesamte
        // Menge durchlaufen hat:
        return l == null;
    }

    // Ausgabefunktion:
    public String toString() {
        String result = "{";
        if (list != null)
            result += list;
        return result + "}";
    }
}
