package ss7;

public class Main {
    public static final String Hello = "Hello";
    public static void main(String[] args) {

        try{
            String str = null;

            System.out.println(str.equals(Hello));
        }catch (NullPointerException e){
            System.out.println("Bị lỗi");
        }
        System.out.println("Chương trình kết thúc");
    }
}
