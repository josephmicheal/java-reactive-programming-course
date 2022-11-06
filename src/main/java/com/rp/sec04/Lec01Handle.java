package com.rp.sec04;

import java.time.Month;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    public static void main(String[] args) {

        // handle = filter + map
    	// handle
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if(integer == 7)
                        synchronousSink.complete();
                    else
                        synchronousSink.next(Month.of(integer).name());
                })
                .subscribe(Util.subscriber());
        
        // filter + map
        Flux.range(1,20).filter(integer ->  integer < 7).map(integer -> Month.of(integer).name()).subscribe(Util.subscriber());

    }

}
