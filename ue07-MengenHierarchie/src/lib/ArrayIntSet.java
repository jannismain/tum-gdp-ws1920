package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

public class ArrayIntSet extends IntSet {

    // Attribute (Datenstruktur):

    private static final int DEFAULT_CAPACITY = 5;
    private static final int DEFAULT_CAPACITY_INCREMENT = 5;
    private int currentSize; // aktuelle Groesse der Menge
    private int[] array; // speichert die Elemente der Menge

    // verschiedene Konstruktoren fuer eine leere Menge:

    // gewuenschte Reihungskapazitaet wird uebergeben
    public ArrayIntSet(int capacity) {
        array = new int[capacity];
        currentSize = 0;
    }

    // Reihungskapazitaet richtet sich nach dem Default-Wert
    public ArrayIntSet() {
        this(DEFAULT_CAPACITY);
    }

    // Konstruktor, der die Kopie einer Menge liefert:

    // die Reihungsgroesse wird so gewaehlt, dass zusaetzliche
    // Elemente Platz finden
    public ArrayIntSet(IntSet s) {
        currentSize = s.size();

        if (currentSize < DEFAULT_CAPACITY)
            array = new int[DEFAULT_CAPACITY];
        else
            array = new int[currentSize + DEFAULT_CAPACITY_INCREMENT];

        // die Elemente aus s werden uebertragen:
        int index = 0;
        IntEnumeration enu = s.getEnumeration();
        while (enu.hasMoreElements()) {
            array[index] = enu.nextElement();
            index++;
        }
    }

    // sonstige datenstrukturabhaengige Methoden:

    // effiziente Abfrage nach Groesse der Menge:
    public int size() {

        // Testausgabe:
        System.out.println("size() aus ArrayIntSet");

        return currentSize;
    }

    // liefert Enumeration ueber die Menge:
    public IntEnumeration getEnumeration() {
        return new ArrayIntSetEnumeration(currentSize, array);
    }

    // Einfuegen eines Elementes:
    public void insert(int i) {

        // i darf noch nicht enthalten sein:
        if (contains(i)) {
            System.out.println("insert: " + i + " schon enthalten!");
            return;
        }

        // wenn neues Element nicht hineinpasst:
        if (currentSize >= array.length) {

            // alte Reihung zwischenspeichern:
            int[] oldArray = array;

            // Neue Reihung anlegen:
            array = new int[currentSize + 1 + DEFAULT_CAPACITY_INCREMENT];

            // Umspeichern der Elemente:
            for (int index = 0; index < currentSize; index++)
                array[index] = oldArray[index];
        }

        // Speichern von i auf letztem Platz:
        array[currentSize] = i;

        // Konsistente Erhoehung von currentSize:
        currentSize++;

    }

    // Entfernen eines Elementes:
    public void delete(int i) {

        // Indexposition von i ermitteln:
        for (int index = 0; index < currentSize; index++) {
            if (array[index] == i) {
                // i steht auf Position index; i wird geloescht, indem das
                // rechteste Element auf Position index umgespeichert wird:
                array[index] = array[currentSize - 1];
                // Konsistente Verminderung von currentSize:
                currentSize--;
                return;
            }
        }

        // ansonsten ist i nicht in Menge enthalten
        System.out.println("delete: " + i + " nicht enthalten!");
        return;
    }
}
