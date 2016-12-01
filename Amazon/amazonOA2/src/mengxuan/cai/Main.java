package mengxuan.cai;

/**
 * Created by feideng on 11/22/16.
 */
public class Main {
    public static void main(String[] args) {

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
//        System.out.println(bs.miniPath(root));

        // reverse the sedond part
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
//        //l5.next = l6;
//        ReverseSecondPart r = new ReverseSecondPart();
//        r.reverse(l1);
//        while(l1!= null) {
//
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }
        // TreeAmplitute
//        TreeNode root = new TreeNode(5);
//        TreeNode left1 = new TreeNode(3);
//        TreeNode left2 = new TreeNode(3);
//        TreeNode left3 = new TreeNode(4);
//        TreeNode right1 = new TreeNode(6);
//        root.left = left1;
//        root.right = right1;
//        left1.left = left2;
//        left1.right = left3;
//
//        TreeAmplitute tl = new TreeAmplitute();
//        System.out.println(tl.TreeAmplitude(root));

//        Node root = new Node(1);
//        Node l21 = new Node(2);
//        Node l22 = new Node(3);
//        Node l23 = new Node(4);
//        Node l31 = new Node(5);
//        Node l32 = new Node(5);
//        Node l33 = new Node(5);
//        Node l34 = new Node(5);
//        Node l35 = new Node(5);
//        Node l36 = new Node(5);
//
//        l21.children.add(l31);
//        l21.children.add(l32);
//
//        l22.children.add(l33);
//        l22.children.add(l34);
//
//        l23.children.add(l35);
//        l23.children.add(l36);
//
//        root.children.add(l21);
//        root.children.add(l22);
//        root.children.add(l23);
//        MaximumSubtreeofAverage msa = new MaximumSubtreeofAverage();
//        Node res = msa.getHighAve(root);
//        System.out.println(res.val + " " + msa.
//                resAve);
        LongestPalindrome lp = new LongestPalindrome();
        String s = "abcddcbjjjjj";
        System.out.println(lp.longestPalindrome(s));

    }
}
