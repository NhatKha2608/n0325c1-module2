package ss9;

import ss9.Phone;
import ss9.validation.PhoneValidation;

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
        this.quantity = PhoneValidation.inputQuantity("Số lượng");
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
