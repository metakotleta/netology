package com.rvukolov.javacore.lambdas.HW12;

public class Worker {

    private IOnDoneListener callback;
    private IOnErrorListener errorCallback;

    public Worker(IOnDoneListener callback, IOnErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Step " + i + " failed");
            } else {
                callback.onDone("Step " + i + " done");
            }
        }
    }
}
