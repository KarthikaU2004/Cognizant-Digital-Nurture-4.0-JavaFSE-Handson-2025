package com.example;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password.length() < 8)
            return false;

        boolean hasDigit = false, hasUpper = false, hasLower = false;

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) hasDigit = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
        }

        return hasDigit && hasUpper && hasLower;
    }
}
