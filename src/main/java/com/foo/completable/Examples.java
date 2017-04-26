package com.foo.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Examples {
    static boolean called = false;
    
    public static void futureExample() {
        FutureTask<String> retrieveName = new FutureTask<>(() ->{
            System.out.println("Sleeping for 2 seconds...");
            Thread.sleep(2000);
            return "Future";
        });

        startThread(() -> {
            retrieveName.run();
            
            try {
                print(retrieveName.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
        });
    }
    
    public static void futureCallback() {
        startThread(() -> new RunnableCallback(it -> print(it)).run());
    }
    
    public static void promise() {
        final CompletableFuture<String> retrieveName = CompletableFuture.supplyAsync(() -> {
            System.out.println("Sleeping for 3 seconds");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return "Promise";
        });
        
        retrieveName.thenAccept(it -> print(it));
        
        startThread(() -> {
            try {
                retrieveName.get();
            } catch (InterruptedException | ExecutionException e) {
                new RuntimeException(e);
            }
        });
    }
    
    private static void startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private static void print(String input) {
        called = true;
        System.out.println("Printing: " + input);
    }
}
