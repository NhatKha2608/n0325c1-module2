package oop;

import java.util.Scanner;

public class PhanSo {
    double tuso;
    double mauso;

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tử số  :");
        tuso = Double.parseDouble(scanner.nextLine());

        do {
            System.out.println("Nhập mẫu số  :");
            mauso = Double.parseDouble(scanner.nextLine());
            if (mauso == 0) {
                System.out.println("Nhập sai vui lòng nhập mẫu số != 0");
            }
        } while (mauso == 0);

    }

    double ucln(double tuso, double mauso) {
        if (tuso == 1 && mauso == 1) {
            return 1;
        }
        tuso = Math.abs(tuso);
        for (double i = tuso; i > 0; i--) {
            if (tuso % i == 0 || mauso % i == 0) {
                return i;
            }
        }
        return 0;
    }

    void output() {
        double ucln = ucln(tuso, mauso);
        tuso /= ucln;
        mauso /= ucln;
        if (mauso == 1) {
            System.out.println("Số thập phân rút gọn " + tuso);
        } else {
            System.out.println("Số thập phân rút gọn" + tuso + "/" + mauso);
        }
    }

    void calSum(PhanSo phansokhac) {
        double tuSoKhac = phansokhac.tuso;
        double mauSoKhac = phansokhac.mauso;
        double tongTuSo = tuso * mauSoKhac + tuSoKhac * mauso;
        double tongMauSo = mauso * mauSoKhac;
        double ucln = ucln(tongTuSo, tongMauSo);
        tongTuSo /= ucln;
        tongMauSo /= ucln;
        System.out.println("Tổng hai phan so " + tongTuSo + "/" + tongMauSo);
    }

    void calHieu(PhanSo phansokhac) {
        double tuSoKhac = phansokhac.tuso;
        double mauSoKhac = phansokhac.mauso;
        double tongTuSo = tuso * mauSoKhac - tuSoKhac * mauso;
        double tongMauSo = mauso * mauSoKhac;
        double ucln = ucln(tongTuSo, tongMauSo);
        tongTuSo /= ucln;
        tongMauSo /= ucln;
        System.out.println("Hiệu hai phan so " + tongTuSo + "/" + tongMauSo);
    }

    void calTich(PhanSo phansokhac) {
        double tuSoKhac = phansokhac.tuso;
        double mauSoKhac = phansokhac.mauso;
        double tichTuSo = tuso * tuSoKhac;
        double tichMauSo = mauso * mauSoKhac;
        double ucln = ucln(tichTuSo, tichMauSo);
        tichTuSo /= ucln;
        tichMauSo /= ucln;
        System.out.println("Tích hai phan so " + tichTuSo + "/" + tichMauSo);
    }

    void calThuong(PhanSo phansokhac) {
        double tuSoKhac = phansokhac.tuso;
        double mauSoKhac = phansokhac.mauso;
        double thuongTuSo = tuso * mauSoKhac;
        double thuongMauSo = mauso * tuSoKhac;
        double ucln = ucln(thuongTuSo, thuongMauSo);
        thuongTuSo /= ucln;
        thuongMauSo /= ucln;
        System.out.println("Tích hai phan so " + thuongTuSo + "/" + thuongMauSo);
    }

}
