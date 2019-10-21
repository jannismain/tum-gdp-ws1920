package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

public abstract class OrderedIntSet extends IntSet {

    // Methoden, die bei Sortiertheit effizienter implementierbar sind:

    // Abfrage, ob Element enthalten ist:
    public boolean contains(int i) {

        IntEnumeration enu = getEnumeration();

        while (enu.hasMoreElements()) {
            int item = enu.nextElement();
            // Falls gefunden:
            if (item == i)
                return true;
            // Ordnung wird ausgenutzt:
            if (item > i)
                return false;
        }
        // i nicht gefunden:
        return false;
    }

    // Abfrage nach Teilmengeneigenschaft speziell bei sort. Eingabe:
    public boolean isSubset(OrderedIntSet s) {

        // Testausgabe:
        System.out.println("isSubset() fuer OrderedIntSet aus OrderedIntSet");

        // Enumeration der Menge selbst:
        IntEnumeration enu = getEnumeration();
        // Enumeration der anderen Menge:
        IntEnumeration enuS = s.getEnumeration();

        while (enu.hasMoreElements()) {
            int item = enu.nextElement();

            if (!enuS.hasMoreElements())
                return false;

            int itemS;

            // groessere Elemente in s ueberspringen:
            do {
                itemS = enuS.nextElement();
            } while (item > itemS && enuS.hasMoreElements());

            if (item != itemS)
                // Element der Menge kann nicht auch in s sein
                return false;
        }
        // Teilmengeneigenschaft ist nie verletzt:
        return true;
    }
}
