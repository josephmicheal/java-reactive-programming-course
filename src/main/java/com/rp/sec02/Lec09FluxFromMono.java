package com.rp.sec02;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {
        
        Flux.from(Mono.just("a")).subscribe(Util.onNext());

        Flux.range(1, 10)
        		.filter(i -> i > 3)
                .next() // 1 is coming as Mono
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());   	

        Flux.range(1, 10)
                .next() // 1
                .filter(i -> i > 3)// condition not met for element one so Mono will be empty
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
/*
Output:
	2022/10/09 22:54:36 : Received : a
	2022/10/09 22:54:36 : Received : 4
	2022/10/09 22:54:36 : Completed
	2022/10/09 22:54:36 : Completed
	*/