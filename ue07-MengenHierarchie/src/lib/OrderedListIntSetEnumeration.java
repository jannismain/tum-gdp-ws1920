package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

class OrderedListIntSetEnumeration extends IntEnumeration {
    // direkter Zugriff auf das Attribut list der zugehoerigen Menge:
    private OrderedIntList list;

    // das Attribut list der zugehoerigen Menge wird als Parameter uebergeben:
    public OrderedListIntSetEnumeration(OrderedIntList list) {
        this.list = list;
    }

    public boolean hasMoreElements() {
        // genau dann, wenn Liste nicht leer ist:
        return list != null;
    }

    public int nextElement() {
        // vor dem Weiterschalten Inhalt merken:
        int i = list.getItem();
        // weiterschalten:
        list = list.getNext();
        // gemerkten Inhalt ausliefern:
        return i;
    }
}
