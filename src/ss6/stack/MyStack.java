package ss6.stack;

public class MyStack<E> {
    private class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // a. push(): thêm
    public void push(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // b. peek(): lấy ra xem
    public E peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    // c. pop(): lấy ra xem và xóa
    public E pop() {
        if (head == null) {
            return null;
        }

        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
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
