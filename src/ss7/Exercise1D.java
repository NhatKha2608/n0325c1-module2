package ss7;

import java.util.TreeSet;

public class Exercise1D {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6, 3, 8};

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int min = set.first(); // Lấy phần tử nhỏ nhất
        int max = set.last();  // Lấy phần tử lớn nhất

        System.out.println("Phần tử nhỏ nhất trong mảng: " + min);
        System.out.println("Phần tử lớn nhất trong mảng: " + max);
    }
}
