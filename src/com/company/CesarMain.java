package com.company;

import com.company.algorithms.Cesar;
import com.company.util.Utils;

import java.io.*;

public class CesarMain {

    public static void main(String[] args) throws IOException {
        String input = "";

        FileInputStream fis = new FileInputStream("src\\resources\\CesarInput.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        input = reader.readLine();

        String encryption = Cesar.getCesarResult(input, 5, 29, true);
        StringBuilder result = new StringBuilder(String.format("Зашифрованный текст: %s", encryption));
        result.append(String.format("\nРасшифрованный текст: %s", Cesar.getCesarResult(encryption, 5, 29, false)));

        Utils.writeToFileConsole(result.toString(), "src\\resources\\CesarOutput.txt");
    }
}
