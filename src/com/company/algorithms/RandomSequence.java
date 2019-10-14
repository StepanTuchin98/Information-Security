package com.company.algorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.company.util.Utils.mod;

public class RandomSequence {

    public static String getGamming(int textLength, List<Character> alphabet) {
        StringBuilder key = new StringBuilder();
        int maxIndexLength = Integer.toString(alphabet.size() - 1, 2).length();
        int cipherLength = maxIndexLength * textLength;
        int registerLength = (int) (Math.log((double) cipherLength) / Math.log(2));

        List<Integer> startRegister = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < registerLength; i++) {
            startRegister.add(random.nextInt(2));
        }

        while (key.length() < cipherLength) {
            startRegister.add(0, (startRegister.get(0) ^ startRegister.get(startRegister.size() - 1)));
            key.append(startRegister.get(startRegister.size() - 1));
            startRegister.remove(startRegister.size() - 1);
        }

        return key.toString();
    }


    private static List<Integer> FindAllFactors(int number) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < Math.sqrt((double) number); i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }

        result.add(number);

        return result;
    }

    public static String getGammingLinear(int textLength, List<Character> alphabet) {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        int startValue = random.nextInt(alphabet.size()) + 1;

        List<Integer> incr;
        int increment;

        do {
            increment = random.nextInt(alphabet.size()) + 1;
            incr = FindAllFactors(increment);
            incr.retainAll(FindAllFactors(alphabet.size()));
        }while (!(Collections.max(incr) == 1));

        List<Integer> potentialMultipliers = new ArrayList<>();
        if (alphabet.size() % 4 == 0) {
            for (int i = 4; i < alphabet.size(); i += 4) {
                potentialMultipliers.add(i + 1);
            }
        }

        List<Integer> primeFactors = new ArrayList<>();
        List<Integer> allModulusFactors = FindAllFactors(alphabet.size());
        for (Integer allModulusFactor : allModulusFactors) {
            if (FindAllFactors(allModulusFactor).size() == 2) {
                primeFactors.add(allModulusFactor);
            }
        }

        int multiplier = -1;
        if (potentialMultipliers.size() > 0) {
            for (int i = 0; i < potentialMultipliers.size(); i++) {
                int j = 0;
                for (j = 0; j < primeFactors.size(); j++) {
                    if ((potentialMultipliers.get(i) - 1) % primeFactors.get(j) != 0) {
                        break;
                    }
                }

                if (j == primeFactors.size()) {
                    multiplier = potentialMultipliers.get(i);
                    break;
                }
            }
        } else {
            for (int i = 2; i < alphabet.size(); i++) {
                int j = 0;
                for (j = 0; j < primeFactors.size(); j++) {
                    if ((i - 1) % primeFactors.get(j) != 0) {
                        break;
                    }
                }

                if (j == primeFactors.size()) {
                    multiplier = i;
                    break;
                }
            }
        }

        result.append(alphabet.get(startValue));
        while (result.length() < textLength) {
            int letterIndex = mod(multiplier * startValue + increment, alphabet.size());
            result.append(alphabet.get(letterIndex));
            startValue = letterIndex;
        }

        return result.toString();
    }
}
