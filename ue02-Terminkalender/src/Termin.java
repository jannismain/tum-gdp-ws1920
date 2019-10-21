public class Termin {

    public Termin(Datum date, Uhrzeit time, String title, String location) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.title = title;
    }

    private Datum date;
    private Uhrzeit time;
    private String location;
    private String title;

    public Datum getDatum() {
        return date;
    }

    public Uhrzeit getBeginn() {
        return this.time;
    }

    public String getBemerkung() {
        return this.title;
    }

    public String getAdresse() {
        return this.location;
    }

}
