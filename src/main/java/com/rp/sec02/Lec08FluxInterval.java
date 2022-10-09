package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSeconds(5);
    }
}
/*
Output:
	2022/10/09 22:48:26 : Received : 0
	2022/10/09 22:48:27 : Received : 1
	2022/10/09 22:48:28 : Received : 2
	2022/10/09 22:48:29 : Received : 3
	2022/10/09 22:48:30 : Received : 4
	*/