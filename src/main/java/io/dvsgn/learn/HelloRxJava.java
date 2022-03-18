package io.dvsgn.learn;

import io.reactivex.rxjava3.core.Flowable;

public class HelloRxJava {
    public static void main(String[] args) {
        Flowable.just("Hello World!")
                .subscribe(System.out::println);
    }
}
