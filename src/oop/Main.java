package oop;

public class Main {
    public static void main(String[] args) {
       PhanSo phanSo1 =new PhanSo();
       phanSo1.input();
       phanSo1.output();
       PhanSo phanSo2 =new PhanSo();
       phanSo2.input();
       phanSo2.output();
       phanSo1.calSum(phanSo2);
       phanSo1.calHieu(phanSo2);
       phanSo1.calTich(phanSo2);
       phanSo1.calThuong(phanSo2);
    }
}