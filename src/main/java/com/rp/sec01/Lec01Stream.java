package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1)
                                        .map(i -> {
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            return i * 2;
                                        });

        //System.out.println(stream); nothing will happen as terminal operator is not called at all
        stream.forEach(System.out::println); // only it will work on calling one of the terminal operator

    }


}
