package com.company;

import apple.laf.JRSUIUtils;

/**
 * Created by feideng on 11/15/16.
 */
public class CheckSubtree {
    public boolean checkSubtree(TreeNode t1, TreeNode t2) {
        if(t2 == null) {
            return true;
        }
        if(t1 == null) {
            return false;
        }
        return checkSubtree(t1.left, t2)|| checkSubtree(t1.right, t2)|| isSameTree(t1, t2);
    }
    private boolean isSameTree(TreeNode root, TreeNode sub) {
        if(sub == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(root.val != sub.val) {
            return false;
        }
        return(isSameTree(root.left, sub.left)) && (isSameTree(root.right, sub.right));
    }

}
