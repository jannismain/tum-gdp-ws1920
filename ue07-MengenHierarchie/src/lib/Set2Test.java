package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

class Set2Test {
    public static void main(String[] args) {
        OrderedListIntSet os1 = new OrderedListIntSet();

        // Einfuegen von Elementen:
        System.out.println("os1: " + os1);
        for (int i = 1; i < 10; i += 2) {
            os1.insert(i);
            System.out.println("os1: " + os1);
        }
        System.out.println("os1: " + os1);
        for (int i = 10; i > 0; i -= 2) {
            os1.insert(i);
            System.out.println("os1: " + os1);
        }

        // Ausgabe:
        System.out.println("os1: " + os1);

        // copy-Konstruktoren:
        OrderedListIntSet os2 = new OrderedListIntSet(os1);
        System.out.println("os2: " + os2);
        OrderedArrayIntSet as1 = new OrderedArrayIntSet(os1);
        System.out.println("as1: " + as1);
        OrderedListIntSet os3 = new OrderedListIntSet(as1);
        System.out.println("os3: " + os3);

        // liefert alles true:
        System.out.println(os1.contains(5));
        System.out.println(!os1.contains(50));
        System.out.println(os1.isSubset(os2));
        os1.insert(50);
        System.out.println(!os1.isSubset(os2));

        System.out.println("os1: " + os1);
        os1.delete(9);
        System.out.println("os1: " + os1);
        os1.delete(7);
        System.out.println("os1: " + os1);
        os1.delete(5);
        System.out.println("os1: " + os1);
        os1.delete(3);
        System.out.println("os1: " + os1);
        os1.delete(1);
        System.out.println("os1: " + os1);

    }
}
