public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(f(5, 3));
    }

    public static int f(int a, int b) {
        return a == b ? 1 : f(a, a) + f(a + 1, b);
    }
}
