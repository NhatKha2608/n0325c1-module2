package oop3;

public class PhanSo {
    private int tuso;
    private int mauso;

    PhanSo() {
        tuso = 0;
        mauso = 1;
    }

    PhanSo(int tuso) {
        this.tuso = tuso;
        mauso = 1;
    }

    PhanSo(int tuso, int mauso) {
        this.tuso = tuso;
        this.mauso = mauso;
    }


    private int uocChungLonNhat(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }

        a = Math.abs(a);

        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return 1;
    }

    private void rutGon() {
        int ucln = uocChungLonNhat(tuso, mauso);
        tuso /= ucln;
        mauso /= ucln;

        if (mauso < 0) {
            tuso = -tuso;
            mauso = -mauso;
        }
    }
    void output() {
        if(tuso == 0){
            System.out.println(0);
        } else if (mauso ==1){
            System.out.println(this.tuso);
        } else {
            System.out.println(this.tuso + "/" + this.mauso);
        }
    }

    public PhanSo coppy() {
        return new PhanSo(this.tuso,this.mauso);
    }

    public void sum(int a){
        tuso += a*mauso;
        rutGon();
    }
}
