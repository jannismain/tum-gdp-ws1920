package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

public abstract class IntSet {

    // datenstrukturabhaengige, abstrakte Methoden:

    // liefert Enumeration ueber die Menge:
    public abstract IntEnumeration getEnumeration();

    // Einfuegen eines Elementes:
    public abstract void insert(int i);

    // Entfernen eines Elementes:
    public abstract void delete(int i);

    // datenstrukturunabhaengige Methoden:

    // Abfrage, ob Menge leer ist:
    public boolean isEmpty() {
        return size() == 0;
    }

    // Abfrage, ob Element enthalten ist:
    public boolean contains(int i) {

        IntEnumeration enu = getEnumeration();

        while (enu.hasMoreElements()) {
            int item = enu.nextElement();
            // Falls gefunden:
            if (item == i)
                return true;
        }
        // i nicht gefunden:
        return false;
    }

    // Abfrage nach Groesse der Menge:
    public int size() {

        // Testausgabe:
        System.out.println("size() aus IntSet");

        int result = 0;
        IntEnumeration enu = getEnumeration();
        while (enu.hasMoreElements()) {
            result++;
            enu.nextElement();
        }
        return result;
    }

    // Abfrage nach Teilmengeneigenschaft:
    public boolean isSubset(IntSet s) {

        // Testausgabe:
        System.out.println("isSubset() aus IntSet");

        IntEnumeration enu = getEnumeration();

        while (enu.hasMoreElements()) {

            if (!s.contains(enu.nextElement()))
                return false;
        }
        // Teilmengeneigenschaft ist nie verletzt:
        return true;
    }

    // Ausgabefunktion:
    public String toString() {
        String result = "{";
        IntEnumeration enu = getEnumeration();
        while (enu.hasMoreElements()) {
            result += enu.nextElement();
            if (enu.hasMoreElements())
                result += ",";
        }
        return result + "}";
    }
}
