package com.company;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by feideng on 11/15/16.
 */
public class HighFive {
    public HashMap<Integer, Double> getHighFive(Result[] results){
        HashMap<Integer, Double> res = new HashMap<>();
        Map<Integer, List<Integer>> preProcessing = new HashMap<>();
        for(Result r: results) {
            if(!preProcessing.containsKey(r.id)) {
                preProcessing.put(r.id, new ArrayList<>());
            }
            preProcessing.get(r.id).add(r.value);
        }
        for(Integer id: preProcessing.keySet()) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5, new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return i1 - i2;
                }
            });
            List<Integer> ls = preProcessing.get(id);
            for(int k = 0; k < ls.size(); k++)
            {
                if(k < 5) {
                    pq.add(ls.get(k));
                }else {
                    if(ls.get(k) >  pq.peek()) {
                        pq.poll();
                        pq.add(ls.get(k));

                    }
                }



            }
            double avg = 0.0;
            while(!pq.isEmpty()) {
                avg += pq.poll();
            }
            avg = avg/ 5.0;
            res.put(id, avg);

        }
        return res;

    }
}
