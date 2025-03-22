package ss2;

import oop5.Person;

import java.util.Scanner;

public class Student extends Person {

    private double score;

    public Student() {
    }

    public Student(int id, String name, double score) {
        super(id, name);
        this.score = score;
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Nhap vao diem : ");
        this.score = Double.parseDouble(scanner.nextLine());
    }
    public void output() {
        super.output();
        System.out.println("Diem : " + this.score);
    }
}
