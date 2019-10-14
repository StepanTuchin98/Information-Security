package com.company.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnTranspositionEncryption {
    public static String encrypt(String keyWord, String text) {
        StringBuilder result = new StringBuilder();
        int rowCount = text.length() % keyWord.length() == 0 ?
                text.length() / keyWord.length() :
                text.length() / keyWord.length() + 1;

        List<List<Character>> matrix = new ArrayList<>();
        StringBuilder textCopy = new StringBuilder(text);

        for (int i = 0; i < rowCount; i++) {
            List<Character> temp = new ArrayList<>();

            for (int j = 0; j < keyWord.length(); j++) {
                if (textCopy.length() == 0) {
                    break;
                }

                temp.add(textCopy.charAt(0));
                textCopy.deleteCharAt(0);
            }

            matrix.add(temp);
        }

        List<Character> sortedKeyWord = keyWord
                .chars()
                .mapToObj(e -> (char) e)
                .sorted(Character::compareTo)
                .collect(Collectors.toList());


        int count = 0;
        int difference = keyWord.length() * rowCount - text.length();
        int originalRowCount = rowCount;
        while (count < keyWord.length()) {
            int columnIndex = keyWord.indexOf(sortedKeyWord.get(count));
            rowCount = originalRowCount;

            if (columnIndex >= keyWord.length() - difference) {
                rowCount -= 1;
            }

            for (int i = 0; i < rowCount; i++) {
                result.append(matrix.get(i).get(columnIndex));
            }

            count++;
        }

        return result.toString();
    }

    public static String decrypt(String keyWord, String cipher) {
        StringBuilder result = new StringBuilder();
        int rowCount = cipher.length() % keyWord.length() == 0 ?
                cipher.length() / keyWord.length() :
                cipher.length() / keyWord.length() + 1;
        List<Character> sortedKeyWord = keyWord.chars()
                .mapToObj(e -> (char) e)
                .sorted(Character::compareTo)
                .collect(Collectors.toList());

        List<List<Character>> matrix = new ArrayList<>();
        int originalRowCount = rowCount;
        StringBuilder cipherCopy = new StringBuilder(cipher);
        int i = 0;
        while (i < keyWord.length()) {
            rowCount = originalRowCount;

            if (keyWord.indexOf(sortedKeyWord.get(i)) > keyWord.length() - (keyWord.length() * rowCount - cipher.length())) {
                rowCount -= 1;
            }

            List<Character> temp = new ArrayList<>();

            for (int j = 0; j < rowCount; j++) {
                if (cipherCopy.length() == 0) {
                    break;
                }

                temp.add(cipherCopy.charAt(0));
                cipherCopy.deleteCharAt(0);
            }

            matrix.add(temp);
            i++;
        }

        int columnIndex = 0;
        while (columnIndex < rowCount) {
            for (int j = 0; j < keyWord.length(); j++) {
                if (result.length() == cipher.length()) {
                    break;
                }

                result.append(matrix.get(sortedKeyWord.indexOf(keyWord.charAt(j))).get(columnIndex));
            }

            columnIndex++;
        }

        return result.toString();
    }
}

