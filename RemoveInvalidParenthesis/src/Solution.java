import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty()) {
            String str = queue.poll();
            if(isValid(str)) {
                res.add(str);
                found = true;
            }
            if(found) {
                continue;
            }
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                String sub = str.substring(0, i) + str.substring(i + 1);
                if(!visited.contains(sub)) {
                    queue.add(sub);
                    visited.add(sub);
                }
            }//循环先去一个元素，再看是否是valid 如果去一个元素里的所有集合中没有valid，则去第二个元素。
        }
        return res;
    }
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            }if(c == ')') {
                if(count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();

        if(start > end){
            rst.add(null);
            return rst;
        }

        for(int i=start; i<=end; i++){
            ArrayList<TreeNode> left = generate(start, i-1);
            ArrayList<TreeNode> right = generate(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){
// should new a root here because it need to
// be different for each tree
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        levelOrderHelper(root, res, 0);
        return res;
    }
    private void levelOrderHelper(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) {
            return;
        }
        if(level >= res.size()) {
            res.add(0, new ArrayList<Integer>());
        }
        levelOrderHelper(root.left, res, level + 1);
        levelOrderHelper(root.right, res, level + 1);
        res.get(res.size() - level - 1).add(root.val);
    }
    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        // Morris Traversal
        TreeNode temp = null;
        while(root!=null){
            if(root.left!=null){
                // connect threading for root
                temp = root.left;
                while(temp.right!=null && temp.right != root)
                    temp = temp.right;
                // the threading already exists
                if(temp.right!=null){
                    if(pre!=null && pre.val > root.val){
                        if(first==null){first = pre;second = root;}
                        else{second = root;}
                    }
                    pre = root;

                    temp.right = null;
                    root = root.right;
                }else{
                    // construct the threading
                    temp.right = root;
                    root = root.left;
                }
            }else{
                if(pre!=null && pre.val > root.val){
                    if(first==null){first = pre;second = root;}
                    else{second = root;}
                }
                pre = root;
                root = root.right;
            }
        }
        // swap two node values;
        if(first!= null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isVisit = new boolean[m][n];
        int len = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                isVisit[i][j] = true;
                len = Math.max(len, pathAcc(matrix, isVisit, i, j, len));
                isVisit[i][j] = false;
            }
        }
        return len;
    }
    private int pathAcc(int[][] matrix, boolean[][] isVisit, int x, int y, int len) {
        for(int i = 0; i < dir.length; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if(newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && !isVisit[newX][newY] && matrix[newX][newY] > matrix[x][y]) {
                isVisit[newX][newY] = true;
                len += 1;
                len = Math.max(len, pathAcc(matrix, isVisit, newX, newY, len));
                len -= 1;
                isVisit[newX][newY] = false;
            }
        }
        return len;
    }
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0 || k < 0) {
            return -1;
        }
        PriorityQueue<Point> queue = new PriorityQueue<Point>(2, new PointComparator());
        HashSet<String> set = new HashSet<String>();
        Point min = new Point(0, 0, A[0] + B[0]);
        queue.offer(min);
        set.add(min.x + "," + min.y);

        int n = A.length;
        int m = B.length;

        for (int i = 0; i < k - 1; i++) {
            min = queue.poll();

            if (min.x + 1 < n) {
                Point newP = new Point(min.x + 1, min.y, A[min.x + 1] + B[min.y]);
                if (!set.contains(newP.x + "," + newP.y)) {
                    set.add(newP.x + "," + newP.y);
                    queue.offer(newP);
                }
            }
            if (min.y + 1 < m) {
                Point newP = new Point(min.x, min.y + 1, A[min.x] + B[min.y + 1]);
                if (!set.contains(newP.x + "," + newP.y)) {
                    set.add(newP.x + "," + newP.y);
                    queue.offer(newP);
                }
            }
        }

        min = queue.poll();
        return min.val;
    }

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MAX_VALUE;
        }
        Queue<Node> queue =  new PriorityQueue<Node>(k, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.value - b.value;
            }
        });
        for(int i = 0; i < matrix.length; i++) {
            queue.add(new Node(0, matrix[i][0], i));
        }
        for(int i = 0; i < k; i++) {
            Node tmp = queue.poll();
            int index = tmp.index;
            int value = tmp.value;
            int id = tmp.id;
            if(i == k - 1) {
                return value;
            }
            if(index < matrix[id].length - 1){
                index = index + 1;
                value = matrix[id][index];
                queue.add(new Node(index, value, id));
            }
        }
        return Integer.MAX_VALUE;

    }
    class Node{
        int index;
        int value;
        int id;
        public Node(int index, int value, int id) {
            this.index = index;
            this.value = value;
            this.id = id;
        }
    }
}
class Point{
    int x, y, val;
    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return a.val - b.val;
    }
}