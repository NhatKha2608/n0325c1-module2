package ss6;

import ss6.exercise.MyLinkedList;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(20);
        myLinkedList.addFirst(30);
        myLinkedList.addFirst(40);
        myLinkedList.addFirst(50);
        myLinkedList.addFirst(60);

        System.out.println(myLinkedList);

    }

    public static class StackStudy {
        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();

            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);

            while (!stack.isEmpty()){
                System.out.println(stack.pop());
            }

        }
    }
}
