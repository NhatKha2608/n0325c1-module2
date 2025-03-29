package ss4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<OldPhone> oldPhones = new ArrayList<>();
    static ArrayList<NewPhone> newPhones = new ArrayList<>();
    static ArrayList<Phone> phones = new ArrayList<>();

    static {
        phones.add(new OldPhone("DTC001", "Iphone 15 Promax", 2000000.0, 6, "Apple", 95, "Đã qua sử dụng, tình trạng tốt"));

        phones.add(new OldPhone("DTC002", "Iphone 15", 1700000.0, 6, "Apple", 75, "Đã qua sử dụng, màn hình xuất nhẹ"));

        phones.add(new NewPhone("DTM001", "Samsung Galaxy S24", 3299000.0, 12, "Samsung", 15));

        phones.add(new NewPhone("DTM002", "Samsung Galaxy Fold", 5000000.0, 12, "Samsung", 12));
    }

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI----- ");
            System.out.println("1. Xem danh sách điện thoại");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp theo giá");
            System.out.println("6. Tìm kiếm");
            System.out.println("7. Tính tổng tiền");
            System.out.println("8. Giảm giá cho điện thoại cũ");
            System.out.println("9. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuShowList();
                    break;
                case 2:
                    menuAddNew();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    menuSort();
                    break;
                case 6:
                    menuSearch();
                    break;
                case 7:
                    System.out.println("Tổng giá của tất cả các điện thoại: " + calculateTotalPriceInStore());
                    break;

                case 8:
                    System.out.print("Nhập vào phần trăm muốn giảm giá: ");
                    double percentDiscount = Double.parseDouble(scanner.nextLine());
                    applyDiscountToOldPhones(percentDiscount);
                    System.out.println("Đã giảm giá thành công");
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Thoát chương trình");
            }

        }


    }

    private static double calculateTotalPriceInStore() {
        double total = 0.0;
        for (Phone phone : phones) {
            total += phone.calculateTotalPrice();
        }
        return total;
    }

    public static void applyDiscountToOldPhones(double percentDiscount) {
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                ((OldPhone) phone).applyDiscount(percentDiscount);
            }
        }
    }

    private static void menuShowList() {
        int choose;
        while (true) {
            do {
                System.out.println("DANH SÁCH ĐIỆN THOẠI:");
                System.out.println("1. Xem tất cả");
                System.out.println("2. Xem điện thoại cũ");
                System.out.println("3. Xem điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        System.out.println("==== Danh sách tất cả điện thoại ====");
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            phones.get(i).output();
                        }
                        break;

                    case 2:
                        System.out.println("==== Danh sách điện thoại cũ ====");
                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof OldPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("==== Danh sách điện thoại mới ====");
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof NewPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 0 || choose > 4);
        }
    }

    private static String getIdOldPhone() {

        ArrayList<OldPhone> oldPhones = getOldPhones();
        if (oldPhones.isEmpty()) {
            return "DTC001";
        }

        // Tìm max ID từ danh sách điện thoại cũ
        int max = 0;
        for (OldPhone phone : oldPhones) {
            int id = Integer.parseInt(phone.getId().substring(3)); // Lấy phần số từ ID
            if (id > max) {
                max = id;
            }
        }

        // Tạo ID mới với định dạng "DTCxxx" (xxx là số, điền 0 nếu cần)
        return String.format("DTC%03d", max + 1);
    }


    // Lọc ra danh sách điện thoại cũ từ danh sách điện thoại chung
    private static ArrayList<OldPhone> getOldPhones() {
        ArrayList<OldPhone> oldPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                oldPhones.add((OldPhone) phone);
            }
        }
        return oldPhones;
    }


    private static String getIdNewPhone() {
        // Lấy ra danh sách điện thoại mới từ danh sách điện thoại
        ArrayList<NewPhone> newPhones = getNewPhones();

        // Nếu danh sách rỗng, trả về ID mặc định
        if (newPhones.size() == 0) {
            return "DTM001";
        }
        int max = Integer.parseInt(newPhones.get(0).getId().substring(3));

        for (NewPhone phone : newPhones) {
            int id = Integer.parseInt(phone.getId().substring(3));
            if (max < id) {
                max = id;
            }
        }

        return String.format("DTM%03d", max + 1);
    }

    // Lọc ra điện thoại mới
    private static ArrayList<NewPhone> getNewPhones() {
        ArrayList<NewPhone> newPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof NewPhone) {
                newPhones.add((NewPhone) phone);
            }
        }
        return newPhones;
    }


    private static void menuAddNew() {
        int choose;
        while (true) {
            do {
                System.out.println("THÊM MỚI ĐIỆN THOẠI:");
                System.out.println("1. Thêm mới điện thoại cũ");
                System.out.println("2. Thêm mới điện thoại mới");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        oldPhone.setId(getIdOldPhone());
                        phones.add(oldPhone);
                        System.out.println("Thêm mới thành công");
                        break;

                    case 2:
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone());
                        phones.add(newPhone);
                        System.out.println("Thêm mới thành công");
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    private static void menuDelete() {
        System.out.println("Nhập vào mã muốn xóa");
        String id = scanner.nextLine();

        if (id.startsWith("DTC")) {
            boolean isExitPhone = false;
            for (OldPhone oldPhone : oldPhones) {
                if (oldPhone.getId().equals(id)) {
                    isExitPhone = true;
                    System.out.printf("Bạn có muốn xóa điện thoại cũ có mã %s không \n", id);
                    System.out.println("Chọn Yes để xác nhận xóa, No để hủy");
                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        oldPhones.remove(oldPhone);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Đã hủy việc xóa!");
                    }
                    break;
                }
            }
            if (!isExitPhone) {
                System.out.println("Không tìm thấy Id muốn xóa");
            }
        } else if (id.startsWith("DTM")) {
            boolean isExitPhone = false;
            for (NewPhone newPhone : newPhones) {
                if (newPhone.getId().equals(id)) {
                    isExitPhone = true;
                    System.out.printf("Bạn có muốn xóa điện thoại mới có mã %s không \n", id);
                    System.out.println("Chọn yes để xác nhận xóa, No để hủy");
                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Đã xóa thành công!");
                    } else {
                        System.out.println("Đã hủy việc xóa");
                    }
                    break;
                }
            }
            if (!isExitPhone) {
                System.out.println("Không tìm thấy Id muốn xóa");
            }
        } else {
            System.out.println("Id bạn vừa nhập không hợp lệ! Xin vui lòng nhập lại");
        }
    }

    private static void delete() {
        System.out.print("Nhập vào mã muốn xóa: ");
        String id = scanner.nextLine();

        if (id.startsWith("DTC") || id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExistPhone = true;
                    System.out.printf("Bạn có xóa điện thoại có mã %s không?\n", id);
                    System.out.println("Chọn Yes để xác nhận xóa, No để hủy");
                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        phones.remove(phone);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Đã hủy việc xóa!");
                    }
                    break;
                }
            }

            if (!isExistPhone) {
                System.out.println("Không tìm thấy mã muốn xóa!");
            }
        } else {
            System.out.println("Mã không hợp lệ!");
        }
    }


    private static void menuUpdate() {
        System.out.println("Nhập vào Id bạn muốn cập nhật: ");
        String id = scanner.nextLine();

        if (id.startsWith("DTC")) {
            // isExist: Tồn tại
            boolean isExistOldPhone = false;
            for (int i = 0; i < oldPhones.size(); i++) {
                if (oldPhones.get(i).getId().equals(id)) {
                    isExistOldPhone = true;
                    oldPhones.get(i).input();
                    System.out.println("Cập nhật thành công");
                    break;
                }
            }
            if (!isExistOldPhone) {
                System.out.println("Không tìm thấy Id muốn cập nhật");
            }
        } else if (id.startsWith("DTM")) {
            boolean isExistNewPhone = false;
            for (int i = 0; i < newPhones.size(); i++) {
                if (newPhones.get(i).getId().equals(id)) {
                    isExistNewPhone = true;
                    newPhones.get(i).input();
                    System.out.println("Cập nhật thành công");
                    break;
                }
            }
            if (!isExistNewPhone) {
                System.out.println("Không tìm thấy Id muốn cập nhật");
            }
        } else {
            System.out.println("Id không hợp lệ");
        }
    }

    private static void update() {
        System.out.print("Nhập vào mã muốn cập nhật: ");
        String id = scanner.nextLine();

        if (id.startsWith("DTC") || id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExistPhone = true;
                    phone.input();
                    System.out.println("Cập nhật thành công!");
                    break;
                }
            }

            if (!isExistPhone) {
                System.out.println("Không tìm thấy mã muốn cập nhật!");
            }
        } else {
            System.out.println("Mã không hợp lệ!");
        }
    }


    private static void menuSort() {
        while (true) {
            int choose;
            do {
                System.out.println("==== 5. Sắp xếp theo giá ====");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                System.out.println("3. Trở về menu chính");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        for (int i = 0; i < phones.size() - 1; i++) {
                            for (int j = i + 1; j < phones.size(); j++) {
                                if (phones.get(i).getPrice() > phones.get(j).getPrice()) {
                                    Phone temp = phones.get(i);
                                    phones.set(i, phones.get(j));
                                    phones.set(j, temp);
                                }
                            }
                        }
                        break;

                    case 2:
                        for (int i = 0; i < phones.size() - 1; i++) {
                            for (int j = i + 1; j < phones.size(); j++) {
                                if (phones.get(i).getPrice() < phones.get(j).getPrice()) {
                                    Phone temp = phones.get(i);
                                    phones.set(i, phones.get(j));
                                    phones.set(j, temp);
                                }
                            }
                        }
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 0 || choose > 3);
        }
    }

    private static void menuSearch() {
        while (true) {
            int choose;
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm tất cả các loại điện thoại");
                System.out.println("2. Tìm kiếm điện thoại củ");
                System.out.println("3. Tìm kiếm điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        menuSearchAllPhone();
                        break;
                    case 2:
                        menuSearchOldPhone();
                        break;
                    case 3:
                        menuSearchNewPhone();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 1) || (choose > 4));
        }

    }


    private static void menuSearchNewPhone() {
        while (true) {
            int choose;
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("Nhập vào khoảng giá muốn tìm:");
                        System.out.println("Nhập vào giá từ:");
                        int priceFrom = Integer.parseInt(scanner.nextLine());

                        System.out.println("Nhập vào giá đến:");
                        int priceTo = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getPrice() > priceFrom
                                    && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }

                        break;
                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 1) || (choose > 4));
        }
    }

    private static void menuSearchOldPhone() {
        while (true) {
            int choose;
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("Nhập vào khoảng giá muốn tìm");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());
                        System.out.println("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());
                        int count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getPrice() >= priceFrom
                                    && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 1) || (choose > 4));
        }
    }

    private static void menuSearchAllPhone() {
        while (true) {
            int choose;
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.print("Nhập vào khoảng giá muốn tìm");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 0 || choose > 4);
        }

    }
}
