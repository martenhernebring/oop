package se.hernebring.utils;

import java.util.List;

public class CharacterUtils {
    public static boolean isConsonant(char c) {
        int res = "aouåeiyäöAOUÅIEYÄÖ".indexOf(c);
        return res == -1 && Character.isAlphabetic(c);
    }

    public static boolean isVowel(char c) {
        return Character.isAlphabetic(c) && !isConsonant(c);
    }

    public static LetterType classifyLetter(char c) {
        if (isVowel(c)) {
            return LetterType.VOWEL;
        }
        else if (isConsonant(c)) {
            return LetterType.CONSONANT;
        }
        else {
            return LetterType.OTHER;
        }
    }
    
    public enum LetterType {
        VOWEL, CONSONANT, OTHER
    }
    
    static String lineWhereCharIsMostFrequent(List<String> textLines, char ch){
        String mostFrequent = null;
        int occurencies = 0;
        int counter = 0;
        for(String textLine : textLines){
            for(char oneChar : textLine.toCharArray()){
                if(oneChar == ch){
                    counter++;
                }
            }
            if (counter > occurencies){
                occurencies = counter;
                mostFrequent = textLine;
            }
            counter = 0;
        }
        return mostFrequent;
    }

}