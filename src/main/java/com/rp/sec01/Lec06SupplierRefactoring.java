package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main2(String[] args) {

        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(o -> System.out.println("Received : " + o +" at time "+System.currentTimeMillis()));
        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(o -> System.out.println("Received : " + o +" at time "+System.currentTimeMillis()));
        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(o -> System.out.println("Received : " + o +" at time "+System.currentTimeMillis()));

        Util.sleepSeconds(6);
    }
    
    public static void main(String[] args) {

        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println("Received : " + name +" at time "+System.currentTimeMillis());
        getName();

        Util.sleepSeconds(6);
    }

    
    private static Mono<String> getName(){
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
