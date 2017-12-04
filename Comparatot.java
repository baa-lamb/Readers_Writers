package org.lab10;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Alena on 24.05.2017.
 */
public class Comparatot implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == o2)
            return 0;
        else if (o1 < o2)
            return -1;
        return 1;
    }
}