public class Datum {

    public Datum(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private int year;
    private int month;
    private int day;

    public Integer getJahr() {
        return this.year;
    }

    public Integer getMonat() {
        return this.month;
    }

    public Integer getTag() {
        return this.day;
    }
}
