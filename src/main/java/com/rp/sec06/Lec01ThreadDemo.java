package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
	public static void main(String[] args) {
		
		Flux<Object> flux11 =  Flux.create(fluxSink -> {
			printThreadName("create");
			fluxSink.next(1);
		}).doOnNext(i -> printThreadName("next " + i));
		
		flux11.subscribe(Util.subscriber());
		flux11.subscribe(Util.subscriber());
		
		// Using Runnable to process the content
		
		Flux<Object> flux1 = Flux.create(fluxSink -> {
			printThreadName("create");
			fluxSink.next(1);
		}).doOnNext(i -> printThreadName("next " + i));

		Runnable runnable = () -> flux1.subscribe(v -> printThreadName("sub " + v));
		for (int i = 0; i < 2; i++) {
			new Thread(runnable).start();
		}

		Util.sleepSeconds(3);
	}

	private static void printThreadName(String msg) {
		System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
	}
}
