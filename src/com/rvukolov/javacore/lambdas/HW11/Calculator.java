package com.rvukolov.javacore.lambdas.HW11;

import java.util.function.*;

public class Calculator {

    public static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> div = (x, y) -> y != 0 ? x / y : Integer.MAX_VALUE;

    /** Не уверен, что корректно возвращать максимальное значение инта,
     * на мой взгляд, самое очевидно - можно отловить и обработать эксепшн.
     * Но решил оставить и такой вариант, раз уж речь пошла о тернарном операторе.
     */

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
