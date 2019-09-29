package com.company.algorithms;

import java.util.ArrayList;
import java.util.List;

public class VigenereEncryption {
    public static String getVigenereEncrypt(List<String> matrix, String keyWord, String text) {
        int posKeyWord = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int positionLetter = matrix.get(0).indexOf(text.charAt(i));
            StringBuilder firstLetterInStr = new StringBuilder();
            matrix.forEach(str -> firstLetterInStr.append(str.charAt(0)));
            int positionKeyLetter = firstLetterInStr.indexOf(Character.toString(keyWord.charAt(posKeyWord)));
            result.append(matrix.get(positionKeyLetter).charAt(positionLetter));

            posKeyWord++;
            if (posKeyWord >= keyWord.length()) {
                posKeyWord = 0;
            }
        }
        return result.toString();
    }

    public static String geVigenereDecrypt(List<String> matrix, String keyWord, String encrypt) {
        int posKeyWord = 0;
        StringBuilder result = new StringBuilder();

        StringBuilder firstLetterInStr = new StringBuilder();
        matrix.forEach(str -> firstLetterInStr.append(str.charAt(0)));

        for (int i = 0; i < encrypt.length(); i++) {
           int posKeyInList = firstLetterInStr.indexOf(Character.toString(keyWord.charAt(posKeyWord)));
           int posLetterChange = matrix.get(posKeyInList).indexOf(encrypt.charAt(i));
           result.append(matrix.get(0).charAt(posLetterChange));

            posKeyWord++;
            if (posKeyWord >= keyWord.length()) {
                posKeyWord = 0;
            }
        }
        return result.toString();

    }

    public static List<String> getVigenereMatrix(String alphabet) {
        List<String> matrix = new ArrayList<>();

        char lastChar = alphabet.charAt(alphabet.length() - 1);
        alphabet.chars().forEach(c -> matrix.add(alphabet.substring(alphabet.indexOf(c), alphabet.indexOf(lastChar) + 1) +
                alphabet.substring(0, alphabet.indexOf(c))));

        return matrix;
    }
}
