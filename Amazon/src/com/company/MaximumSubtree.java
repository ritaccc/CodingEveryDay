package com.company;

/**
 * Created by feideng on 11/15/16.
 */
class SumCount {
    int sum;
    int count;
    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;

    }
}
public class MaximumSubtree {
    public double resAvg = Double.MIN_VALUE;
    private Node result;
    public Node getHighAve(Node root) {
        if(root == null) {
            return root;
        }
        dfs(root);
        return result;
    }
    private SumCount dfs(Node root) {
        if(root.children == null || root.children.size() == 0) {
            return new SumCount(root.val, 1);
        }
        int curSum = root.val;
        int curCount = 1;
        for(Node child: root.children){
            SumCount childSumCount= dfs(child);
            curSum += childSumCount.sum;
            curCount += childSumCount.count;
        }
        double curAve = (double)curSum / curCount;
        if(resAvg < curSum) {
            resAvg = curSum;
            result = root;
        }
        return new SumCount(curSum, curCount);
    }
}
