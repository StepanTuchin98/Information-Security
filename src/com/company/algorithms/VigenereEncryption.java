package com.company.algorithms;

import static com.company.util.Utils.mod;

public class VigenereEncryption {
    public static String vigenereEncrypt(String alphabet, String keyWord, String text) {
        StringBuilder result = new StringBuilder();

        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (j == keyWord.length() - 1) {
                j = 0;
            }

            int cryptValueIndex = mod(alphabet.indexOf(text.charAt(i)) + alphabet.indexOf(keyWord.charAt(j)), alphabet.length());
            result.append(alphabet.charAt(cryptValueIndex));
            j++;
        }

        return result.toString();
    }

    public static String vigenereDecrypt(String alphabet, String keyWord, String cipher) {
        StringBuilder result = new StringBuilder();

        int j = 0;
        for (int i = 0; i < cipher.length(); i++) {
            if (j == keyWord.length() - 1) {
                j = 0;
            }

            int originalTextValueIndex = mod(alphabet.indexOf(cipher.charAt(i)) + alphabet.length() - alphabet.indexOf(keyWord.charAt(j)),
                    alphabet.length());
            result.append(alphabet.charAt(originalTextValueIndex));
            j++;
        }

        return result.toString();
    }
}
