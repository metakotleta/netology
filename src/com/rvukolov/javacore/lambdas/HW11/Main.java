package com.rvukolov.javacore.lambdas.HW11;

public class Main {

    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.div.apply(5, 0);
        int b = calc.abs.apply(5);

        calc.println.accept(b);
    }
}
