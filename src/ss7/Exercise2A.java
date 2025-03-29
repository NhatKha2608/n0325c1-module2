package ss7;

import java.util.HashMap;
import java.util.Map;

public class Exercise2A {
    public static void main(String[] args) {
        String text = "Đây là văn bản đếm số lần xuất hiện của từ trong một văn bản";

        // Tạo một Map để lưu trữ từ và số lần xuất hiện
        Map<String, Integer> wordCount = new HashMap<>();

        // Tách chuỗi thành các từ bằng khoảng trắng
        String[] words = text.split(" ");

        // Duyệt qua từng từ và tăng số lần xuất hiện trong Map
        for (String word : words) {
            // Chuyển đổi từ thành chữ thường để không phân biệt chữ hoa/chữ thường
            word = word.toLowerCase();

            // Kiểm tra xem từ đã có trong Map chưa
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        // Hiển thị số lần xuất hiện của từng từ
        for (String word : wordCount.keySet()) {
            int count = wordCount.get(word);
            System.out.println(word + ": " + count);
        }
    }
}
