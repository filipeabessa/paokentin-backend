package com.filipeabessa.paokentin.utils;

import java.util.Random;

public class Utils {
    public static String generateRandomHexColor() {
        Random random = new Random();
        // Generate three random numbers between 0 and 255 for RGB values
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // Convert RGB values to a hexadecimal string
        String hex = String.format("#%02x%02x%02x", red, green, blue);

        return hex;
    }
}
