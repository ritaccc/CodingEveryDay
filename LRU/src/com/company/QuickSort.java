package com.company;
import java.util.*;

/**
 * Created by feideng on 10/19/16.
 */
public class QuickSort {
    Number[] numbers= new Number[8];
    public QuickSort(){
        Set<Number> set = new HashSet<>();
        while (set.size() < 8) {
            Number rd = new Number((int)(Math.random() * 21));
            if (set.contains(rd)) {
                continue;
            }
            set.add(rd);
        }
        numbers = set.toArray(new Number[8]);
    }
    public Number[] returnn() {
        return numbers;
    }
}
