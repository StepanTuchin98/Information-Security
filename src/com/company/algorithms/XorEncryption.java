package com.company.algorithms;

import java.util.List;

import static com.company.util.Utils.mod;

public class XorEncryption {
    public static String AddZero(String str, int maxLength) {
        StringBuilder result = new StringBuilder();
        int strLength = str.length();

        while (strLength < maxLength) {
            result.append('0');
            strLength++;
        }

        return result.toString();
    }

    private static String getBinaryFromAlpha(List<Character> alphabet, String text, int letterFromMsg) {
        return Integer.toString(alphabet.indexOf(text.charAt(letterFromMsg)), 2);
    }

    public static String XorEncryption(List<Character> alphabet, String keyWord, String text) {
        StringBuilder result = new StringBuilder();
        StringBuilder contentCrypt = new StringBuilder();
        StringBuilder keyWordCrypt = new StringBuilder();
        int maxIndexLength = Integer.toString(alphabet.size() - 1, 2).length();


        for (int i = 0, keyCur = 0; i < text.length(); i++, keyCur++) {
            String tempForText = getBinaryFromAlpha(alphabet, text, i);

            if (tempForText.length() < maxIndexLength) {
                contentCrypt.append(AddZero(tempForText, maxIndexLength));
            }
            contentCrypt.append(tempForText);

            if (keyCur == keyWord.length() - 1) {
                keyCur = 0;
            }

            String tempForKey = getBinaryFromAlpha(alphabet, keyWord, keyCur);
            if (tempForKey.length() < maxIndexLength) {
                keyWordCrypt.append(AddZero(tempForKey, maxIndexLength));
            }

            keyWordCrypt.append(tempForKey);

        }

        for (int i = 0; i < contentCrypt.length(); i++) {
            result.append(Integer.parseInt(Character.toString(contentCrypt.charAt(i))) ^
                    Integer.parseInt(Character.toString(keyWordCrypt.charAt(i))));
        }

        return result.toString();
    }

    public static String XorDecryption(List<Character> alphabet, String keyWord, String cipher) {
        StringBuilder result = new StringBuilder();
        StringBuilder keyWordCipher = new StringBuilder();
        int maxIndexLength = Integer.toString(alphabet.size() - 1, 2).length();

        int j = 0;
        for (int i = 0; i < cipher.length() / maxIndexLength; i++) {
            if (j == keyWord.length() - 1) {
                j = 0;
            }

            String tempForKey = Integer.toString(alphabet.indexOf(keyWord.charAt(j)), 2);

            if (tempForKey.length() < maxIndexLength) {
                keyWordCipher.append(AddZero(tempForKey, maxIndexLength));
            }

            keyWordCipher.append(tempForKey);
            j++;
        }

        StringBuilder originalTextBin = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            originalTextBin.append(Integer.parseInt(Character.toString(cipher.charAt(i))) ^
                    Integer.parseInt(Character.toString(keyWordCipher.charAt(i))));
        }

        for (int i = 0; i < originalTextBin.length(); i += maxIndexLength) {
            String temp = originalTextBin.toString().substring(i, i + maxIndexLength);


            if (!temp.equals(""))
                result.append(alphabet.get(Integer.parseInt(temp, 2)));
        }

        return result.toString();
    }


    public static String noKeyXorEncryption(List<Character> alphabet, String keyWord, String text) {
        StringBuilder result = new StringBuilder();
        StringBuilder contentCrypt = new StringBuilder();
        int maxIndexLength = Integer.toString(alphabet.size() - 1, 2).length();


        for (int i = 0, keyCur = 0; i < text.length(); i++, keyCur++) {
            String tempForText = getBinaryFromAlpha(alphabet, text, i);

            if (tempForText.length() < maxIndexLength) {
                contentCrypt.append(AddZero(tempForText, maxIndexLength));
            }
            contentCrypt.append(tempForText);

            if (keyCur == keyWord.length() - 1) {
                keyCur = 0;
            }
        }

        for (int i = 0; i < contentCrypt.length(); i++) {
            result.append(Integer.parseInt(Character.toString(contentCrypt.charAt(i))) ^
                    Integer.parseInt(Character.toString(keyWord.charAt(i))));
        }

        return result.toString();
    }

    public static String noKeyXorDecryption(List<Character> alphabet, String keyWord, String cipher) {
        StringBuilder result = new StringBuilder();
        int maxIndexLength = Integer.toString(alphabet.size() - 1, 2).length();

        int j = 0;
        for (int i = 0; i < cipher.length() / maxIndexLength; i++) {
            if (j == keyWord.length() - 1) {
                j = 0;
            }

            j++;
        }

        StringBuilder originalTextBin = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            originalTextBin.append(Integer.parseInt(Character.toString(cipher.charAt(i))) ^
                    Integer.parseInt(Character.toString(keyWord.charAt(i))));
        }

        for (int i = 0; i < originalTextBin.length(); i += maxIndexLength) {
            String temp = originalTextBin.toString().substring(i, i + maxIndexLength);

            if (!temp.equals(""))
                result.append(alphabet.get(Integer.parseInt(temp, 2)));
        }

        return result.toString();
    }
}
