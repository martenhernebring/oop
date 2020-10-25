package se.hernebring.time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedVsArrayList {
    public static void main(String[] args) {
        List <Integer> al = new ArrayList<Integer>();
        List <Integer> ll = new LinkedList<Integer>();
        Integer intgr = 1;
        long test = System.currentTimeMillis();
        System.out.println(test);
        long start = System.currentTimeMillis();
        for(int i = 0;i<500000;i++){
            al.add(0,intgr);
        }
        long diff = System.currentTimeMillis() - start;
        System.out.printf("al0 time in ms: %d\n", diff);
        start = System.currentTimeMillis();
        for(int i = 0;i<500000;i++){
            ll.add(0,intgr);
        }
        diff = System.currentTimeMillis() - start;
        System.out.printf("ll0 time in ms: %d\n", diff);
        start = System.currentTimeMillis();
        for(int i = 0;i<500000;i++){
            al.add(al.size()-1,intgr);
        }
        diff = System.currentTimeMillis() - start;
        System.out.printf("als time in ms: %d\n", diff);
        start = System.currentTimeMillis();
        for(int i = 0;i<500000;i++){
            ll.add(ll.size()-1,intgr);
        }
        diff = System.currentTimeMillis() - start;
        System.out.printf("lls time in ms: %d\n", diff);
    }
}
