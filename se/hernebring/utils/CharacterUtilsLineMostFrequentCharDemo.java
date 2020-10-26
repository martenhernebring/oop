package se.hernebring.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterUtilsLineMostFrequentCharDemo {
    public static void main(String[] args) {
        String[] textLines = {"Hoppsan.", "Vem kommer hem klockan fem?","Hello everybody."};
        List<String> textList = new ArrayList<>(Arrays.asList(textLines));
        System.out.println(CharacterUtils.lineWhereCharIsMostFrequent(textList,'e'));
    }
}
