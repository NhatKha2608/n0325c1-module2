package ss6.queue;

public class MyQueue<T> {
    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // a. add(): thêm
    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // b. peek(): lấy ra xem
    public T peek() {
        if (tail == null) {
            System.out.println("Hàng đợi rỗng, không thể lấy ra.");
            return null;
        }
        return tail.value;
    }

    // c. poll(): Lấy ra xem và xóa
    public T poll() {
        if (head == null) {
            System.out.println("Hàng đợi rỗng, không thể lấy ra.");
            return null;
        }

        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            for (int i = 2; i < size; i++) {
                temp = temp.next;
            }
            tail = temp;
            temp = temp.next;
            tail.next = null;
        }
        size--;
        return temp.value;
    }

    // d. isEmpty(): kiểm tra rỗng
    public boolean isEmpty() {
        return size == 0;
    }

    // e. size(): trả về số lượng phần tử
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.value).append("\t");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }


}
