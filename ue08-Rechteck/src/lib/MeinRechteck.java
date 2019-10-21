package lib;

class MeinRechteck extends Rechteck {

    private Punkt rechtsOben;
    private Punkt linksUnten;

    public MeinRechteck() {
        this(0, 0, 5, 5);
    }

    // Konstruktor
    public MeinRechteck(double x1, double y1, double x2, double y2) {
        super(x1, y2, x2, y2);
        this.linksUnten = new Punkt(x1, y1);
        this.rechtsOben = new Punkt(x2, y2);
    }

    public MeinRechteck(Punkt linksUnten, Punkt rechtsOben) {
        this(linksUnten.getX(), linksUnten.getY(), rechtsOben.getX(), rechtsOben.getY());
        this.linksUnten = linksUnten;
        this.rechtsOben = rechtsOben;
    }

    // Methoden
    // Wir setzen voraus, dass die Namen der Punkte deren relative Position
    // beschreiben.
    public double getBreite() { // liefert die Breite
        return this.breite;
    }

    public double getHoehe() { // liefert die Hoehe
        return this.hoehe;
    }

    public Punkt getLinksUnten() { // liefert den Punkt links unten
        return this.linksUnten;
    }

    public Punkt getRechtsOben() { // liefert den Punkt rechts oben
        return this.rechtsOben;
    }

    public double berechneFlaeche() { // liefert die Rechtecksflaeche
        return this.breite * this.hoehe;
    }

    public void verschiebe(double deltaX, double deltaY) {
        this.linksUnten = new Punkt(this.getLinksUnten().getX() + deltaX, this.getLinksUnten().getY() + deltaY);
        this.rechtsOben = new Punkt(this.getRechtsOben().getX() + deltaX, this.getRechtsOben().getY() + deltaY);
    }

    public String toString() {
        return "<MeinRechteck " + "P1(" + this.linksUnten.getX() + ", " + this.linksUnten.getY() + "), " + "P2("
                + this.rechtsOben.getX() + ", " + this.rechtsOben.getY() + ")" + ">";
    }

}
