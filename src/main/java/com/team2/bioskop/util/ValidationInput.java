package com.enigma.validation;

public class ValidationInput {
    public static int check(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("You must input integer value");
        }
        return -1;
    }
}