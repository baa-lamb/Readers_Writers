package org.lab10;

import java.util.LinkedList;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Created by Alena on 21.05.2017.
 */
public class Main {
    public static void main(String argc[]){
       /* long t1 = System.currentTimeMillis();
        WritersReaders w = new WritersReaders();
        w.goReadWrite();
        long t2 = System.currentTimeMillis();
        t1 = t2 - t1;
        System.out.println("___________\n"+t1+"_____________\n");

        long t3 = System.currentTimeMillis();
        WritersReadersFast w1 = new WritersReadersFast(10);
        w1.goReadWriteFast(3);
        long t4 = System.currentTimeMillis();
        t3 = t4 - t3;
        System.out.println("___________\n"+t3+"_____________\n");*/


        LinkedList<Integer> list1 = new LinkedList<>();
        for(int i = 0; i < 90000; i++){
            list1.add(i);
        }
        Comparatot max = new Comparatot();
        Comparatot2 min = new Comparatot2();
        IterativeParallelism searchMin = new IterativeParallelism();

        long time1 = System.currentTimeMillis();
        int res = searchMin.MinMax(1,list1,max);
        long time2 = System.currentTimeMillis();
        time1 = time2 - time1;
        System.out.println("Time: " + time1);
        System.out.println("Result is "+res);

        long time3 = System.currentTimeMillis();
        int res2 = searchMin.MinMax(2,list1,max);
        long time4 = System.currentTimeMillis();
        time3 = time4 - time3;
        System.out.println("Time: " + time3);
        System.out.println("Result is "+ res2);

        Predicate<Integer> p = x -> x >= 0; // проверка на положительность элементов; задаём условие
        IterativeParallelism2 predicate = new IterativeParallelism2();
        System.out.println(predicate.AllAny(2, list1, true, p));

    }
}


/**Lambda-выражения – это анонимные функции. Проще говоря, это метод без объявления,
т.е. без модификаторов доступа, возвращающие значение и имя.
Короче говоря, они позволяют написать метод и сразу же использовать его.
Особенно полезно в случае однократного вызова метода, т.к. сокращает время на объявление и написание метода
без необходимости создавать класс.

Lambda-выражения в Java обычно имеют следующий синтаксис (аргументы) -> (тело). Например:
 (арг1, арг2...) -> { тело }
 (тип1 арг1, тип2 арг2...) -> { тело }*/