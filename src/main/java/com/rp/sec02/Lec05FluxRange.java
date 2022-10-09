package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {

        Flux.range(2, 3)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(
                        Util.onNext()
                );
    }
}

/*Output:
	
	[ INFO] (main) | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
	[ INFO] (main) | onSubscribe([Fuseable] FluxMapFuseable.MapFuseableSubscriber)
	[ INFO] (main) | request(unbounded)
	[ INFO] (main) | request(unbounded)
	[ INFO] (main) | onNext(2)
	[ INFO] (main) | onNext(Yetta Macejkovic)
	Received : Yetta Macejkovic
	[ INFO] (main) | onNext(3)
	[ INFO] (main) | onNext(Melvin Hagenes)
	Received : Melvin Hagenes
	[ INFO] (main) | onNext(4)
	[ INFO] (main) | onNext(Ms. Kelsi Lind)
	Received : Ms. Kelsi Lind
	[ INFO] (main) | onComplete()
	[ INFO] (main) | onComplete()
*/