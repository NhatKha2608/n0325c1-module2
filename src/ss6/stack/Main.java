package ss6.stack;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

// a. push: thêm
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Ngăn xếp: " + stack.toString());

// b. peek: lấy ra xem
        Integer peekValue = stack.peek();
        System.out.println("Giá trị ở đầu ngăn xếp: " + peekValue);

// c. pop: lấy ra xem và xóa
        Integer poppedValue = stack.pop();
        System.out.println("Giá trị lấy ra: " + poppedValue);

// d. isEmpty: kiểm tra rỗng
        boolean isEmpty = stack.isEmpty();
        System.out.println("Ngăn xếp có trống không: " + isEmpty);

// e. size: trả về số lượng phần tử
        int stackSize = stack.size();
        System.out.println("Kích thước ngăn xếp: " + stackSize);
    }
}
