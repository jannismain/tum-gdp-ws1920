
public class EmptyMatrixException extends Exception {
    private static final long serialVersionUID = 1954966211519601920L;

    public EmptyMatrixException() {
        super("Matrix must have at least 1 column!");
    }
}
