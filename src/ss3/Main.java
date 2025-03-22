package ss3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String dateString1 = "22/03/2025";
        String dateString2 = "2025/03/22";

        LocalDate date1 = LocalDateUtil.fromString_ddMMyyyy(dateString1);
        LocalDate date2 = LocalDateUtil.fromString_yyyyMMdd(dateString2);

        System.out.println("Chuoi dd/MM/yyyy " + date1);
        System.out.println("Chuoi yyyy/MM/dd " + date2);

    }
}
