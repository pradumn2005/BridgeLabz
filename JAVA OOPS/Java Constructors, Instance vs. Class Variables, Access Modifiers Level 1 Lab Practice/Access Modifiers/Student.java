class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    Student(int r, String n, double c) {
        rollNumber = r;
        name = n;
        CGPA = c;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double c) {
        CGPA = c;
    }
}
class PostgraduateStudent extends Student {
    String thesis;
    PostgraduateStudent(int r, String n, double c, String t) {
        super(r, n, c);
        thesis = t;
    }
    void display() {
        System.out.println("Roll: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
        System.out.println("Thesis: " + thesis);
    }
    public static void main(String[] args) {
        PostgraduateStudent p = new PostgraduateStudent(101, "Rahul", 8.7, "AI Research");
        p.display();
        p.setCGPA(9.0);
        System.out.println("Updated CGPA: " + p.getCGPA());
    }
}
