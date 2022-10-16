package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate2 {
	public static void main(String[] args) {
		Flux.create(fluxSink -> {
			fluxSink.next(Util.faker().country().name());
			fluxSink.next(Util.faker().country().name());
			fluxSink.complete();
		}).subscribe(Util.subscriber());
	}
}
