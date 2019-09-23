package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Substitution {
    public static List<List<String>> getPolybiusMatrix(String alphabet) {
        List<List<String>> matrix = new ArrayList<>();
        int sizeOfLine = Math.sqrt(alphabet.length()) % 1 == 0 ? (int) Math.sqrt(alphabet.length()) : (int) Math.sqrt(alphabet.length()) + 1;

        Arrays.asList(alphabet.split("(?<=\\G.{" + sizeOfLine + "})"))
                .forEach(line -> matrix.add(Arrays.asList(line.split(""))));
        return matrix;
    }

    public static String Encrypt(List<List<String>> matrix, String content) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {
            int columnIndex;
            int rowIndex = -1;
            for (columnIndex = 0; columnIndex < matrix.size(); columnIndex++) {
                String tmp = Character.toString(content.charAt(i));
                if (matrix.get(columnIndex).contains(tmp)) {
                    rowIndex = matrix.get(columnIndex).indexOf(tmp);
                    break;
                }
            }

            result.append(String.format("%d%d", columnIndex, rowIndex));
        }

        return result.toString();
    }

    public static String Decrypt(List<List<String>> matrix, String content) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < content.length(); i += 2) {
            List<String> curList = matrix.get(Character.getNumericValue(content.charAt(i)));
            String curString = curList.get(Character.getNumericValue(content.charAt(i + 1)));
            result.append(curString);
        }

        return result.toString();
    }

}
