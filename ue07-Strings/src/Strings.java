
public class Strings {
    public static void main(String[] args) {
        String s = "lagerregal";
        String s2 = "lager";
        System.out.println("String s = " + s);
        System.out.println("revert('lagerregal') = " + revert(s));
        System.out.println("isPalindrom(s) = " + isPalindrom(s));
        System.out.println("isPalindromRecursive(s) = " + isPalindromRecursive(s));
        System.out.println("String s2 = " + s2);
        System.out.println("revert(s2) = " + revert(s2));
        System.out.println("revert_recursive(s2) = " + revert_recursive(s2));
        System.out.println("isPalindrom(s2) = " + isPalindrom(s2));
        System.out.println("isPalindromRecursive(s2) = " + isPalindromRecursive(s2));
    }

    public static String revert(String s) {
        char[] cArr = s.toCharArray();
        char[] rrAc = new char[cArr.length];

        for (int i = cArr.length - 1; i >= 0; i--) {
            rrAc[cArr.length - i - 1] = cArr[i];
        }

        String result = new String(rrAc);
        return result;
    }

    public static String revert_recursive(String s) {
        return revert_embedded(s, 0);
    }

    public static String revert_embedded(String s, int i) {
        return i >= s.length() ? "" : "" + s.charAt(s.length() - 1 - i) + revert_embedded(s, i + 1);
    }

    public static boolean isPalindrom(String s) {
        return s.equals(revert(s));
    }

    public static boolean isPalindromRecursive(String s) {
        return isPalindromEmbedded(s.toCharArray(), 0);
    }

    public static boolean isPalindromEmbedded(char[] s, int i) {
        return s.length - 2 * i <= 1 ? true : s[i] == s[s.length - 1 - i] ? isPalindromEmbedded(s, i + 1) : false;
    }
}
