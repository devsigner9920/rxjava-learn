package io.dvsgn.learn;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MissingBackpressureExceptionExample {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println(data + ": " + Thread.currentThread()))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            System.out.println("# 소비자 처리 대기 중..");
                            Thread.sleep(1000L);
                            Thread currentThread = Thread.currentThread();

                            System.out.println(data + " : " + currentThread.getName());
                        },
                        Throwable::printStackTrace,
                        () -> System.out.println("complete")
                );

        Thread.sleep(2000L);
    }
}
