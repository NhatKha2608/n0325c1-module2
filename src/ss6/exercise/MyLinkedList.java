package ss6.exercise;

public class MyLinkedList<T> {

    private class Node {

        T value;

        Node next; // null

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;

    private Node tail;

    private int size = 0;

    public void addFirst(T value) {
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

    // c. addLast (int element)
    public void addLast(T value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    // d. add (int index, int element)
    public void add(int index, T value) {
        if (index < 0 || index > size) {
            System.out.println("Ngoài phạm vi"); // Index is out of range
        } else if (index == 0) {
            addFirst(value); // Add at the beginning
        } else if (index == size) {
            addLast(value); // Add at the end
        } else {
            Node temp = head;
            // Additional logic would go here to insert the value at the specific index
            for (int i = 1; i < index; i++) {
                temp = temp.next; // Duyệt qua các nút đến vị trí chỉ định
            }

            Node newNode = new Node(value); // Tạo một nút mới với giá trị được cung cấp
            newNode.next = temp.next;       // Gán nút mới liên kết với nút kế tiếp
            temp.next = newNode;            // Chèn nút mới vào danh sách
            size++;                         // Tăng kích thước danh sách
        }

    }
    // e. removeFirst ()
    public T removeFirst() {
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

    // f. removeLast ()
    public T removeLast() {
        if (head == null) {
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

    // g. remove (int index)
    public void remove(int index) {
        // Kiểm tra chỉ số có hợp lệ không
        if (index < 0 || index >= size) {
            System.out.println("Index ngoài phạm vi"); // In thông báo lỗi nếu không hợp lệ
            return;
        }

        if (index == 0) {
            // Trường hợp đặc biệt: Xóa phần tử đầu danh sách
            removeFirst();
        } else if (index == size - 1) {
            // Trường hợp đặc biệt: Xóa phần tử cuối danh sách
            removeLast();
        } else {
            // Trường hợp chung: Xóa phần tử tại vị trí chỉ định
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Duyệt qua danh sách để đến nút trước vị trí cần xóa
            }
            current.next = current.next.next; // Bỏ qua nút cần xóa bằng cách cập nhật con trỏ
        }
        size--; // Giảm kích thước danh sách
    }

    // h. getFirst ()
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    // i. getLast ()
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    // j. get (int index)
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }

    // k. set (int index, int element)
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            System.out.println("Index ngoài phạm vi");
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.value = element;
        }
    }
    // i. indexOf (int element)
    public Integer indexOf(T element) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                return i; // Found the element, return its index
            }
            temp = temp.next; // Move to the next node
        }
        return -1; // Không tìm thấy (Not found)
    }

    // m. lastIndexOf (int element)
    public Integer lastIndexOf(T element) {
        int lastIndex = -1;
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                lastIndex = i;
            }
            temp = temp.next;
        }
        return lastIndex;
    }

}
