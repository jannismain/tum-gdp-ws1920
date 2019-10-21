package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

class ArrayIntSetEnumeration extends IntEnumeration {

    // direkter Zugriff auf die Attribute zugehoerigen Menge:
    private int currentSize;
    private int[] array;
    // Index, der die Menge durchlaeuft:
    private int index;

    // die Attribute der zugehoerigen Menge werden als Parameter uebergeben:
    public ArrayIntSetEnumeration(int currentSize, int[] array) {
        this.currentSize = currentSize;
        this.array = array;
        index = 0;
    }

    public boolean hasMoreElements() {
        // genau dann, wenn index noch nicht currentSize erreicht hat:
        return index < currentSize;
    }

    public int nextElement() {
        // weiterschalten:
        index++;
        // Inhalt des vorherr aktuellen Elements ausliefern:
        return array[index - 1];
    }
}
