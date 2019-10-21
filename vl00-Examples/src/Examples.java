import java.lang.String;
import java.util.Arrays;

public class Examples {

    public static void main(String[] args) throws Exception {
        testShortCircuit(4);
        arrayInitialization();
    }

    public static void testShortCircuit(int input) {
        if ((input < 5) || (input / 0 == 15)) {
            System.out.println("Short-Circuit Evaluation");
        } else {
            System.out.println("An Exception should have been thrown!");
        }
    }

    public static void arrayInitialization() {
        // Direct Array Initialization
        int x[][] = { { 1 }, { 1 }, { 1 }, { 1 }, { 1 } };
        System.out.println(Arrays.deepToString(x));

        int z[][] = new int[3][];
        z[1] = new int[5];
        // Aufgabe: Komplettiere z zu einer rechteckigen Matrix gefüllt mit dem Wert 3
        for (int i = 0; i < z.length; i++) {
            z[i] = new int[] { 3, 3, 3, 3, 3 };
        }
        System.out.println(Arrays.deepToString(z));
    }
}
