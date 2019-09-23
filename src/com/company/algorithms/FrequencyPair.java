package com.company.algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static com.company.algorithms.Frequency.writeToFileAndConsole;

public class FrequencyPair {
    public static String FromTextToWordsSequence(String text) {
        return text.replaceAll("[^А-Яа-я]", "");

    }

    public static Map<String, Double> getLetterFrequencyPair(String content) {
        Map<String, Double> pair = new HashMap<>();
        int totalPairCount = 0;

        for (int i = 0; i < content.length() - 1; i++) {
            StringBuilder temp = new StringBuilder();

            char cur = content.charAt(i);
            char next = content.charAt(i + 1);
            if (cur != ' ' && next != ' ') {
                temp.append(String.format("%c%c", cur, next));
                totalPairCount++;
                String keyPair = temp.toString();
                if (!pair.containsKey(keyPair)) {
                    pair.put(keyPair, 1.0);
                } else {
                    pair.put(keyPair, pair.get(keyPair) + 1);
                }
            }
        }
        final int count = totalPairCount;
        pair.entrySet().forEach(e -> e.setValue(e.getValue() / count));

        return pair;
    }

    public static void writeToFileAndConsole(FileWriter fw, DecimalFormat df, Map.Entry<String, Double> entry) {
        try {
            fw.write(entry.getKey() + " | " + df.format(entry.getValue()));
            System.out.println(entry.getKey() + " | " + df.format(entry.getValue()));

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}