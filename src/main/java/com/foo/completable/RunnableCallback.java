package com.foo.completable;

import java.util.function.Consumer;

public class RunnableCallback implements Runnable {
    private final Consumer<String> callback;
    
    public RunnableCallback(Consumer<String> callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        System.out.println("Sleeping for 2 seconds");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        callback.accept("FutureCallback");
    }

}
