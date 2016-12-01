package mengxuan.cai;

import java.util.*;

/**
 * Created by feideng on 11/22/16.
 */
public class Node {
//    double x;
//    double y;
//    public Node(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}
