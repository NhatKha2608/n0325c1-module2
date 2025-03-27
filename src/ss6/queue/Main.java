package ss6.queue;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

// a. Thêm phần tử vào hàng đợi
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println("Hàng đợi: " + queue.toString());

// b. Lấy ra phần tử đầu tiên mà không xóa nó
        Integer peekValue = queue.peek();
        System.out.println("Giá trị ở đầu hàng đợi: " + peekValue);

// c. Lấy ra và xóa phần tử đầu tiên
        Integer polledValue = queue.poll();
        System.out.println("Giá trị lấy ra: " + polledValue);

// d. Kiểm tra xem hàng đợi có trống không
        boolean isEmpty = queue.isEmpty();
        System.out.println("Hàng đợi có trống không: " + isEmpty);
// e. Lấy kích thước của hàng đợi
        int queueSize = queue.size();
        System.out.println("Kích thước hàng đợi: " + queueSize);
    }
}
