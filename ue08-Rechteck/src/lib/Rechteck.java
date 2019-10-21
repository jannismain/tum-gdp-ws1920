package lib;

abstract class Rechteck {

    protected double x1;
    protected double y1;
    protected double x2;
    protected double y2;

    protected double breite;
    protected double hoehe;

    public Rechteck() {
        this(0, 0, 5, 5);
    }

    public Rechteck(double x1, double y1, double x2, double y2) {
        this.breite = x2 - x1;
        this.hoehe = y2 - y1;
    }

    public double getBreite() {
        return this.breite;
    }

    public double getHoehe() {
        return this.hoehe;
    }

    abstract public Punkt getLinksUnten(); // liefert den Punkt links unten

    abstract public Punkt getRechtsOben(); // liefert den Punkt rechts oben

    abstract public double berechneFlaeche(); // liefert die Rechtecksflaeche

    abstract public void verschiebe(double deltaX, double deltaY);
    // verschiebt das Rechteck und
    // deltaX nach rechts und um
    // deltaY nach oben

}
