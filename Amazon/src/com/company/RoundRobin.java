package com.company;

/**
 * Created by feideng on 11/16/16.
 */
import java.util.*;
public class RoundRobin {
    public float solution(int[] req, int[] exe, int q){
        if(req == null || exe == null || req.length != exe.length) {
            return 0;
        }
        int len = req.length;
        Queue<Process> queue = new LinkedList<>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while(!queue.isEmpty() || index < len) {
            if(!queue.isEmpty()) {
                Process p = queue.poll();
                waitTime += curTime - p.cur;
                //curTime += p.exe;
                curTime = Math.min(q, curTime);
                while(index < len && curTime > req[index]) {






                    queue.offer(new Process(req[index], exe[index]));
                    index++;
                }
                if(p.exe > q) {
                    queue.offer(new Process(curTime, p.exe - q));
                }
            }else {
                queue.offer(new Process(req[index], exe[index]));
                curTime = req[index++];
            }

        }
        return (float) waitTime/len;
    }

}
