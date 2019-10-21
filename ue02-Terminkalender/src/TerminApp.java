public class TerminApp {

    public static void main(String args[]) {
        Terminkalender t = new Terminkalender();
        Datum d = new Datum(2019, 2, 14);
        Datum d2 = new Datum(2018, 11, 30);
        Termin t1 = new Termin(d, new Uhrzeit(14, 22), "💖 Valentinstag 💖", "Garching Forschungszentrum");
        Termin t2 = new Termin(d2, new Uhrzeit(19, 50), "Mein Geburtstag", "Altötting am Inn");
        t.neuerTermin(t1);
        t.neuerTermin(t2);
        t.terminueberblick(d);
        t.terminueberblick(d2);
        t.loescheTermin(t1);
        t.loescheTermin(t2);
    }
}
