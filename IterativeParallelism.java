package org.lab10;

import java.util.*;

public class IterativeParallelism  {

    private static class Treads extends Thread {

        LinkedList<Integer> l;
        Integer MM = 0;
        int start;
        int end;
        Comparator compar;

        public Treads(int s, int e, LinkedList<Integer> list, Comparator c){
            start = s; end = e; l = list; compar = c;
        }

        public void run() {
            int res = 0;
            int i = 0; boolean flag = false;
            Iterator<Integer> it = l.iterator();
            while(it.hasNext()){
                if(i > end)
                    break;
                int cur = it.next();
                if(i == start && !flag) {
                    res = cur;
                    flag = true;
                }
                if(flag){
                    if(compar.compare(cur, res) >= 0)
                        res = cur;
                }
                i++;
            }
            MM = res;
        }

        public int getMinMax(){return MM;}
    }

    int MinMax(int treadsNum, LinkedList<Integer> list, Comparator comparator) {
        ArrayDeque<struct> S = new ArrayDeque<struct>();

        int separator = (int)((double)list.size() / (double)treadsNum);
        int end = separator * treadsNum;

        Iterator<Integer> it = list.iterator();
        int first = 0, last = 0;

        //разделяем лист на равные или не равные части(зависит от колличества потоков).
        int i = 0, j = 0; int p = 0;
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

        int []array = new int[treadsNum]; //массив для храниния кандидатов на min/max.
        Treads []threads = new Treads[treadsNum];
        int l = 0;

        //В каждой части ищем минимум/максимум. Каждый поток выдаст кандидата на мин/макс, затем из них уже ищем результат.
        while(!S.isEmpty()){
            struct s = S.pop();
            threads[l] = new Treads(s.start, s.last, list, comparator);
            threads[l].start();
            l++;
        }
        //ждём, чтобы все потоки завершились
        for(int k = 0; k < threads.length; k++){
            if(threads[k] != null) {
                try {
                    threads[k].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        for(int k = 0; k < threads.length; k++){
            if(threads[k] != null)
                array[k] = threads[k].getMinMax();
        }
        int res = minmax(array, comparator);

        return res;
    }

    int minmax(int []a, Comparator c){
        int m = a[0];
        for(int i = 0; i < a.length; i++){
            if(c.compare(m, a[i]) <= 0)
                m = a[i];
        }
        return m;
    }
}
