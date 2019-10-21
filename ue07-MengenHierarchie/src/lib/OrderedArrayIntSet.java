package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

public class OrderedArrayIntSet extends OrderedIntSet {

    // Attribute (Datenstruktur):

    private static final int DEFAULT_CAPACITY = 5;
    private static final int DEFAULT_CAPACITY_INCREMENT = 5;
    private int currentSize; // aktuelle Groesse der Menge
    private int[] array; // speichert die Elemente der Menge

    // verschiedene Konstruktoren fuer eine leere Menge:

    // gewuenschte Reihungskapazitaet wird uebergeben
    public OrderedArrayIntSet(int capacity) {
        array = new int[capacity];
        currentSize = 0;
    }

    // Reihungskapazitaet richtet sich nach dem Default-Wert
    OrderedArrayIntSet() {
        this(DEFAULT_CAPACITY);
    }

    // Konstruktor, der die Kopie einer Menge liefert:

    // die Reihungsgroesse wird jeweils so gewaehlt, dass zusaetzliche
    // Elemente Platz finden

    // Zuerst ein Konstruktor speziell fuer sortierte Mengen:
    public OrderedArrayIntSet(OrderedIntSet s) {

        // Testausgabe:
        System.out.println("CopyKonstr. fuer OrderedIntSet aus OrderedArrayIntSet");

        currentSize = s.size();

        if (currentSize < DEFAULT_CAPACITY)
            array = new int[DEFAULT_CAPACITY];
        else
            array = new int[currentSize + DEFAULT_CAPACITY_INCREMENT];

        // ausgenutzt wird, dass die Elemente in s sortiert sind:
        int index = 0;
        IntEnumeration enu = s.getEnumeration();
        while (enu.hasMoreElements()) {
            array[index] = enu.nextElement();
            index++;
        }
    }

    // Sonst muss sich der Konstruktur auf insert abstuetzen:
    public OrderedArrayIntSet(IntSet s) {

        // Testausgabe:
        System.out.println("CopyKonstr. fuer bel. Mengen aus OrderedArrayIntSet");

        if (s.size() < DEFAULT_CAPACITY)
            array = new int[DEFAULT_CAPACITY];
        else
            array = new int[s.size() + DEFAULT_CAPACITY_INCREMENT];

        currentSize = 0; // vorerst ist Menge leer

        IntEnumeration enu = s.getEnumeration();
        while (enu.hasMoreElements())
            insert(enu.nextElement());
    }

    // sonstige datenstrukturabhaengige Methoden:

    // effiziente Abfrage nach Groesse der Menge:
    public int size() {

        // Testausgabe:
        System.out.println("size() aus OrderedArrayIntSet");

        return currentSize;
    }

    // liefert Enumeration ueber die Menge:
    public IntEnumeration getEnumeration() {
        return new ArrayIntSetEnumeration(currentSize, array);
    }

    // Einfuegen eines Elementes:
    public void insert(int i) {

        // Zunaechst Suche nach der Einfuegestelle:
        int index = 0;
        while (index < currentSize && array[index] < i)
            index++;

        // i darf noch nicht enthalten sein:
        if (index < currentSize && array[index] == i) {
            System.out.println("insert: " + i + " schon enthalten!");
            return;
        }

        // wenn ein neues Element noch hineinpasst:
        if (currentSize < array.length) {

            // Verschieben der restlichen Elemente nach rechts:
            for (int k = currentSize - 1; k >= index; k--)
                array[k + 1] = array[k];
        } else { // im anderen Fall muss eine groessere Reihung angelegt werden:

            // alte Reihung zwischenspeichern:
            int[] oldArray = array;

            // Neue Reihung anlegen:
            array = new int[currentSize + 1 + DEFAULT_CAPACITY_INCREMENT];

            // Umspeichern der vorne liegenden Elemente:
            for (int k = 0; k < index; k++)
                array[k] = oldArray[k];

            // Umspeichern der hinten liegenden Elemente mit Luecke:
            for (int k = index; k < currentSize; k++)
                array[k + 1] = oldArray[k];
        }

        // Speichern von i auf Position index:
        array[index] = i;

        // Konsistente Erhoehung von currentSize:
        currentSize++;

    }

    // Entfernen eines Elementes:
    public void delete(int i) {

        // Indexposition von i ermitteln:
        int index = 0;
        while (index < currentSize && array[index] < i)
            index++;

        if (index >= currentSize || array[index] > i) {
            // in diesem Fall ist i nicht in Menge enthalten
            System.out.println("delete: " + i + " nicht enthalten!");
            return;
        }

        // Sonst steht i auf Position index; i wird geloescht, indem
        // die Elemente rechts von Position index nach links umgespeichert
        // werden
        for (int k = index + 1; k < currentSize; k++)
            array[k - 1] = array[k];

        // Konsistente Verminderung von currentSize:
        currentSize--;

    }
}
