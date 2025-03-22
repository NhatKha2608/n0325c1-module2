package ss4;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<OldPhone> oldPhones = new ArrayList<>();
    static ArrayList<NewPhone> newPhones = new ArrayList<>();
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


    private static void menuShowList() {
        int choose;
        while (true) {
            do {
                System.out.println("DANH SÁCH ĐIỆN THOẠI:");
                System.out.println("1. Xem tất cả");
                System.out.println("2. Xem điện thoại cũ");
                System.out.println("3. Xem điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        System.out.println("==== Danh sách tất cả điện thoại ====");
                        for (int i = 0; i < oldPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            oldPhones.get(i).output();
                        }

                        for (int i = 0; i < newPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1 + oldPhones.size()));
                            newPhones.get(i).output();
                        }
                        break;

                    case 2:
                        System.out.println("==== Danh sách điện thoại cũ ====");
                        for (int i = 0; i < oldPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            oldPhones.get(i).output();
                        }
                        break;

                    case 3:
                        System.out.println("==== Danh sách điện thoại mới ====");
                        for (int i = 0; i < newPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            newPhones.get(i).output();
                        }
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 0 || choose > 4);
        }
    }

    private static String getIdOldPhone() {
        if (oldPhones.size() == 0) {
            return "DTC001";
        }
        int max = Integer.parseInt(oldPhones.get(0).getId().substring(3));

        for (int i = 0; i < oldPhones.size(); i++) {
            int id = Integer.parseInt(oldPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }
        return String.format("DTC%3d", max + 1).replace(" ", "0");
    }

    private static String getIdNewPhone() {
        if (newPhones.size() == 0) {
            return "DTM001";
        }
        int max = Integer.parseInt(newPhones.get(0).getId().substring(3));

        for (int i = 0; i < newPhones.size(); i++) {
            int id = Integer.parseInt(newPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }
        return String.format("DTM%3d", max + 1).replace(" ", "0");
    }


    private static void menuAddNew() {
        int choose;
        while (true) {
            do {
                System.out.println("THÊM MỚI ĐIỆN THOẠI:");
                System.out.println("1. Thêm mới điện thoại cũ");
                System.out.println("2. Thêm mới điện thoại mới");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        oldPhone.setId(getIdOldPhone());
                        oldPhones.add(oldPhone);
                        System.out.println("Thêm mới thành công");
                        break;

                    case 2:
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone());
                        newPhones.add(newPhone);
                        System.out.println("Thêm mới thành công");
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }





}
