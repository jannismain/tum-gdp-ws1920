// C. Herzog fuer Grundlagen der Programmierung, 14.11.2018
package lib;

class ArrayIntSet {

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
    ArrayIntSet() {
        this(DEFAULT_CAPACITY);
    }

    // Konstruktor, der die Kopie einer Menge liefert:

    // die Reihungsgroesse wird so gewaehlt, dass zusaetzliche
    // Elemente Platz finden
    public ArrayIntSet(ArrayIntSet s) {
        currentSize = s.size();

        if (currentSize < DEFAULT_CAPACITY)
            array = new int[DEFAULT_CAPACITY];
        else
            array = new int[currentSize + DEFAULT_CAPACITY_INCREMENT];

        // die Elemente aus s werden uebertragen:
        for (int index = 0; index < currentSize; index++)
            array[index] = s.array[index];
    }

    // sonstige Methoden:

    // Abfrage, ob Menge leer ist:
    public boolean isEmpty() {
        return size() == 0;
    }

    // Abfrage, ob Element enthalten ist:
    public boolean contains(int i) {
        for (int index = 0; index < currentSize; index++) {
            if (array[index] == i)
                return true;
        }
        return false;
    }

    // Abfrage nach Groesse der Menge:
    public int size() {
        return currentSize;
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

    // Abfrage nach Teilmengeneigenschaft:
    public boolean isSubset(ArrayIntSet s) {

        // Bei jedem Element der Menge wird ueberprueft, ob es auch
        // in der anderen Menge s enthalten ist:

        for (int index = 0; index < currentSize; index++) {
            if (!s.contains(array[index]))
                // Teilmengeneigenschaft verletzt:
                return false;
        }

        // Teilmengeneigenschaft nie verletzt:
        return true;
    }

    // Ausgabefunktion:
    public String toString() {
        String result = "{";
        for (int index = 0; index < currentSize; index++) {
            result += array[index];
            if (index < currentSize - 1)
                result += ", ";
        }
        return result + "}";
    }

    public static void main(String[] args) {
        System.out.println("Leere Menge als neues Objekt mit Platz fuer 4 Elemente:");
        ArrayIntSet s = new ArrayIntSet(4);
        System.out.println("s: " + s);

        System.out.println("Einfuegen von 7:");
        s.insert(7);
        System.out.println("s: " + s);

        System.out.println("Einfuegen von -1:");
        s.insert(-1);
        System.out.println("s: " + s);

        System.out.println("Einfuegen von 4:");
        s.insert(4);
        System.out.println("s: " + s);

        System.out.println("Einfuegen von 9:");
        s.insert(9);
        System.out.println("s: " + s);

        System.out.println("Einfuegen von -1:");
        s.insert(-1);
        System.out.println("s: " + s);

        System.out.println("Loeschen von -1:");
        s.delete(-1);
        System.out.println("s: " + s);

        System.out.println("Loeschen von 5:");
        s.delete(5);
        System.out.println("s: " + s);

        System.out.println("Einfuegen von 5:");
        s.insert(5);
        System.out.println("s: " + s);

        System.out.println("Einfuegen von 8:");
        s.insert(8);
        System.out.println("s: " + s);

    }
}
