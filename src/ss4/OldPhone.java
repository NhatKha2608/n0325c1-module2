package ss4;

import java.util.Scanner;

public class OldPhone extends Phone implements Discountable{
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào tình trạng pin (%): ");
        this.batteryPercentage = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập vào mô tả thêm: ");
        this.description = scanner.nextLine();
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
