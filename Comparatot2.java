package org.lab10;

import java.util.Comparator;

/**
 * Created by Alena on 28.05.2017.
 */
public class Comparatot2 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 == o2)
            return 0;
        else if(o1 > o2)
            return -1;
        return 1;
    }
}
