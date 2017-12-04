package org.lab10;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by Alena on 28.05.2017.
 */
public class IterativeParallelism2 {

    private static class Threads extends Thread {

        Predicate<Integer> isAboveZero;
        LinkedList<Integer> l;
        int start = 0;
        int end = 0;
        int C = 0;

        public Threads(int s, int e, LinkedList<Integer> list, Predicate<Integer> p){
            start = s; end = e; l = list; isAboveZero = p;
        }

        public void run() {
            int count = 0;
            int i = 0; boolean flag = false;
            Iterator<Integer> it = l.iterator();
            while(it.hasNext()){
                if(i > end)
                    break;

                int cur = it.next();
                if(i == start && !flag)
                    flag = true;
                if(flag){
                    if(isAboveZero.test(cur))
                        count++;
                }
                i++;
            }
            C = count;
        }

        public int getCount(){return C;}
    }

    boolean AllAny(int NumberOfThreads, LinkedList<Integer> list, boolean flag, Predicate<Integer> predicate){
        ArrayDeque<struct> S = new ArrayDeque<struct>();
        int separator = (int)((double)list.size() / (double)NumberOfThreads);
        int end = separator * NumberOfThreads;
        Iterator<Integer> it = list.iterator();
        int first = 0, last = 0;

        int i = 0, j = 0, p = 0;
        while(it.hasNext()) {
            it.next();
            if(i % separator == 0) {
                first = i;
            }
            else {
                if(j == separator-1){
                    p++;
                    last = separator*p - 1;
                    S.push(new struct(first, last));
                    j = 0;
                }
            }
            i++;
            j++;
        }
        Threads []threads = new Threads[NumberOfThreads];
        int l = 0;
        while(!S.isEmpty()){
            struct s = S.pop();
            threads[l] = new Threads(s.start, s.last, list, predicate);
            threads[l].start();
            l++;
        }
        for(int k = 0; k < threads.length; k++){
            if(threads[k] != null) {
                try {
                    threads[k].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        int count = 0;
        for(int o = 0; o < NumberOfThreads; o++){
            count += threads[o].getCount();
        }
        if(count == list.size() || (!flag && count > 0))
            return true;
        return false;
    }
}

