package ss7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise2B {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kha", "Sơn", "Khanh", "Nhi", "Thanh");

        // Tạo một Map để lưu trữ số lần xuất hiện của từng tên
        Map<String, Integer> nameCount = new HashMap<>();

        // Duyệt qua danh sách tên và đếm số lần xuất hiện
        for (String name : names) {
            // Nếu tên đã tồn tại trong Map thì tăng số đếm lên 1, nếu không thì khởi tạo bằng 1
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }

        // Hiển thị tên duy nhất
        System.out.println("Tên duy nhất:");
        for (String name : nameCount.keySet()) {
            if (nameCount.get(name) == 1) {
                System.out.println(name);
            }
        }

        // Hiển thị tên xuất hiện nhiều lần
        System.out.println("Tên xuất hiện nhiều lần:");
        for (String name : nameCount.keySet()) {
            if (nameCount.get(name) > 1) {
                System.out.println(name);
            }
        }
    }
}
