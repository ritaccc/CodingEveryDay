package com.company;

/**
 * Created by feideng on 11/16/16.
 */
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class Test {


    public List<Order> getOrderList(List<OrderPair> orderPairs) {

        if(orderPairs == null || orderPairs.size() == 0) {
            return new ArrayList<>();
        }

        List<Order> res = new ArrayList<>();
        HashMap<Order, List<Order>> map = new HashMap<>();
        HashMap<Order, Integer> inMap = new HashMap<>();
        Set<Order> nodeSet = new HashSet<Order>();
        preProcessing(orderPairs, map, inMap, nodeSet);
        Queue<Order> q = new LinkedList<>();
        int size = nodeSet.size();
        for(Order o: inMap.keySet()) {
            if(inMap.get(o) == 0) {
                q.offer(o);
            }
        }
        while(!q.isEmpty()) {
            Order order = q.poll();
            res.add(order);
            for(Order subOrder: map.get(order)) {
                inMap.put(subOrder, inMap.get(subOrder) - 1);
                if(inMap.get(subOrder) == 0){
                    q.offer(subOrder);
                }
            }

        }
        if(res.size() != size) {
            return new ArrayList<>();
        }
        return res;
    }
    private void preProcessing(List<OrderPair> orderPairs,
                               HashMap<Order, List<Order>> map,
                               HashMap<Order, Integer> inMap, Set<Order> nodeSet) {
        for(OrderPair op: orderPairs) {
            Order cur = op.cur;
            Order pre = op.pre;
            nodeSet.add(cur);
            nodeSet.add(pre);
            if (!map.containsKey(pre)) {
                map.put(pre, new ArrayList<>());
            }
            map.get(pre).add(cur);
            if(!map.containsKey(cur)) {
                map.put(cur, new ArrayList<>());
            }

            if(inMap.containsKey(cur)){
                int indegree = inMap.get(cur);
                inMap.put(cur, indegree + 1);
            }else {
                inMap.put(cur, 1);
            }
            if(!inMap.containsKey(pre)) {
                inMap.put(pre, 0);
            }

        }
    }
}

