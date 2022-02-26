package com.rvukolov.javacore.lambdas.HW12;

public class Main {
    public static void main(String[] args) {
        IOnDoneListener listener = System.out::println;
        IOnErrorListener errorListener = System.out::println;
        Worker worker = new Worker(listener,errorListener);
        worker.start();
    }
}
