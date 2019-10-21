import lib.IntSet;
import lib.IntEnumeration;
import lib.ArrayIntSet;

public class MengenHierarchie {
    public static void main(String[] args) throws Exception {
        IntSet s = new ArrayIntSet();
        s.insert(5);
        s.insert(7);
        s.insert(12);
        System.out.println("");
        System.out.println("         s = " + s.toString());
        System.out.println("");
        System.out.println("maximum(s) = " + maximum(s));
        System.out.println(" square(s) = " + square(s).toString());

    }

    /*
     * Aufgabe 25: Enumeration auf Mengen
     */
    public static int maximum(IntSet s) {
        int result = Integer.MIN_VALUE;
        IntEnumeration enu = s.getEnumeration();

        while (enu.hasMoreElements()) {
            int el = enu.nextElement();
            result = result < el ? el : result;
        }

        return result;
    }

    public static IntSet square(IntSet s) {
        IntSet result = new ArrayIntSet();
        IntEnumeration enu = s.getEnumeration();
        while (enu.hasMoreElements()) {
            int next = enu.nextElement();
            int next_squared = next * next;
            if (!result.contains(next_squared)) {
                result.insert(next_squared);
            }
        }
        return result;
    }
}
