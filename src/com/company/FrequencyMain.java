package com.company;

import com.company.algorithms.Frequency;

import java.io.*;
import java.text.DecimalFormat;

import static com.company.algorithms.Frequency.writeToFileAndConsole;
import static java.math.RoundingMode.CEILING;

public class FrequencyMain {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src\\resources\\FrequencyInput.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        FileWriter fw = new FileWriter(new File("src\\resources\\FrequencyOutput.txt"));
        String input = reader.readLine();
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(CEILING);

        Frequency.getLetterFrequency(input).entrySet()
                .forEach(e -> {
                    e.setValue(e.getValue() / input.length());
                    writeToFileAndConsole(fw, df, e);
                });
    }
}
