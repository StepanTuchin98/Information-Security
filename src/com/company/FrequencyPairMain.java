package com.company;

import com.company.algorithms.FrequencyPair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

import static com.company.algorithms.FrequencyPair.writeToFileAndConsole;
import static java.math.RoundingMode.CEILING;
import static java.nio.charset.StandardCharsets.UTF_8;

public class FrequencyPairMain {
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(CEILING);
        FileWriter fw = new FileWriter(new File("src\\resources\\FrequencyPairOutput.txt"));
        String content = Files
                .lines(Paths.get("src\\resources\\FrequencyPairInput.txt"), UTF_8)
                .collect(Collectors.joining(System.lineSeparator())).toLowerCase();
        content = FrequencyPair.FromTextToWordsSequence(content);
        System.out.println(content);

        FrequencyPair.getLetterFrequencyPair(content).entrySet().forEach(e -> writeToFileAndConsole(fw, df, e));
        fw.close();
    }
}
