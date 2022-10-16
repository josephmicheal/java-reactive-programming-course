package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxAssignment1 {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            System.out.println("emitting");
            String ccuurentCountry  = Util.faker().country().name();
            synchronousSink.next(ccuurentCountry); // 1
            if(ccuurentCountry.toLowerCase().equals("canada"))
            	synchronousSink.complete();
        })
        .take(10)
        .subscribe(Util.subscriber());


    }

}
