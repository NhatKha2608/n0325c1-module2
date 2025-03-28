package ss9;

import ss9.validation.PhoneValidation;

import java.util.Scanner;

public abstract class Phone implements Comparable<Phone> {
    private String id;
    private String name;
    private double price;
    private int warranty;
    private String manufacturer;

    @Override
    public int compareTo(Phone o) {
        return Double.compare(this.getPrice(), o.price);
    }

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
        this.name = PhoneValidation.inputName("Tên điện thoại");
        this.price = PhoneValidation.inputPrice("Giá bán");
        this.warranty = PhoneValidation.inputWarranty("Thời gian bảo hành");
        this.manufacturer = PhoneValidation.inputManufacturer("Hãng sản xuất");
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
