package com.company.algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Character.toUpperCase;

public class Frequency {

    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static Map<Character, Double> getLetterFrequency(String input) {
        Map<Character, Double> frequencies = ALPHABET.chars()
                .mapToObj(letter -> (char) letter)
                .collect(Collectors.toMap(c -> c, c -> 0.0));

        input.chars()
                .filter(c -> frequencies.containsKey(toUpperCase((char) c)))
                .forEach(k -> frequencies.put(toUpperCase((char) k), frequencies.get(toUpperCase((char) k)) + 1));

        return frequencies;
    }

    public static void writeToFileAndConsole(FileWriter fw, DecimalFormat df, Map.Entry<Character, Double> entry) {
        try {
            fw.write(entry.getKey() + " | " + df.format(entry.getValue()));
            System.out.println(entry.getKey() + " | " + df.format(entry.getValue()));

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
