package util;

public class InputValidator {

    //Name: no numbers allowed
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    //Email: must contain @ and .
    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    //Phone: exactly 10 digits
    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    //ID: positive number
    public static boolean isValidID(int id) {
        return id > 0;
    }
}