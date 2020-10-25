package se.hernebring.utils;
import java.util.ArrayList;
import java.util.List;

public class ListUtilsInsertionSortDemo {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        test.add(4);
        test.add(1);
        test.add(2);
        test.add(1);
        test.add(3);
        test.add(1);
        List<Integer> sortedTest = ListUtils.insertionSort(test);
        System.out.println(sortedTest);
    }

}
