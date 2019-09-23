package com.company.algorithms;

import static com.company.util.Utils.mod;

public class Cesar {

    public static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ".toLowerCase();

    public static String getCesarResult(String input, int n, int k, boolean encrypt) {
        input = input.toLowerCase();
        int m = ALPHABET.length();
        char[] initial = input.toCharArray();

        if (encrypt) {
            for (int i = 0; i < initial.length; i++) {
                int pos = ALPHABET.indexOf(input.charAt(i));

                if (pos < 0) {
                    System.out.println(String.format("Буква %s не найдена", input.charAt(i)));
                }
                initial[i] = ALPHABET.charAt(mod((pos * n + k), m));
            }
        } else {
            int a = 0;
            int flag;
            for (int j = 0; j < m; j++) {
                flag = mod(n * j, m);

                if (flag == 1) {
                    a = j;
                    break;
                }
            }
            for (int i = 0; i < initial.length; i++) {
                int pos = ALPHABET.indexOf(input.charAt(i));
                if (pos < 0) {
                    System.out.println(String.format("Буква %s не найдена", input.charAt(i)));
                }
                int neededIndex = mod((pos - k) * a, m);
                initial[i] = ALPHABET.charAt(neededIndex);
            }
        }

        return new String(initial);
    }


}