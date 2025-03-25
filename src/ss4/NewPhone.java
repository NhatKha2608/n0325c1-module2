package ss4;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {}

    public NewPhone(String id, String name, double price, int warranty,
                    String manufacturer, int quantity) {
        super(id, name, price, warranty, manufacturer);
        this.quantity = quantity;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng: ");
        this.quantity = scanner.nextInt();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Số lượng: " + this.quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * quantity;
    }
}
