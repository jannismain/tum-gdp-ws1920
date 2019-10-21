public class Ampel {

    public Ampel() {
        next();
    }

    private final Licht[] Lichter = new Licht[] { new Licht("r"), new Licht("y"), new Licht("g") };
    private int state = 3;

    private void schalteAufRot() {
        this.Lichter[0].ein();
        this.Lichter[1].aus();
        this.Lichter[2].aus();
    }

    private void schalteAufRotGelb() {
        this.Lichter[0].ein();
        this.Lichter[1].ein();
        this.Lichter[2].aus();
    }

    private void schalteAufGruen() {
        this.Lichter[0].aus();
        this.Lichter[1].aus();
        this.Lichter[2].ein();
    }

    private void schalteAufGelb() {
        this.Lichter[0].aus();
        this.Lichter[1].ein();
        this.Lichter[2].aus();
    }

    public void next() {
        this.state = (this.state + 1) % (this.Lichter.length + 1);
        switch (this.state) {
            case 0:
                schalteAufRot();
                break;
            case 1:
                schalteAufRotGelb();
                break;
            case 2:
                schalteAufGruen();
                break;
            case 3:
                schalteAufGelb();
                break;
            default:
                schalteAufRot();
                break;
        }
        zeigeLichter();
    }

    public void zeigeLichter() {
        System.out.println("+--+ ");
        for (int i = 0; i < this.Lichter.length; i++) {
            System.out.print("|");
            System.out.print(this.Lichter[i].toString());
            System.out.println("|");
        }
        System.out.println("+--+");
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        Ampel a = new Ampel();
        a.next();
        a.next();
        a.next();
        a.next();
    }

}
