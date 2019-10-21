class F1Ampel {

    private final Licht[] Lichter = new Licht[] { new Licht(), new Licht(), new Licht(), new Licht(), new Licht() };

    public F1Ampel() {
    }

    public void next() {
        int count = 0;
        for (Licht licht : Lichter) {
            if (!licht.istAn()) {
                licht.ein();
                break;
            } else {
                count++;
            }
        }
        if (count == 5) {
            for (Licht licht : Lichter) {
                licht.aus();
            }
        }
        System.out.println(this.toString());
    }

    public String toString() {
        String ret = "";
        for (Licht licht : Lichter) {
            ret = ret.concat(licht.toString());
        }
        return ret;
    }

    public static void main(String[] args) {
        F1Ampel a = new F1Ampel();
        a.next();
        a.next();
        a.next();
        a.next();
        a.next();
        a.next();
    }

}
