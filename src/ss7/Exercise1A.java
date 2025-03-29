package ss7;

import java.util.HashSet;
import java.util.Set;

public class Exercise1A {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 6, 5, 7};

        int[] uniqueArray = removeDuplicates(arr);

        // Hiển thị danh sách các phần tử duy nhất
        System.out.println("Danh sách các phần tử duy nhất:");
        for (int num : uniqueArray) {
            System.out.println(num);
        }
    }

    static int[] removeDuplicates(int[] arr) {
        // Chuyển mảng thành một Set để loại bỏ phần tử trùng lặp
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }

        // Chuyển lại từ Set thành mảng
        int[] uniqueArray = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            uniqueArray[index] = num;
            index++;
        }

        return uniqueArray;
    }
}