class Licht {

    private final String AUS = "⚫️";

    private String color;
    private boolean an = false;

    public Licht() {
        this("r");
    }

    public Licht(String color) {
        this.color = color;
    }

    public void ein() {
        this.an = true;
    }

    public void aus() {
        this.an = false;
    }

    public boolean istAn() {
        return this.an;
    }

    public String toString() {
        switch (color) {
            case "r":
                return an ? "🔴" : AUS;
            case "y":
                return an ? "🟡" : AUS;
            case "g":
                return an ? "🟢" : AUS;
            default:
                return AUS;
        }
    }
}
