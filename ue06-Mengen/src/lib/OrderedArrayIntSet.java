// C. Herzog fuer Grundlagen der Programmierung, 14.11.2018
package lib;

public class OrderedArrayIntSet {

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
    public OrderedArrayIntSet() {
        this(DEFAULT_CAPACITY);
    }

    // Konstruktor, der die Kopie einer Menge liefert:

    // die Reihungsgroesse wird so gewaehlt, dass zusaetzliche
    // Elemente Platz finden
    public OrderedArrayIntSet(OrderedArrayIntSet s) {
        currentSize = s.size();

        if (currentSize < DEFAULT_CAPACITY)
            array = new int[DEFAULT_CAPACITY];
        else
            array = new int[currentSize + DEFAULT_CAPACITY_INCREMENT];

        // ausgenutzt wird, dass die Elemente in s sortiert sind:
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
            if (array[index] == i) // Element gefunden
                return true;
            if (array[index] > i) // groesseres Element erreicht
                return false;
        }
        return false; // ansonsten Element nicht enthalten
    }

    // Abfrage nach Groesse der Menge:
    public int size() {
        return currentSize;
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

    // Abfrage nach Teilmengeneigenschaft:
    public boolean isSubset(OrderedArrayIntSet s) {

        int index = 0; // Index der Menge selbst
        int indexS = 0; // Index der anderen Menge s

        while (index < currentSize && indexS < s.size()) {
            if (array[index] < s.array[indexS])
                // Element der Menge kann nicht auch in s sein
                return false;
            if (array[index] > s.array[indexS])
                // s weiterschalten
                indexS++;
            else {
                // Element der Menge ist auch in s; beide Indizes
                // weiterschalten:
                index++;
                indexS++;
            }
        }

        // Teilmengeneigenschaft ist genau dann erfuellt, wenn index gesamte
        // Menge durchlaufen hat:
        return index >= currentSize;
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

    public boolean isEqual(OrderedArrayIntSet s) {
        if (size() != s.size())
            return false;
        for (int i = 0; i < size(); i++) {
            if (this.array[i] != s.array[i])
                return false;
        }
        return true;
    }

    public OrderedArrayIntSet union(OrderedArrayIntSet s) {
        OrderedArrayIntSet r = new OrderedArrayIntSet(size() + s.size());
        int i_r = 0, i_s = 0, i = 0;
        while (i < size() || i_s < s.size()) { // TODO: Fix this not terminating
            if (i < size() && (i_r == 0 || r.array[i_r - 1] != this.array[i]))
                if (this.array[i] <= s.array[i_s])
                    r.array[i_r++] = this.array[i++];
            if (i_s < s.size() && (i_r == 0 || r.array[i_r - 1] != s.array[i_s]))
                if (s.array[i_s] <= this.array[i])
                    r.array[i_r++] = s.array[i_s++];
            r.currentSize = i_r;
        }
        return r;
    }
}
