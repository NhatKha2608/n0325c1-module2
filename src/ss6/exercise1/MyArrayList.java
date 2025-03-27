package ss6.exercise1;

public class MyArrayList {
    private int capacity;
    private int[] arr;
    private int size;
    private static final int[] emptyArray = new int[0];

    public int size() {
        return size;
    }

    public MyArrayList() {
        this.arr = emptyArray;
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    // a. add (int element): Thêm phần tử element vào cuối.
    public void add(int element) {
        if (arr == emptyArray) {
            this.capacity = 10;
            this.arr = new int[this.capacity];
        }
        if (size == capacity) {
            this.capacity *= 1.5; // Tăng dung lượng của mảng
            if (size == capacity) { // Tránh trường hợp capacity ban đầu là 0 hoặc 1
                capacity++;
            }
        }

// Tạo một mảng mới với dung lượng đã tăng
        int[] brr = new int[this.capacity];

// Sao chép các phần tử từ mảng cũ sang mảng mới
        for (int i = 0; i < size; i++) {
            brr[i] = arr[i];
        }

// Cho mảng arr tham chiếu đến vùng nhớ mới
        arr = brr;

// Thêm phần tử mới vào mảng
        arr[size] = element;
        size++;
    }

    // b. toString (): Trả về thông tin đối tượng
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]).append("\t");
        }

        return stringBuilder.toString();
    }

    // c.Thêm phần tử vào vị trí index
    public void add(int index, int element) {
        // Kiểm tra xem index có hợp lệ không
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index ngoài phạm vi!");
        }

        // Kiểm tra nếu mảng đã đầy, cần tăng dung lượng
        if (size == capacity) {
            capacity = Math.max(1, capacity * 2); // Tăng dung lượng lên gấp đôi
            int[] brr = new int[capacity];

            // Sao chép phần tử từ mảng arr sang brr
            System.arraycopy(arr, 0, brr, 0, index);
            System.arraycopy(arr, index, brr, index + 1, size - index);

            // Gán lại mảng brr cho arr
            arr = brr;
        } else {
            // Dịch các phần tử từ index trở đi sang phải để chừa chỗ
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
        }

        // Thêm phần tử mới vào vị trí chỉ định
        arr[index] = element;

        // Cập nhật kích thước
        size++;
    }

    //d
    public void set(int index, int element) {
        // Kiểm tra index có hợp lệ
        if (index < 0 || index >= size) {
            System.out.println("Index ngoài phạm vi!");
            return;
        }
        // Gán giá trị mới vào index cụ thể
        arr[index] = element;
    }

    //e
    public Integer get(int index) {
        // Kiểm tra index có hợp lệ
        if (index < 0 || index >= size) {
            System.out.println("Index ngoài phạm vi!");
            return null;
        }
        // Trả về phần tử tại index
        return arr[index];
    }

    // f. indexOf (int element): Lấy vị trí index phần tử đầu tiên tìm thấy
    public int indexOf(int element) {
        // Tìm vị trí index của phần tử đầu tiên tìm thấy
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        // Nếu không tìm thấy, trả về -1
        return -1;
    }

    // g. lastIndexOf (int element): Lấy vị trí index phần tử cuối cùng tìm thấy
    public int lastIndexOf(int element) {
        // Duyệt qua mảng từ cuối lên đầu để tìm vị trí phần tử
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == element) {
                return i; // Trả về index nếu tìm thấy phần tử
            }
        }
        // Nếu không tìm thấy phần tử, trả về -1
        return -1;
    }

    // h. remove (int index): Xóa phần tử tại vị trí index
    public void remove(int index) {
        // Kiểm tra index có hợp lệ
        if (index < 0 || index >= size) {
            System.out.println("Index ngoài phạm vi!");
            return;
        }

        // Dịch chuyển phần tử từ index trở về sau sang trái để xóa phần tử tại index
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;
    }

    // i. removeElement (int element): Xóa tất cả phần tử element
    public void removeElement(int element) {
        int newIndex = 0;

        // Sao chép các phần tử khác với element vào mảng mới
        for (int i = 0; i < size; i++) {
            if (arr[i] != element) {
                arr[newIndex] = arr[i];
                newIndex++;
            }
        }

        // Cập nhật size
        size = newIndex;
    }
}
