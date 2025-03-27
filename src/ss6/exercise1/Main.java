package ss6.exercise1;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);

        // b. toString (): Trả về thông tin đối tượng
        System.out.println("Danh sách ban đầu: " + myArrayList.toString());

// c. add (int index, int element): Thêm phần tử vào vị trí index
        myArrayList.add(2, 25);
        System.out.println("Danh sách sau khi thêm 25 vào vị trí 2: " + myArrayList.toString());

// d. set (int index, int element): Thay thế phần tử tại vị trí index
        myArrayList.set(3, 35);
        System.out.println("Danh sách sau khi thay thế ở vị trí 3 bằng 35: " + myArrayList.toString());

// e. get (int index): Trả về phần tử tại index
        int elementAtIndex = myArrayList.get(4);
        System.out.println("Phần tử tại vị trí 4 là: " + elementAtIndex);

// f. indexOf (int element): Lấy vị trí index phần tử đầu tiên tìm thấy
        int elementToFind = 30;
        int indexOfElement = myArrayList.indexOf(elementToFind);
        if (indexOfElement != -1) {
            System.out.println("Vị trí index của phần tử " + elementToFind + " là: " + indexOfElement);
        } else {
            System.out.println("Không tìm thấy phần tử " + elementToFind + " trong danh sách.");
        }

// g. lastIndexOf (int element): Lấy vị trí index phần tử cuối cùng tìm thấy
        int lastIndexOfElement = myArrayList.lastIndexOf(elementToFind);
        if (lastIndexOfElement != -1) {
            System.out.println("Vị trí index cuối cùng của phần tử " + elementToFind + " là: " + lastIndexOfElement);
        } else {
            System.out.println("Không tìm thấy phần tử " + elementToFind + " trong danh sách.");
        }

        // h. remove (int index): Removes the element at the specified index
        myArrayList.remove( 1);
        System.out.println("Danh sách sau khi xóa phần tử tại vị trí 1: " + myArrayList.toString());

// i. removeElement (int element): Removes all occurrences of a specific element
        myArrayList.removeElement(30);
        System.out.println("Danh sách sau khi xóa tất cả phần tử có giá trị 30: " + myArrayList.toString());

    }
}
