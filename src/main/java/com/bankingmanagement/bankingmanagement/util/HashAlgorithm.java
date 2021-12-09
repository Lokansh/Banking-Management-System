package com.bankingmanagement.bankingmanagement.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashAlgorithm {

    public static boolean validateSHA256Hash(final String source,
                                      final String targetHash) {
        final String sourceHash = getSHA256Hash(source);
        if (sourceHash == null || targetHash == null) {
            return false;
        }
        return sourceHash.equals(targetHash);
    }

    public static String getSHA256Hash(final String str) {
        if (str == null) {
            return null;
        }
        try {
            final MessageDigest messageDigest =
                    MessageDigest.getInstance("SHA-256");
            return String.format("%064x",
                    new BigInteger(1,
                            messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))));
        } catch (final NoSuchAlgorithmException e) {
            return null;
        }
    }
}
