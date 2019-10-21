
import java.util.Arrays;

public class MatrixOperationen {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello MatrixOperationen");
        double[][] a = new double[][] { { 1, 2 }, { 3, 4 } };
        double[][] b = new double[][] { { 1, 2 }, { 3, 4 } };
        double[][] c = matrixMult(a, b);
        System.out.println("a*b=[" + Arrays.toString(c[0]) + ", " + Arrays.toString(c[1]) + "]");
        try {
            // matrixMult(new double[][] {}, new double[][] {}); // Empty Matrix
            matrixMult(new double[][] { { 1, 2 }, { 3, 4 } }, new double[][] { { 3, 4 } }); // Dimension Mismatch
        } catch (EmptyMatrixException e) {
            System.out.println("One of your matrices was empty: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("One of your matrix elements was null: " + e.getMessage());
        } catch (DimensionMismatchException e) {
            System.out.println("a must have as many rows as b has columns: " + e.getMessage());
        }
    }

    public static double[][] matrixMult(double[][] a, double[][] b) throws NullPointerException, EmptyMatrixException,
            EmptyRowException, RowMismatchException, DimensionMismatchException {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        if (a.length == 0 || b.length == 0) {
            throw new EmptyMatrixException();
        }
        int row_size = 0;
        for (double[][] m : new double[][][] { a, b }) {
            for (double[] row : m) {
                if (row == null) {
                    throw new NullPointerException();
                }
                if (row.length == 0) {
                    throw new EmptyRowException();
                }
                if (row_size == 0) {
                    row_size = row.length;
                } else if (row_size != row.length) {
                    throw new RowMismatchException();
                }
            }
        }
        if (a[0].length != b.length) {
            throw new DimensionMismatchException();
        }

        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < a[0].length; k++) {
                    sum += (a[i][k] * b[k][j]);
                }
                c[i][j] = sum;
            }
        }
        return c;
    }
}
