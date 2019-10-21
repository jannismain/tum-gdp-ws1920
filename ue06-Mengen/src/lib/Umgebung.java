// C. Herzog fuer Grundlagen der Programmierung, 21.11.2018

package lib;

class Umgebung {
    public static void main(String[] args) {
        ArrayIntSet ais = new ArrayIntSet(4);
        System.out.println("ais: " + ais);
        OrderedArrayIntSet oais = new OrderedArrayIntSet(4);
        System.out.println("oais: " + oais);
        OrderedListIntSet olis = new OrderedListIntSet();
        System.out.println("olis: " + olis);
        System.out.println();

        ais.insert(7);
        System.out.println("ais: " + ais);
        oais.insert(7);
        System.out.println("oais: " + oais);
        olis.insert(7);
        System.out.println("olis: " + olis);
        System.out.println();

        ais.insert(-1);
        System.out.println("ais: " + ais);
        oais.insert(-1);
        System.out.println("oais: " + oais);
        olis.insert(-1);
        System.out.println("olis: " + olis);
        System.out.println();

        ais.insert(4);
        System.out.println("ais: " + ais);
        oais.insert(4);
        System.out.println("oais: " + oais);
        olis.insert(4);
        System.out.println("olis: " + olis);
        System.out.println();

        ais.insert(9);
        System.out.println("ais: " + ais);
        oais.insert(9);
        System.out.println("oais: " + oais);
        olis.insert(9);
        System.out.println("olis: " + olis);
        System.out.println();

        ais.delete(-1);
        System.out.println("ais: " + ais);
        oais.delete(-1);
        System.out.println("oais: " + oais);
        olis.delete(-1);
        System.out.println("olis: " + olis);
        System.out.println();

        ais.insert(5);
        System.out.println("ais: " + ais);
        oais.insert(5);
        System.out.println("oais: " + oais);
        olis.insert(5);
        System.out.println("olis: " + olis);
        System.out.println();

        ais.insert(8);
        System.out.println("ais: " + ais);
        oais.insert(8);
        System.out.println("oais: " + oais);
        olis.insert(8);
        System.out.println("olis: " + olis);
        System.out.println();

    }
}
