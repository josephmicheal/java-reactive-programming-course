package com.rp.sec02;

import java.util.List;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;

public class Lec07FluxVsList {

    public static void main(String[] args) {

    	System.out.println(Util.getDateTimeNow() +"List which has delay of a second to get each item ");
        List<String> names = NameGenerator.getNamesAsList(5);
        System.out.println(Util.getDateTimeNow() +names);

        System.out.println(Util.getDateTimeNow() +"Flux which has delay of a second to get each item ");
        NameGenerator.getNamesAsFlux(5)
                .subscribe(Util.onNext());
    }
}
/*
Output:
	2022/10/09 22:41:33 : List which has delay of a second to get each item 
	2022/10/09 22:41:39 : [Mr. Emmanuel Kuvalis, Luigi Kertzmann, Piper Leffler III, Corine Funk, Leeanna Prohaska]
	2022/10/09 22:41:39 : Flux which has delay of a second to get each item 
	2022/10/09 22:41:40 : Received : Bennie McDermott
	2022/10/09 22:41:41 : Received : Mike Johnston
	2022/10/09 22:41:42 : Received : Dr. Jed Robel
	2022/10/09 22:41:43 : Received : Gearldine Beatty III
	2022/10/09 22:41:44 : Received : Mireya Ferry II
*/