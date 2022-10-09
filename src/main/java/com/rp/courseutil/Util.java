package com.rp.courseutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

import org.reactivestreams.Subscriber;

import com.github.javafaker.Faker;

public class Util {

	private static final Faker FAKER = Faker.instance();

	public static Consumer<Object> onNext() {
		return o -> System.out.println(getDateTimeNow()+ "Received : " + o);
	}

	public static Consumer<Throwable> onError() {
		return e -> System.out.println(getDateTimeNow() + "ERROR : " + e.getMessage());
	}

	public static Runnable onComplete() {
		return () -> System.out.println(getDateTimeNow()+ "Completed");
	}

	public static Faker faker() {
		return FAKER;
	}

	public static void sleepSeconds(int seconds) {
		sleepMillis(seconds * 1000);
	}

	public static void sleepMillis(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Subscriber<Object> subscriber() {
		return new DefaultSubscriber();
	}

	public static Subscriber<Object> subscriber(String name) {
		return new DefaultSubscriber(name);
	}

	public static String getDateTimeNow() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now)+" : ";
	}

}
