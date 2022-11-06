package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {

        Flux.range(1, 3)
                .delayElements(Duration.ofSeconds(1))
                .log()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(4);
        System.out.println("*************************");
        
        Flux.interval(Duration.ofSeconds(1))
        .log()
        .subscribeOn(Schedulers.boundedElastic())
        .subscribe(Util.subscriber());
        
        Util.sleepSeconds(10);
    }
}
/*
public final Flux<T> delayElements(Duration delay) {
	return delayElements(delay, Schedulers.parallel());
}
public static Flux<Long> interval(Duration period) {
	return interval(period, Schedulers.parallel());
}
*/