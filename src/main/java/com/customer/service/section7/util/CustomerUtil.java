package com.customer.service.section7.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * CustomerUtil is a utility class that provides common helper methods
 * used across the application, such as password hashing.
 */
public class CustomerUtil {

    /**
     * Hashes the given plain-text password using the SHA-256 algorithm.
     * This is useful for securely storing passwords in the database.
     *
     * @param password the raw password to hash
     * @return the hashed password in hexadecimal string format
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    /**
     * Converts a byte array to a hexadecimal string.
     * Used internally by the hashPassword method.
     *
     * @param bytes the byte array to convert
     * @return a hexadecimal string representing the byte array
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}