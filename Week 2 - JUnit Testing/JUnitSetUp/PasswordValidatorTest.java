package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Pass1234"));
    }

    @Test
    public void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Pa1"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(PasswordValidator.isValid("Password"));
    }

    @Test
    public void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("password123"));
    }

    @Test
    public void testNoLowercase() {
        assertFalse(PasswordValidator.isValid("PASSWORD123"));
    }
}
