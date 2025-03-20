package oop2;

import java.util.Scanner;

public class Point {
    double x;
    double y;

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tọa độ x của điểm : ");
        x = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập tọa độ y của điểm : ");
        y = Double.parseDouble(scanner.nextLine());
    }

    double distanceTo(Point point) {
        return Math.sqrt(Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2));
    }
}
