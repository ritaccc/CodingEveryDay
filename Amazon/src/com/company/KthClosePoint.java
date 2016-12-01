package com.company;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by feideng on 11/13/16.
 */
public class KthClosePoint {
    public List<Point> KClosePoint(Point[] array, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (o2.x * o2.x + o2.y * o2.y) - (o1.x * o1.x + o1.y * o1.y);
            }
        });
        for(int i = 0; i < array.length; i++) {
            if(i < k) {
                pq.offer(array[i]);
            }else {
                Point peekTop = pq.peek();
                if(array[i].x * array[i].x + array[i].y * array[i].y - peekTop.x * peekTop.x - peekTop.y * peekTop.y <= 0) {
                        pq.poll();
                        pq.add(array[i]);
                }
            }
        }
        List<Point> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}
