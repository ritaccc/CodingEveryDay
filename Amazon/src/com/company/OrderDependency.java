package com.company;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

/**
 * Created by feideng on 11/15/16.
 */
public class OrderDependency {
    Set<Order> visited = new HashSet<Order>();
    HashMap<Order, HashSet<Order>> map = new HashMap<Order, HashSet<Order>>();
    Stack<Order> orderStack = new Stack<Order>();

    public List<Order> getOrderList(List<OrderPair> orderPairs) {
        if(orderPairs == null || orderPairs.size() == 0) {
            return new ArrayList<>();
        }
        preProcessing(orderPairs);
        List<Order> res = new ArrayList<>();
        boolean cycle = true;
       for(Order o :map.keySet()){
            if(!visited.contains(o)) {
               cycle = cycle && dfs(o);
            }
        }


        if(visited.size() != map.size()) {
            return res;
        }
        while(!orderStack.isEmpty()) {
            res.add(orderStack.pop());
        }

        return res;
    }
    private boolean dfs(Order o) {
        Set<Order> set = map.get(o);
        for(Order  curOrder: set) {
            if(!visited.contains(curOrder)) {
                dfs(curOrder);

            }else {
                return true;
            }
        }
        orderStack.add(o);
        visited.add(o);
        return false;

    }

    private void preProcessing(List<OrderPair> orderPairs) {
        for(OrderPair op: orderPairs) {
            if(!map.containsKey(op.pre)) {
                map.put(op.pre, new HashSet<>());
            }
            map.get(op.pre).add(op.cur);
            if(!map.containsKey(op.cur)) {
                map.put(op.cur, new HashSet<>());
            }

        }

    }
}
