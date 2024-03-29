package com.company;

import com.company.algorithms.VigenereEncryption;
import com.company.util.Utils;

import java.io.IOException;
import java.util.List;

public class VigenereMain {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789.?!,;:-()\" ";

    public static void main(String[] args) throws IOException {
        List<String> matrix = VigenereEncryption.getVigenereMatrix(ALPHABET);
        matrix.forEach(System.out::println);

        String encryptMsg = VigenereEncryption.getVigenereEncrypt(matrix, "тайна", "мой код, чтобы прочитать");
        StringBuilder res = new StringBuilder(String.format("Зашифрованный текст:\n %s", encryptMsg));
        String decryptMsg = VigenereEncryption.geVigenereDecrypt(matrix, "тайна", encryptMsg);
        res.append(String.format("\nРасшифрованный текст:\n %s", decryptMsg));

        Utils.writeToFileConsole(res.toString(), "src\\resources\\VigenereOutput.txt");
    }
}
