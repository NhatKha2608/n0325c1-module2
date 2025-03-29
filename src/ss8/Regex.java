package ss8;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {

    // kiểm tra số điện thoại
    private static final String PHONE_REGEX = "(0|\\+84)(32|33|34|35|36|37|38|39)\\d{7}";

    //  kiểm tra email
    private static final String EMAIL_REGEX = "[A-Za-z0-9_]{6,32}@[A-Za-z0-9]{2,12}\\.[A-Za-z0-9]{2,12}";

    // kiểm tra username
    private static final String USERNAME_REGEX = "[A-Za-z0-9_.]{6,32}";

    // kiểm tra password
    private static final String PASSWORD_REGEX = "[A-Z][A-Z a-z 0-9!@#$%^&*().]{5,31}";

    public static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kiểm tra số điện thoại
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.println(validate(phone, PHONE_REGEX) ? "Số điện thoại hợp lệ" : "Số điện thoại không hợp lệ");

        // Kiểm tra email
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println(validate(email, EMAIL_REGEX) ? "Email hợp lệ" : "Email không hợp lệ");

        // Kiểm tra username
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.println(validate(username, USERNAME_REGEX) ? "Username hợp lệ" : "Username không hợp lệ");

        // Kiểm tra password
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();
        System.out.println(validate(password, PASSWORD_REGEX) ? "Password hợp lệ" : "Password không hợp lệ");

        scanner.close();
    }
}
