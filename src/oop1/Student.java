package oop1;

import java.util.Scanner;

public class Student {
    String name;
    double mathScore;
    double interatureScore;
    Scanner scanner = new Scanner(System.in);


    void input() {
        System.out.println("Nhập thông tin học sinh");
        System.out.println("Nhập tên học sinh : ");
        name = scanner.nextLine();

        System.out.println("Nhập điểm toán : ");
        mathScore = scanner.nextDouble();

        System.out.println("Nhập điểm văn : ");
        interatureScore = scanner.nextDouble();
    }

    double calAverageScore() {
        return (mathScore + interatureScore) / 2;
    }

    void output() {
        System.out.println("Tên học sinh : " + name);
        System.out.println("Điểm toán :" + mathScore);
        System.out.println("Điêm văn : " + interatureScore);
        System.out.println("Điểm trung bình : " + calAverageScore());
    }
}
