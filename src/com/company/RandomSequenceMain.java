package com.company;

import com.company.algorithms.XorEncryption;
import com.company.util.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.algorithms.RandomSequence.getGamming;
import static com.company.algorithms.RandomSequence.getGammingLinear;
import static java.nio.charset.StandardCharsets.UTF_8;

public class RandomSequenceMain {
    private static List<Character> alphabet = new ArrayList<>(Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '?', '!', ',', ';', ':', '-', '(', ')', '"',
            ' ', '\n', '\r'));

    public static void main(String[] args) throws IOException {

        String content = Files.lines(Paths.get("src\\resources\\XorInput.txt"), UTF_8)
                .collect(Collectors.joining(System.lineSeparator())).toLowerCase();
        //String key = getGamming(content.length(), alphabet);

        String key = getGammingLinear(content.length(), alphabet);
        String encryptMsg = XorEncryption.XorEncryption(alphabet, key, content);
        StringBuilder res = new StringBuilder(String.format("Зашифрованный текст:\n %s", encryptMsg));

        String decryptMsg = XorEncryption.XorDecryption(alphabet, key, encryptMsg);
        res.append(String.format("\nРасшифрованный текст:\n %s", decryptMsg));

        Utils.writeToFileConsole(res.toString(), "src\\resources\\XorOutput.txt");
    }
}
