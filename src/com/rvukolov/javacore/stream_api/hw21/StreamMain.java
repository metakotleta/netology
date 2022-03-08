package com.rvukolov.javacore.stream_api.hw21;

import java.util.*;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        intList.stream()
                .filter(i -> i > 0)
                .filter(i -> i % 2 ==0)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
