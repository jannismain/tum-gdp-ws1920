public class Student {

    public Student(String n, int m) {
        name = n;
        matrikelNr = m;
    }

    private String name;
    private int matrikelNr;

    public String getName() {
        return name;
    }

    public int getMatrikelNr() {
        return matrikelNr;
    }

    public static void main(String[] args) {
        Student s = new Student("Viola", 1234);
        System.out.println(s.getName());
        System.out.println(s.getMatrikelNr());
    }
}
