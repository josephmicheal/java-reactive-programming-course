 package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo2 {
	public static void main(String[] args) {
		
		Flux<Object> flux11 =  Flux.create(fluxSink -> {
			printThreadName("create");
			fluxSink.next(1);
		}).doOnNext(i -> printThreadName("next " + i));
		
		flux11.subscribe(Util.subscriber());
		flux11.subscribe(Util.subscriber());
		
		System.out.println("******************************************");

		Flux<Object> flux = Flux.create(fluxSink -> {
			printThreadName("create");
			fluxSink.next(1);
		}).doOnNext(i -> printThreadName("next " + i));

		flux.doFirst(() -> printThreadName("first2"))
				.subscribeOn(Schedulers.boundedElastic())
				.doFirst(() -> printThreadName("first1"))
				.subscribe(v -> printThreadName("sub " + v));

		Util.sleepSeconds(5);
	}

	private static void printThreadName(String msg) {
		System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
	}
}
