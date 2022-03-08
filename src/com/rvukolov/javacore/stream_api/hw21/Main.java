package com.rvukolov.javacore.stream_api.hw21;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        for (Integer integer : intList) {
            if (integer > 0 && integer % 2 == 0) {
                newList.add(integer);
            }
        }

        newList.sort(Comparator.naturalOrder());
        System.out.println(newList);
    }
}
