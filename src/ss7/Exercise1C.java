package ss7;

import java.util.HashSet;

public class Exercise1C {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        // Tạo hai Set để lưu trữ các phần tử từ hai mảng
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Thêm phần tử từ mảng 1 vào Set 1
        for (int num : arr1) {
            set1.add(num);
        }
        // Thêm phần tử từ mảng 2 vào Set 2
        for (int num : arr2) {
            set2.add(num);
        }

        // Tạo một Set mới để lưu trữ các phần tử chung
        HashSet<Integer> commonElements = new HashSet<>(set1);

        // Giữ lại chỉ các phần tử có trong cả hai Set
        commonElements.retainAll(set2);

        // Hiển thị các phần tử chung
        System.out.println("Các phần tử chung giữa hai mảng là:");
        for (int element : commonElements) {
            System.out.println(element);
        }
    }
}
