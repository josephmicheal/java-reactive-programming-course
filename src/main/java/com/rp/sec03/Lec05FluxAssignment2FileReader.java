package com.rp.sec03;

import java.io.File;
import java.util.Scanner;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec05FluxAssignment2FileReader {

	public static void main(String[] args) {
		Flux.generate(() -> new Scanner(new File("business-financial-data-june-2022-quarter-csv.csv")),
				(scanner, synchronusSink) -> {
					if (scanner.hasNext()) {
						synchronusSink.next(Thread.currentThread().getName() + " : " +scanner.nextLine());
					}
					return scanner;
				}, scanner -> scanner.close()).take(10).subscribe(Util.subscriber());
	}

}
