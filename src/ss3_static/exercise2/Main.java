package ss3_static.exercise2;

public class Main {
    public static void main(String[] args) {
        double number1 = 9.0;
        double number2 = 4.5;

        System.out.println("Tổng : " + MathUtil.add(number1, number2));
        System.out.println("Hiệu : " + MathUtil.subtract(number1, number2));
        System.out.println("Tích : " + MathUtil.multiply(number1, number2));
        System.out.println("Thương : " + MathUtil.divide(number1, number2));
    }
}
