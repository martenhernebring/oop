package se.hernebring.utils;
import java.util.Scanner;

import se.hernebring.utils.CharacterUtils;
import se.hernebring.utils.CharacterUtils.LetterType;

public class CharacterUtilsConsonantsVowelsDemo {
    private static void printClassificationOfString(String string) {
        int vowels = 0;
        int consonants = 0;
        int other = 0;

        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char ch = string.charAt(i);
            LetterType type = CharacterUtils.classifyLetter(ch);
            if (type == LetterType.CONSONANT) {
                consonants++;
            }
            else if (type == LetterType.VOWEL) {
                vowels++;
            }
            else {
                other++;
            }
        }

        System.out.printf("Antal konsonanter: %d, vokaler: %d och övriga: %d%n",
            consonants, vowels, other);
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Skriv in en text:");
            String text = scan.nextLine();
            printClassificationOfString(text);
        }
    }
}
