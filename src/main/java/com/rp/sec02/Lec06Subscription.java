package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(2);
        Util.sleepSeconds(5);
        atomicReference.get().request(2);
        Util.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(4);

        Util.sleepSeconds(3);

    }
}
/*
Output:
	[ INFO] (main) | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
	Received Sub : reactor.core.publisher.StrictSubscriber@769c9116
	[ INFO] (main) | request(2)
	[ INFO] (main) | onNext(1)
	onNext : 1
	[ INFO] (main) | onNext(2)
	onNext : 2
	[ INFO] (main) | request(2)
	[ INFO] (main) | onNext(3)
	onNext : 3
	[ INFO] (main) | onNext(4)
	onNext : 4
	going to cancel
	[ INFO] (main) | cancel()
	*/
