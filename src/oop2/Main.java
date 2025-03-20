package oop2;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point();
        Point point2 = new Point();

        System.out.println("Nhap toa do diem thu nhat ");
        point1.input();

        System.out.println("Nhap toa do diem thu hai ");
        point2.input();

        System.out.println("Khoang cach giua hai diem la : " + point1.distanceTo(point2));
    }

}
