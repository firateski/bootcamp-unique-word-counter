package org.kodluyoruz.bootcamp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class UniqueWordCounter {
    public int countNumberOfUniqueWords(String input) {
        ArrayList<String> uniqueWordList = new ArrayList<>();

        String[] dirtyWordList = input.split("\\s+");

        for(String dirtyWord : dirtyWordList){
            String lowerCasedWord = dirtyWord.toLowerCase(Locale.forLanguageTag("tr"));

            if(isValidWord(dirtyWord) && !uniqueWordList.contains(lowerCasedWord)){
                uniqueWordList.add(lowerCasedWord);
            }
        }

        return uniqueWordList.size();
    }

    private boolean isValidWord(String word) {
        final int[] turkishCharCodes = {199, 231, 286, 287, 304, 305, 214, 246, 350, 351, 220, 252};

        for (char c : word.toCharArray()) {
            int charCode = (int) c;

            if (charCode >= 48 && charCode <= 57) {
                return true;
            } else if (charCode >= 65 && charCode <= 90) {
                return true;
            } else if (charCode >= 97 && charCode <= 122) {
                return true;
            } else if(Arrays.stream(turkishCharCodes).anyMatch(i -> i == charCode)){
                return true;
            }
        }

        return false;
    }
}
