package ss4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int a;
        do {
            System.out.println("----CHUONG TRINH QUAN LI DIEN THOAI----- ");
            System.out.println("Xem danh sach dien thoai");
            System.out.println("Them moi ");
            System.out.println("Cap Nhat");
            System.out.println("Xoa");
            System.out.println("Sap xep theo gia");
            System.out.println("Tim kiem");
            System.out.println("Tinh tong tien");
            System.out.println("Giam gia cho dien thoai cu");
            System.out.println("Thoat");
            Scanner scanner = new Scanner(System.in);
            a = scanner.nextInt();
            switch (a) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    default: System.out.println("Thoat chuong trinh");
            }

        } while (a < 1 && a > 9);

    }



}
