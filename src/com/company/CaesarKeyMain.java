package com.company;

import com.company.algorithms.CaesarKey;
import com.company.algorithms.VigenereEncryption;
import com.company.util.Utils;

import java.io.IOException;

public class CaesarKeyMain {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789.?!,;:-()\" ";

    public static void main(String[] args) throws IOException {

        String encryptMsg = CaesarKey.vigenereEncrypt(ALPHABET, "тайна", "мой код, чтобы прочитать");
        StringBuilder res = new StringBuilder(String.format("Зашифрованный текст:\n %s", encryptMsg));

        String decryptMsg = CaesarKey.vigenereDecrypt(ALPHABET, "тайна", encryptMsg);
        res.append(String.format("\nРасшифрованный текст:\n %s", decryptMsg));

        Utils.writeToFileConsole(res.toString(), "src\\resources\\CaeserKeyOutput.txt");
    }
}
