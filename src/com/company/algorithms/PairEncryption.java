package com.company.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PairEncryption {
    public static String getPairEncryption(String alphabet, String keyWord, String text)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder tempAlphabet = new StringBuilder(alphabet);
        keyWord = Arrays.stream(keyWord.split(""))
                .distinct()
                .collect(Collectors.joining());

        for (int i = 0; i < keyWord.length(); i++)
        {
            tempAlphabet.deleteCharAt(tempAlphabet.indexOf(Character.toString(keyWord.charAt(i))));
        }

        if(tempAlphabet.length() < keyWord.length())
        {
            int difference = keyWord.length() - tempAlphabet.length();

            for(int i = keyWord.length() - difference; i < keyWord.length(); i++)
            {
                tempAlphabet.append(keyWord.charAt(i));
            }
        }

        for (int i = 0; i < text.length(); i++)
        {
            String isContains = Character.toString(text.charAt(i));
            if (tempAlphabet.toString().contains(isContains))
            {
                result.append(keyWord.charAt(tempAlphabet.indexOf(isContains)));
            }
            else
            {
                result.append(tempAlphabet.charAt(keyWord.indexOf(isContains)));
            }
        }

        return result.toString();
    }
}
