package com.rvukolov.javacore.stream_api.hw22;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        //Task 1
        long underAgeCount = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(underAgeCount);

        //Task 2
        List<String> conscripts = persons.stream()
                .filter(x -> x.getAge() > 17 && x.getAge() < 28)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(conscripts);


        //Task 3
        List<String> workers = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER && x.getAge() > 17)
                .filter(x -> (x.getSex() == Sex.WOMAN && x.getAge() < 61) ||
                        (x.getSex() == Sex.MAN && x.getAge() < 66))
//                .sorted(Comparator.naturalOrder())
                .sorted(Comparator.comparing(Person::getFamily))
                .map(Person::toString)
                .collect(Collectors.toList());
        System.out.println(workers);
    }
}
