package ss5;

public class Main {
/**
 * HocVien hocVien1 = new HocVien();
 * → Hợp lệ, tạo một đối tượng HocVien.
 *
 * HocVien hocVien2 = (SinhVien) hocVien1;
 * Lỗi ClassCastException tại runtime (nếu HocVien không phải là SinhVien).
 * → HocVien không thể ép kiểu trực tiếp thành SinhVien, trừ khi hocVien1 thực sự là một instance của SinhVien (tức là new SinhVien()).
 *
 * ChuyenVien hocVien3 = (ChuyenVien) hocVien2;
 * Lỗi ClassCastException tại runtime (nếu hocVien2 không phải là ChuyenVien).
 * hocVien2 (được ép kiểu từ HocVien thành SinhVien) không thể ép kiểu tiếp thành ChuyenVien, trừ khi SinhVien là con của ChuyenVien (trường hợp này có thể không hợp lệ).
 *
 * NVChinhThuc hocVien4 = hocVien3;
 * Lỗi biên dịch (Compile-time Error).
 * → hocVien3 có kiểu ChuyenVien, không thể gán trực tiếp cho NVChinhThuc nếu không có quan hệ kế thừa.
 *
 *HocVien hocVien5 = hocVien3;
 * → Hợp lệ nếu ChuyenVien là một lớp con của HocVien.
 *
 * HocVien hocVien6 = (HocVien) hocVien2;
 * → Hợp lệ, vì hocVien2 đã được khai báo là HocVien.
 *
 * HocVien hocVien7 = (NVQuanLy) hocVien6;
 * Lỗi ClassCastException tại runtime (nếu hocVien6 không phải là NVQuanLy).
 * → hocVien6 có thể là HocVien, nhưng không thể ép kiểu thành NVQuanLy trừ khi thực sự được khởi tạo từ NVQuanLy.
 *
 * NVChinhThuc hocVien8 = (NVChinhThuc) hocVien7;
 * Lỗi ClassCastException tại runtime (nếu hocVien7 không phải là NVChinhThuc).
 * → hocVien7 được ép kiểu từ hocVien6, nhưng nếu nó không thực sự là NVChinhThuc, sẽ gây lỗi.
 *
 * SinhVien hocVien9 = (SinhVien) hocVien3;
 * Lỗi ClassCastException tại runtime (nếu hocVien3 không phải là SinhVien).
 * → hocVien3 có kiểu ChuyenVien, không thể ép kiểu thành SinhVien.
 */
}
