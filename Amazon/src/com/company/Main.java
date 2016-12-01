
package com.company;

import com.sun.jndi.rmi.registry.RemoteReference;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DoubleDV;
import com.sun.org.apache.xpath.internal.FoundIndex;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class Main {

    public static void main(String[] args) {

//        Order o1 = new Order("A");
//        Order o2 = new Order("B");
//        Order o3 = new Order("C");
//        Order o4 = new Order("D");
//        Order o5 = new Order("F");
//        OrderPair od1 = new OrderPair(o1, o2);
//
//        OrderPair od2 = new OrderPair(o2, o3);
//        OrderPair od3 = new OrderPair(o3, o4);
//        List<OrderPair> ls = new ArrayList<>();
//        ls.add(od1);
//        ls.add(od2);
//        ls.add(od3);
//        OrderDependency od = new OrderDependency();
//
//        for(Order o: od.getOrderList(ls)) {
//            System.out.println(o.order);
//        }
//        Node root = new Node(1);
//        Node a = new Node(2);
//        Node b = new Node(3);
//        Node d = new Node(4);
//        Node e = new Node(5);
//
//        Node f = new Node(5);
//        Node g = new Node(5);
//        Node h = new Node(5);
//        Node i = new Node(5);
//        Node j = new Node(5);
//        a.children.add(e);
//        a.children.add(f);
//        b.children.add(g);
//        b.children.add(h);
//        d.children.add(i);
//        d.children.add(j);
//
//        root.children.add(a);
//        root.children.add(b);
//        root.children.add(d);
//        MaximumSubtree ma =  new MaximumSubtree();
//        Node node = ma.getHighAve(root);
//        System.out.println(node.val + "!~!!" + ma.resAvg);
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        Reverse r = new Reverse();
//        r.reverseSec(l1);
//        while(l1!= null) {
//
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        RotateMatrix rm = new RotateMatrix();
//        int[][] res = rm.rotate(matrix, 1);
//        System.out.println(res);
//        HashMap<Integer, Integer> map = new HashMap<>();
//        System.out.println(map.size());
            // bst mini path
//        TreeNode root = new TreeNode(5);
//        TreeNode left1 = new TreeNode(3);
//        TreeNode left2 = new TreeNode(3);
//        TreeNode left3 = new TreeNode(4);
//        TreeNode right1 = new TreeNode(6);
//        root.left = left1;
//        root.right = right1;
//        left1.left = left2;
//        left1.right = left3;
//        BstMinimumPath bs = new BstMinimumPath();
//        System.out.println(bs.bstMinimumPath(root));

//        TwoSumCount ts = new TwoSumCount();
//        int count = ts.twoSumCount(new int[]{1,1,2,3,4,5}, 5);
//        System.out.println(count);

//
//        FindOptimalWeight fo = new FindOptimalWeight();
//        double capacity = 35;
//        double[] weights = {10,24,30,9,19,23,7};
//        Container c = fo.FindOptimalWeight(35, weights);
//        System.out.println(c.first +"hello " + c.second);


//        RemoveVowel rv = new RemoveVowel();
//        System.out.println(rv.removeVowel("helloworld"));

//        GCD gcd = new GCD();
//        System.out.println(gcd.solution(new int[]{6,12,15,18
//        }));

//        TreeNode root = new TreeNode(1);
//        TreeNode l = new TreeNode(2);
//        TreeNode r = new TreeNode(3);
//        TreeNode le = new TreeNode(4);
//        root.left = l;
//        l.left = le;
//        l.right = r;
//
//        TreeNode lef = new TreeNode(2);
//        TreeNode ri = new TreeNode(3);
//        TreeNode righte = new TreeNode(5);
//        lef.right = ri;
//        ri.right = righte;
//        TreeAmplitude ta = new TreeAmplitude();
//        int res = ta.TreeAmplitude(root);
//        System.out.println(res);
//        ArithmeticSequence as = new ArithmeticSequence();
//        System.out.println(as.arithmeticSeq(new int[]{1,2,3,4}));
//

//            ListNode a = new ListNode(2);
//        ListNode b = new ListNode(3);
//        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = a;
//        CycleLinkedList cl = new CycleLinkedList();
//        ListNode n = cl.detectCyle(a, 4);
//        ListNode m = cl.detectCyle(a, 1);
//        System.out.println(n.next.val);
//        System.out.println(m.next.val);
//        LRUMiss lm = new LRUMiss();
//        System.out.println(lm.countMiss(new int[]{1,2,3,4,5,4,2,1}, 4));
//        int[] req = new int[]{0, 1, 4};
//        int[] exe = new int[]{5, 2, 3};
//        ShortestJobFirst sb = new ShortestJobFirst();
//        System.out.println(sb.solution(req, exe));
//        FourInteger fi = new FourInteger();
//        int[] a = fi.solution(1,2,3,5);
//        for(int b: a) {
//            System.out.println(b);
//        }
//        MinimumPath mp = new MinimumPath();
//        int[][] matrix = new int[][]{{8,4,7},{6,5,9}};
//        System.out.println(mp.maxMinPath(matrix));

//        Order oA = new Order("A");
//        Order oB = new Order("B");
//        Order oC = new Order("C");
//        Order oD = new Order("D");
//        Order oE = new Order("F");
//        List<OrderPair> ls = new ArrayList<>();
//
//        OrderPair od1 = new OrderPair(oB, oA);
//        OrderPair od3 = new OrderPair(oC, oA);
//        OrderPair od2 = new OrderPair(oC, oB);
//        OrderPair od4 = new OrderPair(oD, oC);
//
//        ls.add(od1);
//        ls.add(od2);
//        ls.add(od3);
//        ls.add(od4);
//        Test od = new Test();
//
//        for(Order o: od.getOrderList(ls)) {
//            System.out.println(o.order);
//        }
//        int[] days = {1,0,0,0,0,1,0,0};
//        DayChange dc = new DayChange();
//        int[] res = dc.solution(days, 1);
//        for(int i = 0; i < res.length;i++) {
//            System.out.println(res[i]);
////        }
//
// int[][] matrix = {{0,0,0,1}, {0,1,0,1}, {0, 0,0,0},{1, 0, 0, 9}};
//        Maze ma = new Maze();
//        System.out.println(ma.maze(matrix));
//        String t1 = "abc";
//
//      String t2 = "cdb";
//        RotateString rs = new RotateString();
//        System.out.println(rs.rotate(t1, t2));
//
//        Connection[] citys = new Connection[10];
//        citys[0] = new Connection("A", "B", 6);
//        citys[1] = new Connection("A", "D", 1);
//        citys[2] = new Connection("A", "E", 5);
//        citys[3] = new Connection("B", "C", 3);
//        citys[4] = new Connection("B", "D", 5);
//        citys[5] = new Connection("C", "D", 6);
//        citys[6] = new Connection("C", "F", 6);
//        citys[7] = new Connection("D", "F", 4);
//        citys[8] = new Connection("D", "E", 5);
//        citys[9] = new Connection("E", "F", 2);
		/*
		citys[10] = new Connection("X", "Y", 1);
		citys[11] = new Connection("X", "Z", 2);
		citys[12] = new Connection("Y", "Z", 3);
		*/
//        ArrayList<Connection> list = new ArrayList<Connection>();
//        for (Connection temp : citys) {
//            list.add(temp);
//        }
//        SpiningTree st = new SpiningTree();
//        List<Connection> res = st.solution(list);
//        System.out.println(st.solution(list));
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String t = "ABCCED";
        Solution so = new Solution();
        System.out.println(so.exist(board, t));

    }



}