package ss9.validation;

import ss9.exception.EmptyFieldException;
import ss9.exception.MinLengthException;
import ss9.exception.NegativeNumberException;
import ss9.exception.NumberOutOfRangeException;

public class CommonValidation {
    public static void validateIsEmpty(String value, String fieldName) throws EmptyFieldException {
        if (value.isEmpty()) {
            throw new EmptyFieldException(fieldName + " không được trống.");
        }
    }

    public static int parseInt(String value, String fieldName) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " phải là số nguyên.");
        }
    }

    public static double parseDouble(String value, String fieldName) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " phải là số thực.");
        }
    }

    // Kiểm tra giá trị nằm ngoài phạm vi
    public static void validateNumberOutOfRangeException(double value, String fieldName, double minValue, double maxValue) throws NumberOutOfRangeException {
        if (value < minValue || value > maxValue) {
            throw new NumberOutOfRangeException(
                    String.format("%s nằm ngoài khoảng giá trị hợp lệ [%s, %s].", fieldName, minValue, maxValue));
        }
    }

    // Kiểm tra độ dài chuỗi tối thiểu
    public static void validateMinLength(String value, String fieldName, int minLength) throws MinLengthException {
        if (value.length() < minLength) {
            throw new MinLengthException(String.format("%s phải có ít nhất %s ký tự.", fieldName, minLength));
        }
    }

    // Kiểm tra số âm
    public static void validateIsNegativeNumber(double value, String fieldName) throws NegativeNumberException {
        if (value < 0) {
            throw new NegativeNumberException(fieldName + " không được số âm.");
        }
    }

}
