public class Uhrzeit {

    public Uhrzeit(Integer hour, Integer minute) {
        this.hour = hour;
        this.minute = minute;
    }

    private Integer hour;
    private Integer minute;

    public Integer getMinute() {
        return this.minute;
    }

    public Integer getStunde() {
        return this.hour;
    }
}
