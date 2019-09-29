package com.company;

import com.company.algorithms.PairEncryption;
import com.company.util.Utils;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PairEncryptionMain {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789.?!,;:-()\" ";

    public static void main(String[] args) throws IOException {

        String content = Files.lines(Paths.get("src\\resources\\PairEncryptionInput.txt"), UTF_8)
                .collect(Collectors.joining(System.lineSeparator())).toLowerCase();
        String encryptMsg = PairEncryption.getPairEncryption(ALPHABET, "аабвгдеёжзийклмнопрстуфхцчшщъя", content);
        StringBuilder res = new StringBuilder(String.format("Зашифрованный текст:\n %s", encryptMsg));

        String decryptMsg = PairEncryption.getPairEncryption(ALPHABET, "аабвгдеёжзийклмнопрстуфхцчшщъя", encryptMsg);
        res.append(String.format("\nРасшифрованный текст:\n %s", decryptMsg));

        Utils.writeToFileConsole(res.toString(), "src\\resources\\PairEncryptionOutput.txt");
    }
}
