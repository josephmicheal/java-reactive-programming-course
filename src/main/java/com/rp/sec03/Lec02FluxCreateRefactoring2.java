package com.rp.sec03;

import java.util.function.Consumer;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Lec02FluxCreateRefactoring2 {

    public static void main(String[] args) {

    	NameConsumer nameProducer = new NameConsumer();

        Flux.create(nameProducer).subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);

    }
}

class NameConsumer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce(){
    	String procuded = Thread.currentThread().getName() + " : " + Util.faker().name().fullName();
    	System.out.println("Produced "+ procuded);
        this.fluxSink.next(procuded);
    }
}