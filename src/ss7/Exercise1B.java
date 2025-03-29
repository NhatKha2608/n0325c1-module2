package ss7;

import java.util.HashSet;

public class Exercise1B {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 6, 5, 7};

        // Tạo một Set để lưu trữ các phần tử duy nhất
        HashSet<Integer> uniqueSet = new HashSet<>();
        int sum = 0;

        // Tính tổng của các phần tử không trùng lặp và đồng thời thêm các phần tử vào Set
        for (int num : arr) {
            if (!uniqueSet.contains(num)) {
                uniqueSet.add(num);
                sum += num;
            }
        }

        // Hiển thị tổng của các phần tử không trùng lặp
        System.out.println("Tổng của các phần tử không trùng lặp là: " + sum);
    }
}
