package com.rp.sec02;

import java.util.Arrays;
import java.util.List;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {

    	// Flux from list
        List<String> strings = Arrays.asList("a", "b", "c");
    	Flux.fromIterable(strings)
                .subscribe(Util.onNext());

    	// Flux from array
         Integer[] arr = { 2, 5, 7, 8};
        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}

/*Output
Received : a
Received : b
Received : c
Received : 2
Received : 5
Received : 7
Received : 8
*/
