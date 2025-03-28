package exception;

public class Main {
    public static void main(String[] args) {
        try {
            input(10);
        } catch (Under18YearOldException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Chuong trinh ket thuc");
    }
    public static void input(int age){
        if(age < 18){
            throw new Under18YearOldException("Bạn chưa đủ tuoi");
        }
    }
}
