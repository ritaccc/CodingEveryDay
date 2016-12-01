package com.company;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by feideng on 11/15/16.
 */
public class OrderPair {
    Order cur;
    Order pre;
    public OrderPair(Order cur, Order pre)
    {
        this.cur = cur;
        this.pre = pre;
    }
}
