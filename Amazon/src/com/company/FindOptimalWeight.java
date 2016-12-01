package com.company;

/**
 * Created by feideng on 11/15/16.
 */
import java.util.*;
public class FindOptimalWeight {
    public Container FindOptimalWeight(double capacity, double[] weights) {
        double min = 0.0;
        int minPos = 0;
        int maxpos = weights.length - 1;
        Arrays.sort(weights);
        int i = 0, j = weights.length -1;
        while(i < j) {
            double sum = weights[i] + weights[j];
            if(sum > min && sum <= capacity) {
                min = sum;
                minPos = i;
                maxpos = j;
            }
            if(sum > capacity){
                j--;
            }else {
                i++;
            }
        }
        Container c = new Container();
        c.first = weights[minPos];
        c.second = weights[maxpos];
        return c;
    }

}
