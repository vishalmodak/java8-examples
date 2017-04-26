package com.foo.completable;

import java.util.concurrent.ExecutionException;

public class CompletableTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Examples.futureExample();
        Examples.futureCallback();
        Examples.promise();
    }
    

}
