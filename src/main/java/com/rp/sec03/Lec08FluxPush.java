package com.rp.sec03;

import java.util.function.Consumer;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Lec08FluxPush {
    public static void main(String[] args) {

        NameProducer1 nameProducer = new NameProducer1();

        Flux.create(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}

class NameProducer1 implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce(){
        String name = Util.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next(thread + " : " + name);
    }

}