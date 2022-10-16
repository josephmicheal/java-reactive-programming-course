package com.rp.sec02.assignment;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import java.util.concurrent.CountDownLatch;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPriceAssignment {

    public static void main(String[] args) throws InterruptedException {
    	
    	CountDownLatch latch = new CountDownLatch(1);

        AtomicInteger currentVal = new AtomicInteger(100);
         Flux.interval(Duration.ofSeconds(1))
        .map(i -> currentVal.getAndAccumulate(Util.faker().random().nextInt(-5,5), Integer::sum))
        
        .subscribeWith(new Subscriber<Integer>() {
                	Subscription subscription;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                    	this.subscription  = subscription;
                        System.out.println("Received Sub : " + subscription);
                        subscription.request(Integer.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                        if(integer > 110 || integer < 90) {
                        	 subscription.cancel();
                        	 latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                        latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                        latch.countDown();
                    }
                });

         latch.await();

    }
}
