package ss3_static.exercise1;

public class Student {
    int id;
    String name;
    double score;
    static int studentCount = 0;

    public Student(){
        studentCount ++;
    }

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        studentCount++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    static int count() {
        return studentCount;
    }

}
