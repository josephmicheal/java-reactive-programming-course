package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {
    	
    	System.out.println("Flux empty................");
    	 Flux.empty().subscribe(
                 Util.onNext(),
                 Util.onError(),
                 Util.onComplete());
    	
    	 System.out.println("Flux one item................");
    	 Flux.just(1).subscribe(
                 Util.onNext(),
                 Util.onError(),
                 Util.onComplete());

    	 System.out.println("Flux multiple items................");
        Flux<Object> flux = Flux.just(1,2, 3, "a", Util.faker().name().fullName());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
