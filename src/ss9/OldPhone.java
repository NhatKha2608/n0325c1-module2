package ss9;

import ss9.Discountable;
import ss9.Phone;
import ss9.validation.PhoneValidation;

import java.util.Scanner;

public class OldPhone extends Phone implements Discountable {
    private int batteryPercentage;
    private String description;

    public OldPhone() {
    }

    public OldPhone(String id, String name, double price, int warranty,
                    String manufacturer, int batteryPercentage, String description) {
        super(id, name, price, warranty, manufacturer);
        this.batteryPercentage = batteryPercentage;
        this.description = description;
    }

    @Override
    public void input() {
        super.input();
        this.batteryPercentage = PhoneValidation.inputBatteryPercentage("Tình trạng pin (%)");
        this.description = PhoneValidation.inputDescription("Mô tả thêm");
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Tình trạng pin (%): " + this.batteryPercentage);
        System.out.println("Mô tả thêm: " + this.description);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice();
    }

    @Override
    public void applyDiscount(double percentDiscount) {
        double discountedPrice = getPrice() * (1 - percentDiscount / 100.0);
        setPrice(discountedPrice);
    }
}
