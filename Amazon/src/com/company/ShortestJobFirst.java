package com.company;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by feideng on 11/16/16.
 */
public class ShortestJobFirst {
    class Process{
        int arrTime;
        int exeTime;
        Process(int arrTime, int exeTime) {
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }
    public float solution(int[] req, int[] exe) {
        if(req == null || exe == null || req.length != exe.length) {
            return 0;
        }
        int index = 0, length = req.length;
        int waitTime = 0, curTime = 0;
        PriorityQueue<Process> pq = new PriorityQueue<Process>(new Comparator<Process>(){
            @Override
            public int compare(Process p1, Process p2) {
                if(p1.exeTime == p2.exeTime) {
                    return p1.arrTime - p2.arrTime;
                }
                return p1.exeTime - p2.exeTime;
            }

        });
        while(!pq.isEmpty() || index < length) {
            if(!pq.isEmpty()) {
                Process cur = pq.poll();
                waitTime += curTime - cur.arrTime;
                curTime += cur.exeTime;
                while(index < length && curTime > req[index]) {
                    pq.add(new Process(req[index], exe[index]));
                    index++;
                }
            }else{
                pq.offer(new Process(req[index], exe[index]));
                curTime = req[index++];
            }
        }
        return (float) waitTime / length;

    }
}
