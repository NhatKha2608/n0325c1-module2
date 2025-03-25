package ss4;

import java.util.Scanner;

public abstract class Phone {
    private String id;
    private String name;
    private double price;
    private int warranty;
    private String manufacturer;

    public Phone() {
    }

    public Phone(String id, String name, double price, int warranty, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên điện thoại: ");
        name = scanner.nextLine();

        System.out.print("Nhập vào giá bán: ");
        price = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập vào thời gian bảo hành: ");
        warranty = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập hãng sản xuất: ");
        manufacturer = scanner.nextLine();
    }

    void output() {
        System.out.println("Id: " + this.id);

        System.out.println("Tên điện thoại: " + this.name);

        System.out.println("Nhập vào giá bán: " + this.price);

        System.out.println("Nhập vào thời gian bảo hành: " + this.warranty);

        System.out.println("Nhập hãng sản xuất: " + this.manufacturer);
    }

    public abstract double calculateTotalPrice();
}
