package com.company;

import com.company.algorithms.Substitution;
import com.company.util.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SubstitutionMain {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789.?!,;:-()\" ";

    public static void main(String[] args) throws IOException {
        List<List<String>> dictionary = Substitution.getPolybiusMatrix(ALPHABET);
        String content = Files.lines(Paths.get("src\\resources\\SubstitutionInput.txt"), UTF_8)
                .collect(Collectors.joining(System.lineSeparator())).toLowerCase();


        String encryptMsg = Substitution.Encrypt(dictionary, content);
        StringBuilder res = new StringBuilder(String.format("Зашифрованный текст:\n %s", encryptMsg));

        String decryptMsg = Substitution.Decrypt(dictionary, encryptMsg);
        res.append(String.format("\nРасшифрованный текст:\n %s", decryptMsg));

        Utils.writeToFileConsole(res.toString(), "src\\resources\\SubstitutionOutput.txt");
    }
}
