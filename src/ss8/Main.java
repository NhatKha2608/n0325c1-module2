package ss8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoai");
        String sdt = scanner.nextLine();

        if(sdt.matches("03[2-9][0-9]{7}")==false){
            System.out.println("số không hợp lệ");
        } else System.out.println("Số hợp lệ");
    }
}
