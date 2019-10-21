
import java.util.Arrays;

import lib.*;

public class App {

    public static void main(String[] args) throws Exception {
        int[] a = { -1, 2, 2, 3, 3 };
        System.out.println("a = [-1, 2, 2, 3, 3]");
        System.out.println("compact(a) = " + Arrays.toString(compact(a)));

        OrderedArrayIntSet b = new OrderedArrayIntSet();
        b.insert(-3);
        b.insert(-1);
        b.insert(0);
        b.insert(5);
        b.insert(8);
        // b.insert(10);
        System.out.println("b: " + b.toString());
        OrderedArrayIntSet c = new OrderedArrayIntSet();
        c.insert(0);
        c.insert(6);
        c.insert(8);
        c.insert(14);
        System.out.println("c: " + c.toString());
        // System.out.println("union(b, c): " + b.union(c).toString());
    }

    /*
     * Aufgabe 20) Reihungen - verdichte
     */
    public static int[] compact(int[] a) {
        int[] r = new int[a.length];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (j == 0 || (j > 0 && r[j - 1] != a[i])) {
                r[j++] = a[i];
            }
        }
        return Arrays.copyOfRange(r, 0, j);
    }
}
