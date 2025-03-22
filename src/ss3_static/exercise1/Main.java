package ss3_static.exercise1;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student(122, "Nguyen Nhat Kha", 9.5);
        Student student3 = new Student(123, "Nguyen Khang", 9.5);

        int count = Student.count();
        System.out.println("So luong : " + count);
    }
}
