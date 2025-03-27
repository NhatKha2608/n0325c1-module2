package ss6.exercise;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList();

        myList.addFirst(10);
        myList.addFirst(20);
        myList.addFirst(30);

        System.out.println("Initial list: " + myList.toString());

        myList.addLast(40);
        myList.addLast(50);


        myList.add(2, 25);

        myList.removeFirst();
        myList.removeLast();

        Integer firstElement = myList.getFirst();
        System.out.println("First element: " + firstElement);

        Integer lastElement = myList.getLast();
        System.out.println("Phần tử cuối cùng trong danh sách: " + lastElement);

        Integer elementAtIndex = myList.get(1);
        System.out.println("Phần tử tại vị trí 1 trong danh sách: " + elementAtIndex);

        myList.set(0, 15);
        System.out.println("Danh sách sau khi thay thế phần tử tại vị trí 0 thành 15: " + myList.toString());

        Integer indexOfElement = myList.indexOf(20);
        System.out.println("Vị trí của phần tử 20 là: " + indexOfElement);

        Integer lastIndexOfElement = myList.lastIndexOf(25);
        System.out.println("Vị trí index cuối cùng của phần tử 25 là: " + lastIndexOfElement);
    }
}
