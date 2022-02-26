package com.rvukolov.javacore.lambdas.HW11;

public class Main {

    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        try {
            int a = calc.plus.apply(1, 2);
            int b = calc.minus.apply(1,1);
            int c = calc.div.apply(a, b);

            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
    }
}
