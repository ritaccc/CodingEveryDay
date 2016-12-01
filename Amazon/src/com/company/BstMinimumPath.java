package com.company;

/**
 * Created by feideng on 11/15/16.
 */
public class BstMinimumPath {
    public int bstMinimumPath(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right != null) {
            return bstMinimumPath(root.right) + root.val;
        }else if(root.left != null && root.right == null) {
            return bstMinimumPath(root.left) + root.val;
        }
        return Math.min(bstMinimumPath(root.left), bstMinimumPath(root.right)) + root.val;
    }
}
