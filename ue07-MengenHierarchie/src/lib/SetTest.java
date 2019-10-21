package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

class SetTest {
    public static void main(String[] args) {
        OrderedArrayIntSet as1 = new OrderedArrayIntSet();

        // Einfuegen von Elementen:
        System.out.println("as1: " + as1);
        for (int i = 1; i < 10; i += 2) {
            as1.insert(i);
            System.out.println("as1: " + as1);
        }
        System.out.println("as1: " + as1);
        for (int i = 10; i > 0; i -= 2) {
            as1.insert(i);
            System.out.println("as1: " + as1);
        }

        // Ausgabe:
        System.out.println("as1: " + as1);

        // copy-Konstruktor:
        OrderedArrayIntSet as2 = new OrderedArrayIntSet(as1);
        System.out.println("as2: " + as2);

        // liefert alles true:
        System.out.println(as1.contains(5));
        System.out.println(!as1.contains(50));
        System.out.println(as1.isSubset(as2));
        as1.insert(50);
        System.out.println(!as1.isSubset(as2));

        System.out.println("as1: " + as1);
        as1.delete(9);
        System.out.println("as1: " + as1);
        as1.delete(7);
        System.out.println("as1: " + as1);
        as1.delete(5);
        System.out.println("as1: " + as1);
        as1.delete(3);
        System.out.println("as1: " + as1);
        as1.delete(1);
        System.out.println("as1: " + as1);

    }
}
