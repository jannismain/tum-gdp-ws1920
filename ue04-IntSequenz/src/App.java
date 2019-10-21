public class App {

    public static void main(String[] args) throws Exception {
        IntSequenz n = new IntSequenz();
        System.out.println("Create (5, 7, 12):");
        IntSequenz s = n.stock(5, n.stock(7, n.stock(12, n)));
        IntSequenz s2 = n.stock(5, n.stock(7, n.stock(7, n.stock(5, new IntSequenz()))));
        IntSequenz s3 = n.stock(5, n.stock(7, n.stock(5, new IntSequenz())));
        System.out.println("--> " + s.toString());
        System.out.println("Summe: ");
        System.out.println("--> " + summe(s));
        System.out.println("Last: ");
        System.out.println("--> " + last(s));
        System.out.println("Concat with (1, 4): ");
        System.out.println("--> " + conc(s, n.stock(1, n.stock(4, n.create()))).toString());
        System.out.println("Init (5, 7, 12): ");
        System.out.println("--> " + init(s).toString());
        System.out.println("Merge with (4, 7, 65): ");
        System.out.println("--> " + merge(s, n.stock(4, n.stock(7, n.stock(65, n.create())))).toString());
        System.out.println("Revert (5, 7, 12): ");
        System.out.println("--> " + revert(s).toString());
        System.out.println("isPalindrom (5, 7, 7, 5): ");
        System.out.println("--> " + isPalindrom(s2));
        System.out.println("isPalindrom (5, 7, 5): ");
        System.out.println("--> " + isPalindrom(s3));
    }

    /*
     * Aufgabe 14) Zahlenfolgen
     */
    public static int summe(IntSequenz s) {
        return s.isEmpty(s) ? 0 : s.first(s) + summe(s.rest(s));
    }

    public static int last(IntSequenz s) {
        return s.isEmpty(s.rest(s)) ? s.first(s) : last(s.rest(s));
    }

    public static IntSequenz init(IntSequenz s) {
        return s.isEmpty(s.rest(s)) ? s.create() : s.stock(s.first(s), init(s.rest(s)));
    }

    public static IntSequenz conc(IntSequenz s1, IntSequenz s2) {
        return s1.isEmpty(s1) ? s2 : s2.stock(s1.first(s1), conc(s1.rest(s1), s2));
    }

    /*
     * Aufgabe 19) Zahlenfolge - mische
     */
    public static IntSequenz merge(IntSequenz s1, IntSequenz s2) {
        return s1.isEmpty(s1) ? s2
                : s2.isEmpty(s2) ? s1
                        : s1.first(s1) == s2.first(s2) ? s1.stock(s1.first(s1), merge(s1.rest(s1), s2.rest(s2)))
                                : s1.first(s1) <= s1.first(s2) ? s1.stock(s1.first(s1), merge(s1.rest(s1), s2))
                                        : s1.stock(s2.first(s2), merge(s2.rest(s2), s1));
    }

    /*
     * Aufgabe 23: Zahlenfolge - Palindrom
     */
    public static IntSequenz revert(IntSequenz s) {
        return s.isEmpty(s) ? new IntSequenz() : s.stock(last(s), revert(init(s)));
    }

    /*
     * Aufgabe 23b) Zahlenfolgen - Palindrom
     */
    public static boolean isPalindrom(IntSequenz s) {
        return s.isEmpty(s) ? true
                : s.isEmpty(s.rest(s)) ? true : s.first(s) == last(s) ? isPalindrom(s.rest(init(s))) : false;
    }
}
