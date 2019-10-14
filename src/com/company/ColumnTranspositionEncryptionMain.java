package com.company;

import com.company.algorithms.ColumnTranspositionEncryption;
import com.company.util.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ColumnTranspositionEncryptionMain {
    public static void main(String[] args) throws IOException {
        String content = Files.lines(Paths.get("src\\resources\\ColumnTranspositionInput.txt"), UTF_8)
                .collect(Collectors.joining(System.lineSeparator())).toLowerCase();

        String encryptMsg = ColumnTranspositionEncryption.encrypt("шифр", content);
        StringBuilder res = new StringBuilder(String.format("Зашифрованный текст:\n %s", encryptMsg));

        String decryptMsg = ColumnTranspositionEncryption.decrypt("шифр", encryptMsg);
        res.append(String.format("\nРасшифрованный текст:\n %s", decryptMsg));

        Utils.writeToFileConsole(res.toString(), "src\\resources\\ColumnTranspositionOutput.txt");
    }
}
